/*
 * nyroModal v2.0.0
 * Core
 *
 */
jQuery(function($, undefined) {

	var uaMatch = function(ua) {
		ua = ua.toLowerCase();
		var match = /(chrome)[ \/]([\w.]+)/.exec( ua ) ||
			/(webkit)[ \/]([\w.]+)/.exec( ua ) ||
			/(opera)(?:.*version|)[ \/]([\w.]+)/.exec( ua ) ||
			/(msie) ([\w.]+)/.exec( ua ) ||
			ua.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec( ua ) ||
			[];

		return {
			browser: match[ 1 ] || "",
			version: match[ 2 ] || "0"
		};
	},
	matched = uaMatch(navigator.userAgent),
	browser = {};

	if (matched.browser) {
		browser[matched.browser] = true;
		browser.version = matched.version;
	}

	// Chrome is Webkit, but Webkit is also Safari.
	if (browser.chrome) {
		browser.webkit = true;
	} else if (browser.webkit) {
		browser.safari = true;
	}

	var $w = $(window),
		$d = $(document),
		$b = $('body'),
		baseHref = $('base').attr('href'),
		// nyroModal Object
		_nmObj = {
			filters: [],	// List of filters used
			callbacks: {},	// Sepcific callbacks
			anims: {},	// Sepcific animations functions
			loadFilter: undefined,	// Name of the filter used for loading

			enabled: true, // Indicates if it's enabled or not
			modal: false,	// Indicates if it's a modal window or not
			closeOnEscape: true,	// Indicates if the modal should close on Escape key
			closeOnClick: true,	// Indicates if a click on the background should close the modal
			useKeyHandler: false,	// Indicates if the modal has to handle key down event

			showCloseButton: true,	// Indicates if the closeButonn should be added
			closeButton: '<a href="#" class="nyroModalClose nyroModalCloseButton nmReposition" title="close">Close</a>',	// Close button HTML

			stack: false,	// Indicates if links automatically binded inside the modal should stack or not
			nonStackable: 'form',	// Filter to not stack DOM element

			header: undefined,	// header include in every modal
			footer: undefined,	// footer include in every modal
			
			// Specific confirguation for gallery filter
			galleryLoop: true,	// Indicates if the gallery should loop
			galleryCounts: true,	// Indicates if the gallery counts should be shown
			ltr: true, // Left to Right by default. Put to false for Hebrew or Right to Left language. Used in gallery filter

			// Specific confirguation for DOM filter
			domCopy: false, // Indicates if DOM element should be copied or moved
			
			// Specific confirguation for link and form filters
			ajax: {}, // Ajax options to be used in link and form filter
			
			// Specific confirguation for image filter
			imageRegex: '[^\.]\.(jpg|jpeg|png|tiff|gif|bmp)\\s*$',	// Regex used to detect image link

			selIndicator: 'nyroModalSel', // Value added when a form or Ajax is sent with a filter content

			swfObjectId: undefined, // Object id for swf object
			swf:  {	// Default SWF attributes
				allowFullScreen: 'true',
				allowscriptaccess: 'always',
				wmode: 'transparent'
			},

			store: {},	// Storage object for filters.
			errorMsg: 'An error occured',	// Error message
			elts: {	// HTML elements for the modal
				all: undefined,
				bg: undefined,
				load: undefined,
				cont: undefined,
				hidden: undefined
			},
			sizes: {	// Size information
				initW: undefined,	// Initial width
				initH: undefined,	// Initial height
				w: undefined,		// width
				h: undefined,		// height
				minW: undefined,	// minimum Width
				minH: undefined,	// minimum height
				maxW: undefined,	// maximum width
				maxH: undefined,	// maximum height
				wMargin: undefined,	// Horizontal margin
				hMargin: undefined	// Vertical margin
			},
			anim: {	// Animation names to use
				def: undefined,			// Default animation set to use if sspecific are not defined or doesn't exist
				showBg: undefined,		// Set to use for showBg animation
				hideBg: undefined,		// Set to use for hideBg animation
				showLoad: undefined,	// Set to use for showLoad animation
				hideLoad: undefined,	// Set to use for hideLoad animation
				showCont: undefined,	// Set to use for showCont animation
				hideCont: undefined,	// Set to use for hideCont animation
				showTrans: undefined,	// Set to use for showTrans animation
				hideTrans: undefined,	// Set to use for hideTrans animation
				resize: undefined		// Set to use for resize animation
			},

			_open: false,	// Indicates if the modal is open
			_bgReady: false,	// Indicates if the background is ready
			_opened: false,	// Indicates if the modal was opened (useful for stacking)
			_loading: false,	// Indicates if the loading is shown
			_animated: false,	// Indicates if the modal is currently animated
			_transition: false,	//Indicates if the modal is in transition
			_needClose: false, // Indicates if the modal should close after current animation
			_nmOpener: undefined,	// nmObj of the modal that opened the current one in non stacking mode
			_nbContentLoading: 0,	// Counter for contentLoading call
			_scripts: '',	// Scripts tags to be included
			_scriptsShown: '',	//Scripts tags to be included once the modal is swhon

			// save the object in data
			saveObj: function() {
				this.opener.data('nmObj', this);
			},
			// Open the modal
			open: function() {
				if (!this.enabled)
					return false;
				if (this._nmOpener)
					this._nmOpener._close();
				this.getInternal()._pushStack(this.opener);
				this._opened = false;
				this._bgReady = false;
				this._open = true;
				this._initElts();
				this._load();
				this._nbContentLoading = 0;
				this._callAnim('showBg', $.proxy(function() {
					this._bgReady = true;
					if (this._nmOpener) {
						// fake closing of the opener nyroModal
						this._nmOpener._bgReady = false;
						this._nmOpener._loading = false;
						this._nmOpener._animated = false;
						this._nmOpener._opened = false;
						this._nmOpener._open = false;
						this._nmOpener.elts.cont = this._nmOpener.elts.hidden = this._nmOpener.elts.load = this._nmOpener.elts.bg = this._nmOpener.elts.all = undefined;
						this._nmOpener.saveObj();
						this._nmOpener = undefined;
					}
					this._contentLoading();
				}, this));
			},

			// Resize the modal according to sizes.initW and sizes.initH
			// Will call size function
			// @param recalc boolean: Indicate if the size should be recalaculated (useful when content has changed)
			resize: function(recalc) {
				if (recalc) {
					this.elts.hidden.append(this.elts.cont.children().first().clone());
					this.sizes.initW = this.sizes.w = this.elts.hidden.width();
					this.sizes.initH = this.sizes.h = this.elts.hidden.height();
					this.elts.hidden.empty();
				} else {
					this.sizes.w = this.sizes.initW;
					this.sizes.h = this.sizes.initH;
				}
				this._unreposition();
				this.size();
				this._callAnim('resize', $.proxy(function() {
					this._reposition();
				}, this));
			},

			// Update sizes element to not go outsize the viewport.
			// Will call 'size' callback filter
			size: function() {
				var maxHeight = this.getInternal().fullSize.viewH - this.sizes.hMargin,
					maxWidth = this.getInternal().fullSize.viewW - this.sizes.wMargin;
				
				if (typeof this.sizes.maxH !== 'undefined' && this.sizes.maxH < maxHeight) 
					maxHeight = this.sizes.maxH;
				if (typeof this.sizes.maxW !== 'undefined' && this.sizes.maxW < maxWidth) 
					maxWidth = this.sizes.maxW;
				
				if (this.sizes.minW && this.sizes.minW > this.sizes.w)
					this.sizes.w = this.sizes.minW;
				if (this.sizes.minH && this.sizes.minH > this.sizes.h)
					this.sizes.h = this.sizes.minH;
				if (this.sizes.h > maxHeight || this.sizes.w > maxWidth) {
					// We're gonna resize the modal as it will goes outside the view port
					this.sizes.h = Math.min(this.sizes.h, maxHeight);
					this.sizes.w = Math.min(this.sizes.w, maxWidth);
				}
				this._callFilters('size');
			},

			// Get the nmObject for a new nyroModal
			getForNewLinks: function(elt) {
				var ret;
				if (this.stack && (!elt || this.isStackable(elt))) {
					ret = $.extend(true, {}, this);
					ret._nmOpener = undefined;
					ret.elts.all = undefined;
				} else {
					ret = $.extend({}, this);
					ret._nmOpener = this;
				}
				ret.filters = [];
				ret.opener = undefined;
				ret._open = false;
				return ret;
			},
			
			// Indicate if an element can be stackable or not, regarding the nonStackable setting
			isStackable: function(elt) {
				return !elt.is(this.nonStackable);
			},

			// key handle function.
			// Will call 'keyHandle' callback filter
			keyHandle: function(e) {
				this.keyEvent = e;
				this._callFilters('keyHandle');
				this.keyEvent = undefined;
				delete(this.keyEvent);
			},

			// Get the internal object
			getInternal: function() {
				return _internal;
			},

			// Internal function for closing a nyroModal
			// Will call 'close' callback filter
			_close: function() {
				var ret = true;
				if (!this._animated) {
					$.each(this._callFilters('close'), function(k, v) {
						if (v === false)
							ret = false;
					});
					if (ret) {
						this.getInternal()._removeStack(this.opener);
						this._opened = false;
						this._open = false;
					}
				} else {
					this._needClose = true;
					ret = false;
				}
				return ret;
			},
			// Public function for closing a nyroModal
			close: function() {
				if (this._close()) {
					this._needClose = false;
					this._callFilters('beforeClose');
					var self = this;
					this._unreposition();
					self._callAnim('hideCont', function() {
						self._callAnim('hideLoad', function() {
							self._callAnim('hideBg', function() {
								self._callFilters('afterClose');
								self.elts.cont.remove();
								self.elts.hidden.remove();
								self.elts.load.remove();
								self.elts.bg.remove();
								self.elts.all.remove();
								self.elts.cont = self.elts.hidden = self.elts.load = self.elts.bg = self.elts.all = undefined;
							});
						});
					});
				}
			},
			
			// Public function for destroying a nyroModal instance, only for non open modal
			destroy: function() {
				if (this._open)
					return false;
				this._callFilters('destroy');
				if (this.elts.all)
					this.elts.all.remove();
				return true;
			},

			// Init HTML elements
			_initElts: function() {
				if (!this.stack && this.getInternal().stack.length > 1)
					this.elts = this.getInternal().stack[this.getInternal().stack.length-2]['nmObj'].elts;
				if (!this.elts.all || this.elts.all.closest('body').length == 0)
					this.elts.all = this.elts.bg = this.elts.cont = this.elts.hidden = this.elts.load = undefined;
				if (!this.elts.all)
					this.elts.all = $('<div />').appendTo(this.getInternal()._container);
				if (!this.elts.bg)
					this.elts.bg = $('<div />').hide().appendTo(this.elts.all);
				if (!this.elts.cont)
					this.elts.cont = $('<div />').hide().appendTo(this.elts.all);
				if (!this.elts.hidden)
					this.elts.hidden = $('<div />').hide().appendTo(this.elts.all);
				this.elts.hidden.empty();
				if (!this.elts.load)
					this.elts.load = $('<div />').hide().appendTo(this.elts.all);
				this._callFilters('initElts');
			},

			// Trigger the error
			// Will call 'error' callback filter
			_error: function(jqXHR) {
				this._callFilters('error', jqXHR);
			},

			// Set the HTML content to show.
			// - html: HTML content
			// - selector: selector to filter the content
			// Will init the size and call the 'size' function.
			// Will call 'filledContent' callback filter
			_setCont: function(html, selector) {
				if (selector) {
					var tmp = [],
						i = 0;
					// Looking for script to store them
					html = html
						.replace(/\r\n/gi, 'nyroModalLN')
						.replace(/<script(.|\s)*?\/script>/gi, function(x) {
								tmp[i] = x;
								return '<pre class=nyroModalScript rel="'+(i++)+'"></pre>';
							});
					var cur = $('<div>'+html+'</div>').find(selector);
					if (cur.length) {
						html = cur.html()
							.replace(/<pre class="?nyroModalScript"? rel="?([0-9]*)"?><\/pre>/gi, function(x, y, z) { return tmp[y]; })
							.replace(/nyroModalLN/gi, "\r\n");
					} else {
						// selector not found
						this._error();
						return;
					}
				}
				this.elts.hidden
					.append(this._filterScripts(html))
					.prepend(this.header)
					.append(this.footer)
					.wrapInner($('<div />', {'class': 'nyroModal'+$.ucfirst(this.loadFilter)}));

				// Store the size of the element
				this.sizes.initW = this.sizes.w = this.elts.hidden.width();
				this.sizes.initH = this.sizes.h = this.elts.hidden.height();
				var outer = this.getInternal()._getOuter(this.elts.cont);
				this.sizes.hMargin = outer.h.total;
				this.sizes.wMargin = outer.w.total;

				this.size();

				this.loading = false;
				this._callFilters('filledContent');
				this._contentLoading();
			},

			// Filter an html content to remove the script[src] and store them appropriately if needed
			// - data: Data to filter
			_filterScripts: function(data) {
				if (typeof data != 'string')
					return data;

				this._scripts = [];
				this._scriptsShown = [];
				var start = 0,
					stStart = '<script',
					stEnd = '</script>',
					endLn = stEnd.length,
					pos,
					pos2,
					tmp;
				while ((pos = data.indexOf(stStart, start)) > -1) {
					pos2 = data.indexOf(stEnd)+endLn;
					tmp = $(data.substring(pos, pos2));
					if (!tmp.attr('src') || tmp.attr('rel') == 'forceLoad') {
						if (tmp.attr('rev') == 'shown')
							this._scriptsShown.push(tmp.get(0));
						else
							this._scripts.push(tmp.get(0));
					}
					data = data.substring(0, pos)+data.substr(pos2);
					start = pos;
				}
				return data;
			},

			// Check if the nmObject has a specific filter
			// - filter: Filter name
			_hasFilter: function(filter) {
				var ret = false;
				$.each(this.filters, function(i, f) {
					ret = ret || f == filter;
				});
				return ret;
			},

			// Remove a specific filter
			// - filter: Filter name
			_delFilter: function(filter) {
				this.filters = $.map(this.filters, function(v) {
					if (v != filter)
						return v;
				});
			},

			// Call a function against all active filters
			// - fct: Function name
			// - prm: Parameter to be used in callback
			// return an array of all return of callbacks; keys are filters name
			_callFilters: function(fct, prm) {
				this.getInternal()._debug(fct, prm);
				if (this.opener && this.opener.length) {
					this.opener.trigger(fct+'.nyroModal', [this, prm]);
				} else {
					$b.trigger(fct+'.nyroModal', [this, prm]);
				}
				var ret = [],
					self = this;
				$.each(this.filters, function(i, f) {
					ret[f] = self._callFilter(f, fct, prm);
				});
				if (this.callbacks[fct] && $.isFunction(this.callbacks[fct]))
					ret['callbacks'] = this.callbacks[fct](this, prm);
				return ret;
			},

			// Call a filter function for a specific filter
			// - f: Filter name
			// - fct: Function name
			// - prm: Parameter to be used in callback
			// return the return of the callback
			_callFilter: function(f, fct, prm) {
				if (_filters[f] && _filters[f][fct] && $.isFunction(_filters[f][fct]))
					return _filters[f][fct](this, prm);
				return undefined;
			},

			// Call animation callback.
			// Will also call beforeNNN and afterNNN filter callbacks
			// - fct: Animation function name
			// - clb: Callback once the animation is done
			_callAnim: function(fct, clb) {
				this.getInternal()._debug(fct, clb);
				this._callFilters('before'+$.ucfirst(fct));
				if (!this._animated) {
					this._animated = true;
					if (!$.isFunction(clb)) clb = $.noop;
					if (this.anims[fct] && $.isFunction(this.anims[fct])) {
						curFct = this.anims[fct];
					} else {
						var set = this.anim[fct] || this.anim.def || 'basic';
						if (!_animations[set] || !_animations[set][fct] || !$.isFunction(_animations[set][fct]))
							set = 'basic';
						curFct = _animations[set][fct];
					}
					curFct(this, $.proxy(function() {
							this._animated = false;
							this._callFilters('after'+$.ucfirst(fct));
							clb();
							if (this._needClose)
								setTimeout($.proxy(function() {this.close();}, this), 50);
						}, this));
				}
			},

			// Load the content
			// Will call the 'load' function of the filter specified in the loadFilter parameter
			_load: function() {
				this.getInternal()._debug('_load');
				if (!this.loading && this.loadFilter) {
					this.loading = true;
					this._callFilter(this.loadFilter, 'load');
				}
			},

			// Show the content or the loading according to the current state of the modal
			_contentLoading: function() {
				if (!this._animated && this._bgReady) {
					if (!this._transition && this.elts.cont.html().length > 0)
						this._transition = true;
					this._nbContentLoading++;
					if (!this.loading) {
						if (!this._opened) {
							this._opened = true;
							if (this._transition) {
								var fct = $.proxy(function() {
									this._writeContent();
									this._callFilters('beforeShowCont');
									this._callAnim('hideTrans', $.proxy(function() {
										this._transition = false;
										this._callFilters('afterShowCont');
										this.elts.cont.append(this._scriptsShown);
										this._reposition();
										this.elts.cont.scrollTop(0);
									}, this));
								}, this);
								if (this._nbContentLoading == 1) {
									this._unreposition();
									this._callAnim('showTrans', fct);
								} else {
									fct();
								}
							} else {
								this._callAnim('hideLoad', $.proxy(function() {
									this._writeContent();
									this._callAnim('showCont', $.proxy(function() {
										this.elts.cont.append(this._scriptsShown);
										this._reposition();
										this.elts.cont.scrollTop(0);
									}, this));
								}, this));
							}
						}
					} else if (this._nbContentLoading == 1) {
						var outer = this.getInternal()._getOuter(this.elts.load);
						this.elts.load
							.css({
								position: 'fixed',
								top: (this.getInternal().fullSize.viewH - this.elts.load.height() - outer.h.margin)/2,
								left: (this.getInternal().fullSize.viewW - this.elts.load.width() - outer.w.margin)/2
							});
						if (this._transition) {
							this._unreposition();
							this._callAnim('showTrans', $.proxy(function() {
								this._contentLoading();
							}, this));
						} else {
							this._callAnim('showLoad', $.proxy(function() {
								this._contentLoading();
							}, this));
						}
					}
				}
			},

			// Write the content in the modal.
			// Content comes from the hidden div, scripts and eventually close button.
			_writeContent: function() {
				this.elts.cont
					.empty()
					.append(this.elts.hidden.contents())
					.append(this._scripts)
					.append(this.showCloseButton ? this.closeButton : '')
					.css({
						position: 'fixed',
						width: this.sizes.w,
						height: this.sizes.h,
						top: (this.getInternal().fullSize.viewH - this.sizes.h - this.sizes.hMargin)/2,
						left: (this.getInternal().fullSize.viewW - this.sizes.w - this.sizes.wMargin)/2
					});
			},

			// Reposition elements with a class nmReposition
			_reposition: function() {
				var elts = this.elts.cont.find('.nmReposition');
				if (elts.length) {
					var space = this.getInternal()._getSpaceReposition();
					elts.each(function() {
						var me = $(this),
							offset = me.offset();
						me.css({
							position: 'fixed',
							top: offset.top - space.top,
							left: offset.left - space.left
						});
					});
					this.elts.cont.after(elts);
				}
				this.elts.cont.css('overflow', 'auto');
				this._callFilters('afterReposition');
			},

			// Unreposition elements with a class nmReposition
			// Exaclty the reverse of the _reposition function
			_unreposition: function() {
				this.elts.cont.css('overflow', '');
				var elts = this.elts.all.find('.nmReposition');
				if (elts.length)
					this.elts.cont.append(elts.removeAttr('style'));
				this._callFilters('afterUnreposition');
			}
		},
		_internal = {
			firstInit: true,
			debug: false,
			stack: [],
			fullSize: {
				w: 0,
				h: 0,
				wW: 0,
				wH: 0,
				viewW: 0,
				viewH: 0
			},
			nyroModal: function(opts, fullObj) {
				if (_internal.firstInit) {
					_internal._container = $('<div />').appendTo($b);
					$w.smartresize($.proxy(_internal._resize, _internal));
					$d.on('keydown.nyroModal', $.proxy(_internal._keyHandler, _internal));
					_internal._calculateFullSize();
					_internal.firstInit = false;
				}
				return this.nmInit(opts, fullObj).each(function() {
					_internal._init($(this).data('nmObj'));
				});
			},
			nmInit: function(opts, fullObj) {
				return this.each(function() {
					var me = $(this);
					if (fullObj)
						me.data('nmObj', $.extend(true, {opener: me}, opts));
					else
						me.data('nmObj',
							me.data('nmObj')
								? $.extend(true, me.data('nmObj'), opts)
								: $.extend(true, {opener: me}, _nmObj, opts));
				});
			},
			nmDestroy: function() {
				return this.each(function() {
					var me = $(this);
					if (me.data('nmObj')) {
						if (me.data('nmObj').destroy())
							me.removeData('nmObj');
					}
				});
			},
			nmCall: function() {
				return this.trigger('nyroModal');
			},

			nmManual: function(url, opts) {
				$('<a />', {href: url}).nyroModal(opts).trigger('nyroModal');
			},
			nmData: function(data, opts) {
				this.nmManual('#', $.extend({data: data}, opts));
			},
			nmObj: function(opts) {
				$.extend(true, _nmObj, opts);
			},
			nmInternal: function(opts) {
				$.extend(true, _internal, opts);
			},
			nmAnims: function(opts) {
				$.extend(true, _animations, opts);
			},
			nmFilters: function(opts) {
				$.extend(true, _filters, opts);
			},
			nmTop: function() {
				if (_internal.stack.length)
					return _internal.stack[_internal.stack.length-1]['nmObj'];
				return undefined;
			},

			_debug: function() {
				if (this.debug && window.console && window.console.log)
					window.console.log.apply(window.console, arguments);
			},

			_container: undefined,

			_init: function(nm) {
				nm.filters = [];
				$.each(_filters, function(f, obj) {
					if (obj.is && $.isFunction(obj.is) && obj.is(nm)) {
						nm.filters.push(f);
					}
				});
				nm._callFilters('initFilters');
				nm._callFilters('init');
				nm.opener
					.off('nyroModal.nyroModal nmDisable.nyroModal nmEnable.nyroModal nmClose.nyroModal nmResize.nyroModal')
					.on({
						'nyroModal.nyroModal': 	function() { nm.open(); return false;},
						'nmDisable.nyroModal': 	function() { nm.enabled = false; return false;},
						'nmEnable.nyroModal': 	function() { nm.enabled = true; return false;},
						'nmClose.nyroModal': 	function() { nm.close(); return false;},
						'nmResize.nyroModal': 	function() { nm.resize(); return false;}
					});
			},

			_selNyroModal: function(obj) {
				return $(obj).data('nmObj') ? true : false;
			},

			_selNyroModalOpen: function(obj) {
				var me = $(obj);
				return me.data('nmObj') ? me.data('nmObj')._open : false;
			},

			_keyHandler: function(e) {
				var nmTop = $.nmTop();
				if (nmTop && nmTop.useKeyHandler) {
					return nmTop.keyHandle(e);
				}
			},
			_pushStack: function(obj) {
				this.stack = $.map(this.stack, function(elA) {
					if (elA['nmOpener'] != obj.get(0))
						return elA;
				});
				this.stack.push({
					nmOpener: obj.get(0),
					nmObj: $(obj).data('nmObj')
				});
			},
			_removeStack: function(obj) {
				this.stack = $.map(this.stack, function(elA) {
					if (elA['nmOpener'] != obj.get(0))
						return elA;
				});
			},
			_resize: function() {
				$.each(this.stack, function(k, v) {
					v.nmObj._unreposition();
				});
				this._calculateFullSize();
				$.each(this.stack, function(k, v) {
					v.nmObj.resize();
				});
			},
			_calculateFullSize: function() {
				this.fullSize = {
					w: $d.width(),
					h: $d.height(),
					wW: $w.width(),
					wH: $w.height()
				};
				this.fullSize.viewW = Math.min(this.fullSize.w, this.fullSize.wW);
				this.fullSize.viewH = Math.min(this.fullSize.h, this.fullSize.wH);
			},
			_getCurCSS: function(elm, name) {
				var ret = parseInt($.css(elm, name, true));
				return isNaN(ret) ? 0 : ret;
			},
			_getOuter: function(elm) {
				elm = elm.get(0);
				var ret = {
					h: {
						margin: this._getCurCSS(elm, 'marginTop') + this._getCurCSS(elm, 'marginBottom'),
						border: this._getCurCSS(elm, 'borderTopWidth') + this._getCurCSS(elm, 'borderBottomWidth'),
						padding: this._getCurCSS(elm, 'paddingTop') + this._getCurCSS(elm, 'paddingBottom')
					},
					w: {
						margin: this._getCurCSS(elm, 'marginLeft') + this._getCurCSS(elm, 'marginRight'),
						border: this._getCurCSS(elm, 'borderLeftWidth') + this._getCurCSS(elm, 'borderRightWidth'),
						padding: this._getCurCSS(elm, 'paddingLeft') + this._getCurCSS(elm, 'paddingRight')
					}
				};

				ret.h.outer = ret.h.margin + ret.h.border;
				ret.w.outer = ret.w.margin + ret.w.border;

				ret.h.inner = ret.h.padding + ret.h.border;
				ret.w.inner = ret.w.padding + ret.w.border;

				ret.h.total = ret.h.outer + ret.h.padding;
				ret.w.total = ret.w.outer + ret.w.padding;

				return ret;
			},
			_getSpaceReposition: function() {
				var	outer = this._getOuter($b),
					ie7 = browser.msie && browser.version < 8 && !(screen.height <= $w.height()+23);
				return {
					top: $w.scrollTop() - (!ie7 ? outer.h.border / 2 : 0),
					left: $w.scrollLeft() - (!ie7 ? outer.w.border / 2 : 0)
				};
			},

			_getHash: function(url) {
				if (typeof url == 'string') {
					var hashPos = url.indexOf('#');
					if (hashPos > -1)
						return url.substring(hashPos);
				}
				return '';
			},
			_extractUrl: function(url) {
				var ret = {
					url: undefined,
					sel: undefined
				};

				if (url) {
					var hash = this._getHash(url),
						hashLoc = this._getHash(window.location.href),
						curLoc = window.location.href.substring(0, window.location.href.length - hashLoc.length),
						req = url.substring(0, url.length - hash.length);
					ret.sel = hash;
					if (req != curLoc && req != baseHref)
						ret.url = req;
				}
				return ret;
			}
		},
		_animations = {
			basic: {
				showBg: function(nm, clb) {
					nm.elts.bg.css({opacity: 0.7}).show();
					clb();
				},
				hideBg: function(nm, clb) {
					nm.elts.bg.hide();
					clb();
				},
				showLoad: function(nm, clb) {
					nm.elts.load.show();
					clb();
				},
				hideLoad: function(nm, clb) {
					nm.elts.load.hide();
					clb();
				},
				showCont: function(nm, clb) {
					nm.elts.cont.show();
					clb();
				},
				hideCont: function(nm, clb) {
					nm.elts.cont.hide();
					clb();
				},
				showTrans: function(nm, clb) {
					nm.elts.cont.hide();
					nm.elts.load.show();
					clb();
				},
				hideTrans: function(nm, clb) {
					nm.elts.cont.show();
					nm.elts.load.hide();
					clb();
				},
				resize: function(nm, clb) {
					nm.elts.cont.css({
						width: nm.sizes.w,
						height: nm.sizes.h,
						top: (nm.getInternal().fullSize.viewH - nm.sizes.h - nm.sizes.hMargin)/2,
						left: (nm.getInternal().fullSize.viewW - nm.sizes.w - nm.sizes.wMargin)/2
					});
					clb();
				}
			}
		},
		_filters = {
			basic: {
				is: function(nm) {
					return true;
				},
				init: function(nm) {
					if (nm.opener.attr('rev') == 'modal')
						nm.modal = true;
					if (nm.modal)
						nm.closeOnEscape = nm.closeOnClick = nm.showCloseButton = false;
					if (nm.closeOnEscape)
						nm.useKeyHandler = true;
				},
				initElts: function(nm) {
					nm.elts.bg.addClass('nyroModalBg');
					nm.elts.cont.addClass('nyroModalCont');
					nm.elts.hidden.addClass('nyroModalCont nyroModalHidden');
					nm.elts.load.addClass('nyroModalCont nyroModalLoad');
				},
				error: function(nm) {
					nm.elts.hidden.addClass('nyroModalError');
					nm.elts.cont.addClass('nyroModalError');
					nm._setCont(nm.errorMsg);
				},
				beforeShowCont: function(nm) {
					nm.elts.cont
						.find('.nyroModal').each(function() {
							var cur = $(this);
							cur.nyroModal(nm.getForNewLinks(cur), true);
						}).end()
						.find('.nyroModalClose').on('click.nyroModal', function(e) {
							e.preventDefault();
							nm.close();
						});
				},
				afterShowCont: function(nm) {
					if (nm.closeOnClick)
						nm.elts.bg.off('click.nyroModal').on('click.nyroModal', function(e) {
							e.preventDefault();
							nm.close();
						});
				},
				keyHandle: function(nm) {
					// used for escape key
					if (nm.keyEvent.keyCode == 27 && nm.closeOnEscape) {
						nm.keyEvent.preventDefault();
						nm.close();
					}
				}
			},

			custom: {
				is: function(nm) {
					return true;
				}
			}
		};

	// Add jQuery call fucntions
	$.fn.extend({
		nm: _internal.nyroModal,
		nyroModal: _internal.nyroModal,
		nmInit: _internal.nmInit,
		nmDestroy: _internal.nmDestroy,
		nmCall: _internal.nmCall
	});

	// Add global jQuery functions
	$.extend({
		nmManual: _internal.nmManual,
		nmData: _internal.nmData,
		nmObj: _internal.nmObj,
		nmInternal: _internal.nmInternal,
		nmAnims: _internal.nmAnims,
		nmFilters: _internal.nmFilters,
		nmTop: _internal.nmTop
	});

	// Add jQuery selectors
	$.expr[':'].nyroModal = $.expr[':'].nm = _internal._selNyroModal;
	$.expr[':'].nmOpen = _internal._selNyroModalOpen;
});

// Smartresize plugin
(function($,sr){

  // debouncing function from John Hann
  // http://unscriptable.com/index.php/2009/03/20/debouncing-javascript-methods/
  var debounce = function (func, threshold, execAsap) {
      var timeout;

      return function debounced () {
          var obj = this, args = arguments;
          function delayed () {
              if (!execAsap)
                  func.apply(obj, args);
              timeout = null;
          };

          if (timeout)
              clearTimeout(timeout);
          else if (execAsap)
              func.apply(obj, args);

          timeout = setTimeout(delayed, threshold || 100);
      };
  };
	// smartresize
	jQuery.fn[sr] = function(fn){  return fn ? this.on('resize', debounce(fn)) : this.trigger(sr); };

})(jQuery,'smartresize');

// ucFirst
// jquery plugin by: Baris Aydinoglu (http://baris.aydinoglu.info)
(function($) {
	$.ucfirst = function(str) {
		// http://kevin.vanzonneveld.net
		// +   original by: Kevin van Zonneveld (http://kevin.vanzonneveld.net)
		// +   bugfixed by: Onno Marsman
		// +   improved by: Brett Zamir (http://brett-zamir.me)
		// *     example 1: ucfirst('kevin van zonneveld');
		// *     returns 1: 'Kevin van zonneveld'
		str+= '';
		var f = str.charAt(0).toUpperCase();
		return f + str.substr(1);
	};
})(jQuery);

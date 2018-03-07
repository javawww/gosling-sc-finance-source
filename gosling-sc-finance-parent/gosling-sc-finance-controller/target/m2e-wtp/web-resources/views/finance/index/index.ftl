<!-- 头部-->
<#include "/finance/commons/_head.ftl" />

<style>
	.color{
		color:#fff!important;
	}
	.smallTitle{
		display:inline-block;
		color:#333333!important;
		background:none!important;
	}
	.logo{
		width:150px!important;
		height:150px;
		margin-left:-50%;
		margin-top:-25%;
	}
</style>

<body id="nav_btn01">
<div class="header">
  <div class="w_1200 header container">
    <div class="row">
    <div class="col-md-4 header_l col-md-offset-1">
      <dl class="logo_l png_img row">
        <dt class="col-xs-4"><a><img class="logo" src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/ZYJ_LOGO.png" alt=""></a></dt>
 		<!-- <dt class="col-xs-4"><a><img src="resources/front/images/logo_w.png" alt=""></a></dt> -->
        <dd class="col-xs-8">
          <!--<h1>会员消费管理系统</h1>-->
         <!--  <h5>以传播健康能量为核心</h5>
          <p>以传播财富能量为使命</p> -->
        </dd>
      </dl>
     <!--  <h2>健康人生 财富相伴</h2> -->
    </div>
    <!-- <div class="col-md-8"> 
    	<h1>会员消费管理系统</h1>
    	<h1>以传播健康能量为核心</h1>
    </div> -->
    <!--end头文件左-->
    <div class="header_r">
	    <div class="header_text" style="float: left;margin-top:0%;margin-left:6%;">
	    	<h1 style="font-size: 30px;letter-spacing:13px;margin-left:-20%;font-family: '华文中宋';">以传播健康能量为核心</h1>
	    	<h1 style="font-size: 30px;letter-spacing:13px;font-family: '华文中宋';">以传播财富能量为使命</h1>
	    </div>
     	 <div class="header_text">
	        <!-- <a href="javascript:;" onclick="layer.msg('请手动设置',{time:1000});"><b>◆</b>设为首页</a>
	        <a href="javascript:;" onclick="layer.msg('请手动设置',{time:1000});"><b>◆</b>加入收藏</a> -->
	        <a href="front/logout.html"><b>◆</b>安全退出</a>
      	</div>
    </div>
  </div>
    <!--end头文件右--> 
  </div>
  <!--end宽度--> 
</div> 
<!-- 导航--> 
<div class="nav">
  <div class="open clearfix">
    <button class="navbar-toggle">
      <span class="sr-only">切换导航</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
  </div>
  <div class="w_1200 clearfix" id="nav_div">
    <ul class="container">
      <li id="nav_hover01"><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/information.html" bigtitle="首页公告" smalltitle="新闻公告">首页公告</a></li>
      <li id="nav_hover02"><a class="color">团队管理</a>
        <dl class="sec_nav">
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/register.html" bigtitle="团队管理" smalltitle="注册会员">注册会员</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/activation.html" bigtitle="团队管理" smalltitle="未激活的会员">未激活的会员</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/myrecommMembers.html" bigtitle="团队管理" smalltitle="我推荐的会员">我推荐的会员</a></dd>
          
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/directionLinks.html" bigtitle="团队管理" smalltitle="直推的系谱图">直推的系谱图</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/contactLinks.html" bigtitle="团队管理" smalltitle="安置关系图">安置关系图</a></dd>
        </dl>
      </li>
      <li id="nav_hover04"><a class="color">财务管理</a>
        <dl class="sec_nav">
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/bonusInf.html" bigtitle="财务管理" smalltitle="奖金明细">奖金明细</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/logInf.html" bigtitle="财务管理" smalltitle="财务明细">财务明细</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/tranMemLists.html" bigtitle="财务管理" smalltitle="会员转账">会员转账</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/postMoney.html" bigtitle="财务管理" smalltitle="提现申请">提现申请</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/rechargeLists.html" bigtitle="财务管理" smalltitle="货币充值">货币充值</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/tranMoneyList.html" bigtitle="财务管理" smalltitle="币种兑换">币种兑换</a></dd>
          <!-- <dd><a href="/Home/Money/recast.html" bigtitle="财务管理" smalltitle="会员复投">会员复投</a></dd> -->
        </dl>
      </li>
      <li id="nav_hover05"><a class="color">个人信息</a>
        <dl class="sec_nav">
          
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/memberInfo_edit.html" bigtitle="个人信息" smalltitle="资料修改">资料修改</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/memberPass_edit.html" bigtitle="个人信息" smalltitle="修改密码">修改密码</a></dd>

        </dl>
      </li>
      <li id="nav_hover07"><a class="color">系统信箱</a>
        <dl class="sec_nav">
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/emailMsg_rece_list.html" bigtitle="系统信箱" smalltitle="已收邮件">已收邮件</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/emailMsg_send.html" bigtitle="系统信箱" smalltitle="发送邮件">发送邮件</a></dd>
          <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/emailMsg_send_list.html" bigtitle="系统信箱" smalltitle="已发邮件">已发邮件</a></dd>
        </dl>
      </li>
    </ul>
  </div>
  <!--end宽度--> 
</div>

<div class="w_1200 h_center cf2 container">
  <div class="row">
 	 <!-- 左侧信息-->
	<#include "/finance/commons/_leftinfo.ftl" />
	
  	<div class="r_930 clearfix">
      <!-- 快捷导航-->
      <div class="r_tool h_120" id="quick_nav">
	      <ul>
	          <li>
		        <a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/tranMemLists.html" bigtitle="财务管理" smalltitle="会员转账">
		        	<span class="round_r transition_a t_2" style="background-image: url('${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/quickicon/sdf.png');background-repeat: no-repeat;">
		       		</span>
	          		<p>会员转账</p>
		          </a>
	           </li>
            
	         <li>
		        <a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/bonusInf.html" bigtitle="财务管理" smalltitle="奖金明细">
			        <span class="round_r transition_a t_4" style="background-image: url('${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/quickicon/sfd.png');background-repeat: no-repeat;">
			        </span>
		          	<p>奖金明细</p>
		         </a>
	          </li>

          
	           <li>
		           <a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/rechargeLists.html" bigtitle="财务管理" smalltitle="货币充值">
			           <span class="round_r transition_a t_5" style="background-image: url('${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/quickicon/fg.png');background-repeat: no-repeat;">
			           </span>
		          		<p>会员充值</p>
		          </a>
	          </li>
	          
		        <li>
			        <a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/tranMoneyList.html" bigtitle="财务管理" smalltitle="币种兑换">
				        <span class="round_r transition_a t_6" style="background-image: url('${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/quickicon/2.png');background-repeat: no-repeat;">
				        </span>
			            <p>货币兑换</p>
		           </a>
	          </li>
	      </ul>
	  	</div>
	    <div style=" float:left; width:100%; padding:10px 15px; background:#CEE8F9; margin-top:15px;">
	         	 我的推广链接：
	          <a href="${(tgRegisterUrl)!''}" style="color:red; word-break:break-all;" target="_blank">
	          	${(tgRegisterUrl)!''}
	          </a>
	    </div>

		<div class="col-md-12">
			<dl class="r_th">
				<dt id="ascy_headtitle">
					<span><em></em>首页公告</span>
					<em style='float:left' class="china">></em><span class="smallTitle">新闻公告</span>
				</dt>
			</dl>
			<div class="r_w">
			</div>
			<iframe id="ascy_content" frameborder="0" height="700"  scrolling="yes" width="105%"  src="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/information.html"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
		</div>
	<!--end列表-->
	</div> 
</div>
<!--end中间区域-->
</div>
<!-- 底部-->
<#include "/finance/commons/_copyright.ftl" />
<#include "/finance/commons/_footer.ftl" />

<!--[if IE 6]>
  <script type="text/javascript" src="js/DD_belatedPNG.js"></script>
  <script>
  DD_belatedPNG.fix('.png_img img,.png');
  </script>
  <![endif]-->
<script type="text/javascript">
	$(function(){
		//-----------------------------------------------------------
		var _obj = $("div#nav_div ul a[href]");
		//jquery  遍历器  绑定点击事件
		$(_obj).each(function(i,e){
			var url = $(this).attr("href");
			$(this).click(function(){
				
				//异步加载标题
				var bigtitle = $(this).attr("bigtitle");
				var smalltitle = $(this).attr("smalltitle");
				var titlestr = "";
				titlestr += "<span><em></em>"+bigtitle+"</span><em style='float:left' class=china>"+">"+"</em>"+"<span class='smallTitle'>"+smalltitle+"</span>";
				$("#ascy_headtitle").html(titlestr);
				
				//全部采用iframe加载页面
				$("#ascy_content").attr("src",url);
				return false;
			});
		});
		//默认首页加载首页公告
		//$("#ascy_content").load("front/information.html", function(){ $("#ascy_content").fadeIn('slow');});
		//jquery 遍历器 快捷导航 绑定点击事件
		var _navs = $("div#quick_nav ul a[href]");
		$(_navs).each(function(i,e){
			var url = $(this).attr("href");
			$(this).click(function(){
				
				//异步加载标题
				var bigtitle = $(this).attr("bigtitle");
				var smalltitle = $(this).attr("smalltitle");
				var titlestr = "";
				titlestr += "<span><em></em>"+bigtitle+"</span><em style='float:left' class=china>"+">"+"</em>"+"<span class='smallTitle'>"+smalltitle+"</span>";
				$("#ascy_headtitle").html(titlestr);
				//全部采用iframe加载页面
				$("#ascy_content").attr("src",url);
				return false;
			});
		});
		
		
		//-----------------------------------------------------------
	});
</script>
</body>
</html>
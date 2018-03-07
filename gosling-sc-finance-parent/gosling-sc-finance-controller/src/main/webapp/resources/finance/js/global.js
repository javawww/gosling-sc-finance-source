;$(function(){
//主导航二级菜单
$('.nav li:has(dl)').hover(function(){
$(this).children('dl').stop().slideDown();	
$(this).addClass('light');
},function(){
$(this).children('dl').stop().slideUp();	
$(this).removeClass('light');	
});

//新闻的收缩
$('.h_news .show').addClass('dl_click');
$('.h_news .show dd').show('slow');
$('.h_news dl dt').click(function(){
$(this).parent().toggleClass('dl_click').siblings().removeClass('dl_click');
$(this).parent().children('dd').slideToggle().end().siblings().children('dd').slideUp();
});


//树型 导航
$('.t_tree > div:has(div)').children('.th_o').addClass('th_o_sec');
$('.t_tree > div > div:has(div)').children('.th_o').addClass('th_o_sec');
$('.t_tree > div > div > div:has(div)').children('.th_o').addClass('th_o_sec');
$('.t_tree > div > div > div > div:has(div)').children('.th_o').addClass('th_o_sec'); 
$('.t_tree_2:last,.t_tree_3:last,.t_tree_4:last,.t_tree_5:last,.t_tree_6:last').children('.th_o').addClass('th_o_last');



$('.t_tree_2:has(div)').children('.th_o').click(function(){
$(this).parent().children('div').stop().toggle();
$(this).toggleClass('th_show');
});

$('.t_tree_3:has(div)').children('.th_o').click(function(){
$(this).parent().children('div').stop().toggle();
$(this).toggleClass('th_show');
});

$('.t_tree_4:has(div)').children('.th_o').click(function(){
$(this).parent().children('div').stop().toggle();
$(this).toggleClass('th_show');
});

$('.t_tree_5:has(div)').children('.th_o').click(function(){
$(this).parent().children('div').stop().toggle();
$(this).toggleClass('th_show');
});

/*-----响应式导航------*/
$(".open button").click(function(){
	$(".nav .w_1200").toggle();
	var y=$(".nav .w_1200").css("display")
	if(y=="blcok"){
		$(".nav .w_1200").css({zIndex:-1});
		}else{
			$(".nav .w_1200").css({zIndex:99});
		    verh()
			}
	})
	
});


//页面高度
window.onload = function (){
var bh=$(window).height();
var h=$(".r_930").height();
var c=bh-288;
if(h<=c){
	$(".l_270").css({minHeight:c})
	}else{
		$(".l_270").css({minHeight:h})
		}
var w=$(window).width();
if(w<=768){
	verh()
	}		
		
}

function verh(){
	var f=$(".header").height();
	var nav=$(".nav").height();
	$(".l_270").css({minHeight:""});
	$(".r_tool").css({top:f+nav});
	var s=$(".r_tool").height();
	$(".l_270").css({marginTop:s-10})
	} 

layui.use('layer', function () {
	var layer = layui.layer;
});
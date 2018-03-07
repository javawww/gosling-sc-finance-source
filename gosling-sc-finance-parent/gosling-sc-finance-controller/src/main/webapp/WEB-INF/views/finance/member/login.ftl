<!-- 头部 -->
<#include "/finance/commons/_head.ftl" />
<link rel="stylesheet" type="text/css" href="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/css/login.css">

<body>
<div class="w_1200 h_header">
  <dl class="png_img h_logo">
    <dd></dd>
  </dl>
</div>

<div class="w_1000">
  <div class="login_box">
    <form id="submitform">
      <table>
        <tr>
          <th><label for="name"><img src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/p.png"></label></th>
          <td><input type="text" class="round_s login_text" id="memNum" name="memNum" value="" placeholder="请输入用户名"></td>
        </tr>
        <tr>
          <th><label for="pass"><img src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/lock.png"></label></th>
          <td><input type="text" onfocus="this.type='password'"  class="round_s login_text" id="loginPwd" name="loginPwd" value="" placeholder="请输入密码"></td>
        </tr>
        <tr>
          <th><label for="ma"><img src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/yzm.png"></label></th>
          <td>
            <span class="r">
            <img id="verify_img" name="verify_img" style="cursor: pointer;" onclick="reImg()" src="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/verify.html" alt="" width="65" height="29">
            </span>
            <input name="verify_number" id="verify_number" type="text" class="round_s login_text_s" placeholder="请输入验证码"></td>
        </tr>
        <tfoot>
          <tr>
            <!--<th></th>-->
            <td colspan="2" align="center">
            	<input type="button" class="login_btn" id="submitbtn"  value="登录" >
            	<!-- <input type="button" class="login_btn" value="取消" > -->
            	<a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/forget_pass.html">找回密码</a>
             </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</div>
<!--end登录--> 
<!-- footer -->
<#include "/finance/commons/_footer.ftl" />

<script type="text/javascript">
$(function(){
	//----------------------------------------------------------
	$("#submitbtn").click(function(){
		//前台校验 提交表单
		var memNum = $("#memNum").val();
		var loginPwd = $("#loginPwd").val();
		var verify_number = $("#verify_number").val();
		if (memNum == null || memNum == "") {
			layer.msg("请输入用户名",{time:1000});
			$("#memNum").focus();
			return false;
		}
		if (loginPwd == null || loginPwd == "") {
			layer.msg("请输入密码",{time:1000});
			$("#loginPwd").focus();
			return false;
		}
		if (verify_number == null || verify_number == "") {
			layer.msg("请输入校验码",{time:1000});
			$("#verify_number").focus();
			return false;
		}
		
		$("#submitbtn").attr("disabled","disabled");
		var params = $("#submitform").serialize();
		
		$.ajax({
			type:"POST",
			url:domain+"/dologin.html",
			dataType:"json",
			data : params,
			success:function(data){
				if(data.success){
					// 跳转到用户中心
					layer.msg("登录成功",{time:1000},function(){ window.location.href=domain+"/index.html";}); 
				}else{
					layer.msg(data.message);
					//刷新验证码
					reImg();
					$("#submitbtn").removeAttr("disabled");
				}
			},
			error:function(){
				layer.msg("服务异常，请稍后重试！",{time:1000});
				$("#submitbtn").removeAttr("disabled");
			}
		});
		
	});
});

//点击图片 刷新校验码
function reImg(){
	$("#verify_img").attr("src",domain+"/verify.html?random="+(new Date()).getTime());
}
//监听回车时间
document.onkeydown=function(event){ 
	var e = event || window.event || arguments.callee.caller.arguments[0]; 
	if(e && e.keyCode==13){ // 按enter 
		$("#submitbtn").click();
	} 
};
</script>

<!--[if IE 6]>
	<script type="text/javascript" src="resources/front/js/jquery.nyroModal-ie6.js"></script>
    <script type="text/javascript" src="resources/front/js/DD_belatedPNG.js"></script>
	<script>
	DD_belatedPNG.fix('.png_img img,.png');
	</script>
  <![endif]-->
</body>
</html>
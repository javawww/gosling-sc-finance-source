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
          <th><label for="name"><img src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/p.png"></label></th>
          <td>
          		<select class="round_s login_text" placeholder="请选择密保问题" id="protectQuest" name="protectQuest">
          			<option value="">--请选择密保问题--</option>
          			<option value="1">最喜欢看的电影是什么</option>
          			<option value="2">曾经去过最远的地方是</option>
          			<option value="3">父亲的生日日期是多少号</option>
          		</select>
          </td>
        </tr>
        <tr>
          <th><label for="name"><img src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/p.png"></label></th>
          <td><input type="text" class="round_s login_text" id="protectAnswe" name="protectAnswe" value="" placeholder="请输入密保答案"></td>
        </tr>
        <tr>
          <th><label for="pass"><img src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/lock.png"></label></th>
          <td><input type="text" onfocus="this.type='password'"  class="round_s login_text" value="" id="loginPwd" name="loginPwd" placeholder="请输入登录新密码"></td>
        </tr>
        <tr>
          <th><label for="pass"><img src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/lock.png"></label></th>
          <td><input type="text" onfocus="this.type='password'"  class="round_s login_text" value="" id="re_loginPwd" placeholder="请确认登录新密码"></td>
        </tr>
        <tr>
          <th><label for="ma"><img src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/yzm.png"></label></th>
          <td>
            <span class="r"><a href="javascript:viod(0);"><img id="verify_img" name="verify_img" onclick="reImg()" src="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/verify.html" alt="" width="65" height="29"></a></span>
            <input name="verify_number" id="verify_number" type="text" class="round_s login_text_s" placeholder="请输入验证码"></td>
        </tr>
        <tfoot>
          <tr>
            <!--<th></th>-->
            <td colspan="2" align="center">
            	<input type="button" class="login_btn" id="submitbtn"  value="重置密码" >
            	<input type="button" class="login_btn" value="返回" onclick="javascript:history.go(-1);" >
             </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</div>
<!-- footer -->
<#include "/finance/commons/_footer.ftl" />

<script type="text/javascript">
$(function(){
	//----------------------------------------------------------
	$("#submitbtn").click(function(){
		//前台校验 提交表单
		var memNum = $("#memNum").val();
		if (memNum == null || memNum == "") {
			layer.msg("请输入用户名",{time:1000});
			$("#memNum").focus();
			return false;
		}
		
		var protectQuest = $("#protectQuest").val();
		if(protectQuest==null || protectQuest==""){
			layer.msg("请选择密保问题",{time:1000})
			$("#protectQuest").focus();
			return false;
		}
		
		var protectAnswe = $("#protectAnswe").val();
		if(protectAnswe==null || protectAnswe==""){
			layer.msg("请输入密保答案",{time:1000})
			$("#protectAnswe").focus();
			return false;
		}
		
		var loginPwd = $("#loginPwd").val();
		var verify_number = $("#verify_number").val();
		if (loginPwd == null || loginPwd == "") {
			layer.msg("请输入新的登录密码",{time:1000});
			$("#loginPwd").focus();
			return false;
		}
		if(!isPassword(loginPwd)){
			layer.msg("登录密码由6-12位的数字或字母组成",{time:1000});
			$("#loginPwd").focus();
			return false;
		 }
		
		var re_loginPwd = $("#re_loginPwd").val();
		if(re_loginPwd != loginPwd){
			layer.msg("输入确认密码不一致",{time:1000});
			$("#re_loginPwd").focus();
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
			url:domain+"doForget_pass.html",
			dataType:"json",
			async : false,
			data : params,
			success:function(data){
				if(data.success){
					// 跳转到用户中心
					layer.msg("操作成功",{time:1000},function(){ window.location.href=domain+"/login.html";}); 
				}else{
					layer.msg(data.message,{time:1000});
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
  $(function(){
	  //-------------------------------------------------------------
	 $("#submitbtn").click(function(){
		 var memNum = $("#memNum").val();
		 var realName = $("#realName").val();
		 var teleNum = $("#teleNum").val();
		 var loginPwd = $("#loginPwd").val();
		 var reloginPwd = $("#reloginPwd").val();
		 var tradePwd = $("#tradePwd").val();
		 var retradePwd = $("#retradePwd").val();
		 
		 if (memNum == null || memNum == "") {
			layer.msg("请输入会员编号",{time:1000});
			$("#memNum").focus();
			return false;
		 }if (realName == null || realName == "") {
			layer.msg("请输入真实姓名",{time:1000});
			$("#realName").focus();
			return false;
		 }if (teleNum == null || teleNum == "") {
			layer.msg("请输入手机号码",{time:1000});
			$("#teleNum").focus();
			return false;
		}if (loginPwd == null || loginPwd == "") {
			layer.msg("请输入登录密码",{time:1000});
			$("#loginPwd").focus();
			return false;
		}if (reloginPwd == null || reloginPwd == "") {
			layer.msg("请输入确认登录密码",{time:1000});
			$("#reloginPwd").focus();
			return false;
		}if (tradePwd == null || tradePwd == "") {
			layer.msg("请输入二次密码",{time:1000});
			$("#tradePwd").focus();
			return false;
		}if (retradePwd == null || retradePwd == "") {
			layer.msg("请输入确认二次密码",{time:1000});
			$("#retradePwd").focus();
			return false;
		}
		 
		 $("#submitbtn").attr("disabled","disabled");
		 var params = $("#submitform").serialize();
		 $.ajax({
				type:"POST",
				url:"front/doregister.html",
				dataType:"json",
				async : false,
				data : params,
				success:function(data){
					if(data.success){
						layer.msg("操作成功");
					}else{
						layer.msg(data.message);
						$("#submitbtn").removeAttr("disabled");
					}
				},
				error:function(){
					layer.msg("服务异常，请稍后重试！");
					$("#submitbtn").removeAttr("disabled");
				}
			});
	 });
	 
	
	 
	//-------------------------------------------------------------
  });
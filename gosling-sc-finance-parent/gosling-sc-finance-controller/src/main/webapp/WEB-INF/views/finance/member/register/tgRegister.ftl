	<!-- 头部-->
<#include "/finance/commons/_head.ftl" />
<div style="height: 100px;"></div>
<div class="container">
	<form class="form-horizontal" id="submitform">
	<!--  隐藏域-->
	<input type="hidden" value="1" name="optType">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">会员编号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="memNum" id="memNum" placeholder="请输入会员编号">
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">真实姓名</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="realName" id="realName" placeholder="请输入真实姓名">
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">手机号码</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="teleNum" id="teleNum" placeholder="请输入手机号码">
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">登录密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" name="loginPwd" id="loginPwd" placeholder="请输入登录密码">
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">确认登录密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" name="reloginPwd" id="reloginPwd" placeholder="请输入确认登录密码">
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">二级密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" name="tradePwd" id="tradePwd" placeholder="请输入二级密码">
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">确认二级密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" name="retradePwd" id="retradePwd" placeholder="请输入确认二级密码">
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">接点人编号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="jiedianNum" id="jiedianNum" readonly="readonly" value="${(members_2.memNum)!'admin'}">
	      <!-- 隐藏接点人ID -->
	      <input type="hidden" name="jiedianId" value="${(members_2.id)!'1'}">
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">推荐人编号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="tjrNum" id="tjrNum" readonly="readonly" value="${(memNo)!''}">
	    </div>
	  </div>
	</form>
</div>
<div class="container text-right">
<button type="button" class="btn btn-primary" id="submitbtn">我填好了，现在注册</button>
</div>
<br>

	<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />

<script type="text/javascript">
$(function(){
	  //-------------------------------------------------------------
	 $("#submitbtn").click(function(){
		 var memNum = $("#memNum").val();
		 if (memNum == null || memNum == "") {
			layer.msg("请输入会员编号",{time:1000});
			$("#memNum").focus();
			return false;
		 }
		 if (!isUsername(memNum)) {
			layer.msg("会员编号由6-12位数组或字母组成",{time:1000});
			$("#memNum").focus();
			return false;
		}
		 
		 var realName = $("#realName").val();
		 if (realName == null || realName == "") {
			layer.msg("请输入真实姓名",{time:1000});
			$("#realName").focus();
			return false;
		 }
		 if(!isChinese(realName)){
			 layer.msg("请输入中文名称,不包含特殊字符",{time:1000});
			 $("#realName").focus();
			 return false;
		 }
		 
		 var teleNum = $("#teleNum").val();
		 if (teleNum == null || teleNum == "") {
			layer.msg("请输入手机号码",{time:1000});
			$("#teleNum").focus();
			return false;
		}
		 if (!isMobile(teleNum)) {
			layer.msg("手机格式不正确",{time:1000});
			$("#teleNum").focus();
			return false;
		}
		 
		 
		 var loginPwd = $("#loginPwd").val();
		 if (loginPwd == null || loginPwd == "") {
				layer.msg("请输入登录密码",{time:1000});
				$("#loginPwd").focus();
				return false;
		}
		 if(!isPassword(loginPwd)){
				layer.msg("登录密码由6-12位的数字或字母组成",{time:1000});
				$("#loginPwd").focus();
				return false;
		 }
		 
		 var reloginPwd = $("#reloginPwd").val();
		 if (reloginPwd != loginPwd) {
				layer.msg("两次输入登录密码不一致",{time:1000});
				$("#reloginPwd").focus();
				return false;
			}
		 
		 var tradePwd = $("#tradePwd").val();
		 if (tradePwd == null || tradePwd == "") {
				layer.msg("请输入二级密码",{time:1000});
				$("#tradePwd").focus();
				return false;
			}
		if (!isPassword(loginPwd)) {
				layer.msg("二级密码由6-12位的数字或字母组成",{time:1000});
				$("#tradePwd").focus();
				return false;
			}
		 
		 var retradePwd = $("#retradePwd").val();
		 if (retradePwd != tradePwd) {
			layer.msg("两次输入交易密码不一致",{time:1000});
			$("#retradePwd").focus();
			return false;
		}
		 
		 $("#submitbtn").attr("disabled","disabled");
		 var params = $("#submitform").serialize();
		 
		 $.ajax({
				type:"POST",
				url:"${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/doregister.html",
				dataType:"json",
				async : false,
				data : params,
				success:function(data){
					if(data.success){
						layer.msg("操作成功",{time:1000},function(){location.reload(true);}); 
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
</script>

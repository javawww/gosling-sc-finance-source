	<!-- 头部-->
<#include "/finance/commons/_head.ftl" />

<div class="container-fluid">
	<form class="form-horizontal" id="submitform">
	<!--  隐藏域-->
	<input type="hidden" value="${(member.id)!''}" name="id" id="id">
	<h3 class="text-danger" style="font-size: 18px;">
		<blockquote style="border-left: 5px solid green;">
		登录密码修改
		</blockquote>
	</h3>
	
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">原登录密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="orig_loginPwd" placeholder="请输入原登录密码">
	      <input type="hidden" id="orig_loginPwd_db" value="${(member.loginPwd)!''}" />
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">登录新密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="loginPwd" name="loginPwd" placeholder="请输入登录新密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">确认登录新密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="re_loginPwd" placeholder="请输入确认登录新密码">
	    </div>
	  </div>
	  
	  <h3 class="text-danger" style="font-size: 18px;">
	  	<blockquote style="border-left: 5px solid green;">
		二级交易密码修改
		</blockquote>
	  </h3>
	  
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">原二级密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="orig_tradePwd" placeholder="请输入原二级密码">
	      <input type="hidden" id="orig_tradePwd_db" value="${(member.tradePwd)!''}" />
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">二级新密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="tradePwd" name="tradePwd" placeholder="请输入二级新密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">确认二级新密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="re_tradePwd" placeholder="请输入确认二级新密码">
	    </div>
	  </div>
	  
	</form>
</div>
<div class="container-fluid text-right">
<button type="button" class="btn btn-primary" id="submitbtn">确认更新</button>
</div>
<hr>


	<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />


<script type="text/javascript">
	//----------------------------------------------------------
	$(function(){
		$("#submitbtn").click(function(){
			//前台校验 提交表单
			var orig_loginPwd = $("#orig_loginPwd").val();
			if(orig_loginPwd==null || orig_loginPwd==""){
				layer.msg("请输入原登录密码",{time:1000});
				return false;
			}
			var orig_loginPwd_db = $("#orig_loginPwd_db").val();
			if(orig_loginPwd != orig_loginPwd_db){
				layer.msg("原登录密码输入错误",{time:1000});
				return false;
			}
			
			var loginPwd = $("#loginPwd").val();
			if(loginPwd==null || loginPwd==""){
				layer.msg("请输入登录新密码",{time:1000});
				return false;
			}
			if(loginPwd.length < 6){
				layer.msg("登录新密码最少6位",{time:1000});
				return false;
			}
			
			var re_loginPwd = $("#re_loginPwd").val();
			if(re_loginPwd != loginPwd){
				layer.msg("两次输入登录新密码不一致",{time:1000});
				return false;
			}
			
			//-----------------
			var orig_tradePwd = $("#orig_tradePwd").val();
			if(orig_tradePwd==null || orig_tradePwd==""){
				layer.msg("请输入原二级密码",{time:1000});
				return false;
			}
			var orig_tradePwd_db = $("#orig_tradePwd_db").val();
			if(orig_tradePwd != orig_tradePwd_db){
				layer.msg("原二级密码输入错误",{time:1000});
				return false;
			}
			
			var tradePwd = $("#tradePwd").val();
			if(tradePwd==null || tradePwd==""){
				layer.msg("请输入二级新密码",{time:1000});
				return false;
			}
			if(tradePwd.length < 6){
				layer.msg("二级新密码最少6位",{time:1000});
				return false;
			}
			
			var re_tradePwd = $("#re_tradePwd").val();
			if(re_tradePwd != tradePwd){
				layer.msg("两次输入二级新密码不一致",{time:1000});
				return false;
			}
			
			
			$("#submitbtn").attr("disabled","disabled");
			var params = $("#submitform").serialize();
			
			$.ajax({
				type:"POST",
				url:"${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/doUpdateMemberInfo.html",
				dataType:"json",
				async : false,
				data : params,
				success:function(data){
					if(data.success){
						layer.msg("操作成功",{time:1000},function(){location.reload(true);}); 
					}else{
						layer.msg(data.message,{time:1000});
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
	//----------------------------------------------------------
</script>

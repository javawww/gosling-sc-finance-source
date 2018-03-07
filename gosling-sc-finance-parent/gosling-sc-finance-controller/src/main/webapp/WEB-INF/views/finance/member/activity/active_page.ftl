	<!-- 头部-->
<#include "/finance/commons/_head.ftl" />


<div class="container-fluid">
	<form class="form-horizontal" id="submitform">
	<!--  隐藏域-->
	<input type="hidden" value="1" name="optType">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">会员编号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" readonly="readonly" value="${(member_1.memNum)!''}" name="memNum" placeholder="请输入转入会员编号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">扣除积分</label>
	    <div class="col-sm-10">
	      <input type="number" class="form-control" value="${singlePrice?string(',##0.00')!'0.00'}" readonly="readonly" placeholder="请输入转账金额">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">二级密码</label>
	    <div class="col-sm-10">
	      <input type="text" onfocus="this.type='password'" class="form-control" id="tradePass" name="tradePass" placeholder="请输入二级交易密码">
	    </div>
	  </div>
	</form>
</div>
<div class="container-fluid text-right">
<a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/activation.html" onclick="backFun(this)" class="btn btn-default" bigtitle="团队管理" smalltitle="未激活的会员">返回</a>
<button type="button" class="btn btn-primary" id="submitbtn">确认激活</button>
</div>

	<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />


<script type="text/javascript">
	//----------------------------------------------------------
	$(function(){
		$("#submitbtn").click(function(){
			//前台校验 提交表单
			var tradePass = $("#tradePass").val();
			if(tradePass == null || tradePass == "") {
				layer.msg("请输入二级交易密码",{time:1000});
				$("#tradePass").focus();
				return false;
			}
			
			$("#submitbtn").attr("disabled","disabled");
			var params = $("#submitform").serialize();
			
			$.ajax({
				type:"POST",
				url:"${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/doActiveMember.html",//执行会员激活
				dataType:"json",
				async : false,
				data : params,
				success:function(data){
					if(data.success){
						layer.msg("操作成功",{time:1000},function(){parent.location.reload(true);}); 
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
		
		//-------------------------------
		
	});
	
	function backFun(_obj){
		//异步加载标题
		var bigtitle = $(_obj).attr("bigtitle");
		var smalltitle = $(_obj).attr("smalltitle");
		var titlestr = "";
		titlestr += "<span><em></em>"+bigtitle+"</span><em class=china>"+">"+"</em>"+smalltitle;
		parent.$("#ascy_headtitle").html(titlestr);
		
		//全部采用iframe加载页面
		var url = $(_obj).attr("href");
		parent.$("#ascy_content").attr("src",url);
		return false;
	}
</script>

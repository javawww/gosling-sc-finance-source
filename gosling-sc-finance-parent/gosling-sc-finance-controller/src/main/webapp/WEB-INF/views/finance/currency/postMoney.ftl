	<!-- 头部-->
<#include "/finance/commons/_head.ftl" />


<div class="container-fluid">
	<form class="form-horizontal" id="submitform">
	<!--  隐藏域-->
	<input type="hidden" value="4" name="optType">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">提现币种</label>
	    <div class="col-sm-10">
	    	<select class="form-control" name="txType">
	    		<option value="2">团队收益</option>
	    		<option value="3">现金积分</option>
	    	</select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">提现数量</label>
	    <div class="col-sm-10">
	      <input type="number" class="form-control" id="salary" name="salary" placeholder="请输入提现数量">
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
<button type="button" class="btn btn-primary" id="submitbtn">申请提现</button>
</div>
<hr>

<!-- 渲染数据 -->
<div class="container-fluid">
	<table  class="table table-bordered table-striped table-hover "  style="text-align: center;">
		<thead>
			<tr>
				<th class="text-center">序号</th>
		        <th class="text-center">时间</th>
		        <th class="text-center">币种类型</th>
		        <th class="text-center">会员编号</th>
		        <th class="text-center">提现金额</th>
		        <th class="text-center">到账金额</th>
		        <th class="text-center">状态</th>
		        <th class="text-center">操作</th>
			</tr>
		</thead>
		<tbody id="content">
			<#if inforLists??>
				<#list inforLists as infoList>
				<tr>
					<td>${infoList_index+1}</td>
					<td>${infoList.createTime?datetime}</td>
					<td>
						<#if infoList.txType?? && infoList.txType=2>
						团队收益
						<#elseif infoList.txType?? && infoList.txType=3>
						现金积分
						</#if>
					</td>
					<td>${(infoList.memNum)!''}</td>
					<td>${infoList.salary?string(',##0.00')!'0.00'}</td>
					<td>${infoList.realSalary?string(',##0.00')!'0.00'}</td>
					<td>
						<#if infoList.txStatus?? && infoList.txStatus=1>
						审核中
						<#elseif infoList.txStatus?? && infoList.txStatus=2>
						<font color="green">审核通过</font>
						<#elseif infoList.txStatus?? && infoList.txStatus=3>
						<font color="red">审核失败</font>
						</#if>
					</td>
					<td>
						<#if infoList.txStatus?? && infoList.txStatus=1>
							<a href="javascript:;" onclick="cx(${(infoList.id)!''})" style="color:red;">撤销</a>
						</#if>
					</td>
				</tr>
				</#list>
			</#if>
		</tbody>
	</table>
	<!-- 分页 -->
	<div class="text-right" >
		<ul class="pager">
			<#if page?? && page gt 1 >
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/tranMoneyList.html?page=${page-1}">上一页</a></li>
			<#else>
		    <li class="h4">上一页</li>
			</#if>
			
		    <li class="h4">第 ${(page)!''} 页 (${(rowsPerPage)!''} 条 / 页  共  ${(totalRecods)!''} 条)</li>
		    
		    <#if page lt totalPages >
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/tranMoneyList.html?page=${page+1}">下一页</a></li>
		    <#else>
		    <li class="h4">下一页</li>
		    </#if>
		</ul>
	</div>
</div>


	<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />

<script type="text/javascript">
$(function(){
	//-----------------------------------------
	$("#submitbtn").click(function(){
			//前台校验 提交表单
			var salary = $("#salary").val();				
			if (salary == null || salary == "") {
				layer.msg("请输入提现数量",{time:1000});
				return false;
			}
			
			var tradePass = $("#tradePass").val();
			if(tradePass == null || tradePass == "") {
				layer.msg("请输入二级交易密码",{time:1000});
				return false;
			}
			
			$("#submitbtn").attr("disabled","disabled");
			var params = $("#submitform").serialize();
			
			$.ajax({
				type:"POST",
				url:"${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/doTXsubmit.html",
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
	//-----------------------------------------
});

//撤销提现操作
function cx(id){
	layer.confirm(
			"确定冻结该管理员吗？",
			{icon: 3, title:"提示"}, 
			function(index){
			  $.ajax({
				    type:"POST",
	    			url:"${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/revokeMoney.html",
	    			dataType:"json",
	    			async : false,
	    			data : {id:id}, 
	    			success:function(data){
	    				if(data.success){
	    					// 跳转到用户中心
	    					layer.msg("冻结该管理员成功",{time:1000},function(){ window.location.href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/member_manager_list.html";}); 
	    				}else{
	    					layer.msg(data.message);
	    				}
	    			}
			  });
			},
			function(index){
			  layer.close(index);
			}
		);
}

</script>
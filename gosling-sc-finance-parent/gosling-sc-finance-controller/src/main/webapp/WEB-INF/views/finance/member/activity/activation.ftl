<!-- 头部-->
<#include "/finance/commons/_head.ftl" />
<!-- 未激活的会员列表 -->
<style>
a{
	color: #337ab7;
 	text-decoration: none;
}
a:focus, a:hover{
    color: #23527c;
    text-decoration: underline;
}
</style>
<!-- 渲染数据 -->
<div class="container-fluid">
	<table  class="table table-bordered table-striped table-hover "  style="text-align: center;">
		<thead>
			<tr>
				<th class="text-center">序号</th>
				<th class="text-center">会员编号</th>
		        <th class="text-center">真实姓名</th>
		        <th class="text-center">注册时间</th>
		        <th class="text-center">推荐人</th>
		        <th class="text-center">接点人</th>
		        <th class="text-center">激活状态</th>
		        <th class="text-center">操作</th>
			</tr>
		</thead>
		<tbody id="content">
			<#if inforLists??>
				<#list inforLists as infoList>
				<tr>
					<td>${infoList_index+1}</td>
					<td>${(infoList.memNum)!""}</td>
					<td>${(infoList.realName)!""}</td>
					<td>${(infoList.registTime)?datetime}</td>
					<td>${(infoList.tjrNum)!""}</td>
					<td>${(infoList.jiedianNum)!""}</td>
					<td>
						<#if infoList.jhState?? && infoList.jhState=1>
						未激活
						<#else>
						已激活
						</#if>
					</td>
					<td>
						<a activeurl="true" href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/active_page.html?id=${(infoList.id)!''}" bigtitle="团队管理" smalltitle="激活会员">
						激活
						</a>
						<a href="javascript:;" onclick="delFun(${(infoList.id)!''})">删除</a>
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
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/activation.html?page=${page-1}">上一页</a></li>
			<#else>
		    <li class="h4">上一页</li>
			</#if>
			
		    <li class="h4">第 ${(page)!''} 页 (${(rowsPerPage)!''} 条 / 页  共  ${(totalRecods)!''} 条)</li>
		    
		    <#if page lt totalPages >
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/activation.html?page=${page+1}">下一页</a></li>
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
	//---------------------------
	var _informations = $("#content a[activeurl]");
	$(_informations).each(function(i,e){
		var url = $(this).attr("href");
		$(this).click(function(){
			//异步加载标题
			var bigtitle = $(this).attr("bigtitle");
			var smalltitle = $(this).attr("smalltitle");
			var titlestr = "";
			titlestr += "<span><em></em>"+bigtitle+"</span><em class=china>"+">"+"</em>"+smalltitle;
			parent.$("#ascy_headtitle").html(titlestr);
			
			//全部采用iframe加载页面
			parent.$("#ascy_content").attr("src",url);
			return false;
		});
	});
	//---------------------------
});

function delFun(id){
	parent.layer.confirm(
			"确定删除吗？", {icon: 3, title:"提示"}, 
			function(index){
			  $.ajax({
				    type:"POST",
	    			url:"${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/member_del.html",
	    			dataType:"json",
	    			async : false,
	    			data : {id:id}, 
	    			success:function(data){
	    				if(data.success){
	    					layer.msg("操作成功",{time:1000},function(){layer.close(index);location.reload(true);}); 
	    				}else{
	    					layer.msg(data.message);
	    					$("#submitbtn").removeAttr("disabled");
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

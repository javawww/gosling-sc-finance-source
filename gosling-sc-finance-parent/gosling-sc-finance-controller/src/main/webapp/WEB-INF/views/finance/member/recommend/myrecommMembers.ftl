	<!-- 头部-->
<#include "/finance/commons/_head.ftl" />

<!-- 渲染数据 -->
<div class="container-fluid">
	<table  class="table table-bordered table-striped table-hover "  style="text-align: center;">
		<thead>
			<tr>
				<th class="text-center">序号</th>
				<th class="text-center">会员编号</th>
		        <th class="text-center">真实姓名</th>
		        <th class="text-center">推荐人</th>
		        <th class="text-center">接点人</th>
		        <th class="text-center">区位</th>
		        <th class="text-center">激活状态</th>
			</tr>
		</thead>
		<tbody id="content">
			<#if inforLists??>
				<#list inforLists as infoList>
				<tr>
					<td>${infoList_index+1}</td>
					<td>${(infoList.memNum)!""}</td>
					<td>${(infoList.realName)!""}</td>
					<td>${(infoList.tjrNum)!""}</td>
					<td>${(infoList.jiedianNum)!""}</td>
					<td>${(infoList.areaType)!""}</td>
					<td>
						<#if infoList.jhState?? && infoList.jhState=1>
						未激活
						<#else>
						已激活
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
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/myrecommMembers.html?page=${page-1}">上一页</a></li>
			<#else>
		    <li class="h4">上一页</li>
			</#if>
			
		    <li class="h4">第 ${(page)!''} 页 (${(rowsPerPage)!''} 条 / 页  共  ${(totalRecods)!''} 条)</li>
		    
		    <#if page lt totalPages >
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/myrecommMembers.html?page=${page+1}">下一页</a></li>
		    <#else>
		    <li class="h4">下一页</li>
		    </#if>
		</ul>
	</div>
</div>


	<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />
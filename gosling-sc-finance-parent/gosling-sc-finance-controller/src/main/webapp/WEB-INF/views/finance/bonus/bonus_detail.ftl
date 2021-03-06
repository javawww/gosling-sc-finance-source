<!-- 头部-->
<#include "/finance/commons/_head.ftl" />

<div class="container-fluid text-right">
	<a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/bonusInf.html" class="btn btn-default">返回</a>
</div>

<!-- 渲染数据 -->
<div class="container-fluid">
	<table  class="table table-bordered table-striped table-hover "  style="text-align: center;">
		<thead>
			<tr>
				<th class="text-center">序号</th>
				<th class="text-center">结算时间</th>
		        <th class="text-center">结算状态</th>
		        <th class="text-center">金额</th>
		        <th class="text-center">类型</th>
		        <th class="text-center">描述</th>
			</tr>
		</thead>
		<tbody id="content">
			<#if inforLists??>
				<#list inforLists as infoList>
				<tr>
					<td>${infoList_index+1}</td>
					<td>${(infoList.bonusTime)?datetime}</td>
					<td>已结算</td>
					<td>${(infoList.bonusSalar)?string(',##0.00')!'0.00'}</td>
					<td>
						<#if infoList.bonusType?? && infoList.bonusType=1>
						层奖
						<#else>
						推荐奖
						</#if>
					</td>
					<td>${(infoList.bonusDesc)!''}</td>
				</tr>
				</#list>
			</#if>
		</tbody>
	</table>
	<!-- 分页 -->
	<div class="text-right" >
		<ul class="pager">
			<#if page?? && page gt 1 >
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/bonus_detail.html?page=${page-1}">上一页</a></li>
			<#else>
		    <li class="h4">上一页</li>
			</#if>
			
		    <li class="h4">第 ${(page)!''} 页 (${(rowsPerPage)!''} 条 / 页  共  ${(totalRecods)!''} 条)</li>
		    
		    <#if page lt totalPages >
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/bonus_detail.html?page=${page+1}">下一页</a></li>
		    <#else>
		    <li class="h4">下一页</li>
		    </#if>
		</ul>
	</div>
</div>

	<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />




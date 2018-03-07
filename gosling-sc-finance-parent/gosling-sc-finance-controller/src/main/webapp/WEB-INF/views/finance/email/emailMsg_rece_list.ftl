	<!-- 头部-->
<#include "/finance/commons/_head.ftl" />

<section class="container-fluid"> 
			<hr>
			<!--显示数据栏-->
			<div class="container-fluid">
				<table  class="table table-bordered table-striped table-hover "  style="text-align: center;">
					<thead>
						<tr>
							<th class="text-center">序号</th>
					        <th class="text-center">邮件类别</th>
					        <th class="text-center">状态</th>
					        <th class="text-center">邮件主题</th>
					        <th class="text-center">时间</th>
					        <th class="text-center">发件人</th>
					        <th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody id="content">
						<#if inforLists??>
							<#list inforLists as infoList>
							<tr>
								<td>${infoList_index+1}</td>
								<td><!-- 0注册问题 1安全问题 2账号问题3交易问题 4其他问题 -->
									<#if infoList.msgType?? && infoList.msgType==0>
									注册问题
									<#elseif infoList.msgType?? && infoList.msgType==1>
									安全问题
									<#elseif infoList.msgType?? && infoList.msgType==2>
									账号问题
									<#elseif infoList.msgType?? && infoList.msgType==3>
									交易问题
									<#elseif infoList.msgType?? && infoList.msgType==4>
									其他问题
									</#if>
								</td>
								<td><!--  0未读邮件 1已读邮件 -->
									<#if infoList.msgStatus?? && infoList.msgStatus==0>
									未读邮件
									<#elseif infoList.msgStatus?? && infoList.msgStatus==1>
									已读邮件
									</#if>
								</td>
								<td>${(infoList.msgSubject)!""}</td>
								<td>${infoList.sendTime?datetime}</td>
								<td>${(infoList.memNum)!""}</td>
								<td>
									<a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/emailMsg_detail.html?id=${(infoList.id)!''}" bigtitle="已收邮件" smalltitle="邮件详情">查看</a>
								</td>
							</tr>
							</#list>
						</#if>
					</tbody>
				</table>
				<div class="text-right" >
					<ul class="pager">
						<#if page?? && page gt 1 >
					    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/emailMsg_send_list.html?page=${page-1}">上一页</a></li>
						<#else>
					    <li class="h4">上一页</li>
						</#if>
						
					    <li class="h4">第 ${(page)!''} 页 (${(rowsPerPage)!''} 条 / 页  共  ${(totalRecods)!''} 条)</li>
					    
					    <#if page lt totalPages >
					    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/emailMsg_send_list.html?page=${page+1}">下一页</a></li>
					    <#else>
					    <li class="h4">下一页</li>
					    </#if>
					</ul>
				</div>
			</div>
		</section>


	<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />


<script type="text/javascript">
$(function(){
	//---------------------------------------------------------
	//jquery 遍历器 快捷导航 绑定点击事件
	var _informations = $("#content a[href]");
	$(_informations).each(function(i,e){
		var url = $(this).attr("href");
		$(this).click(function(){
			//异步加载标题
			var bigtitle = $(this).attr("bigtitle");
			var smalltitle = $(this).attr("smalltitle");
			var titlestr = "";
			titlestr += "<span><em></em>"+bigtitle+"</span><em class=china>"+">"+"</em>"+smalltitle;
			$("#ascy_headtitle").html(titlestr);
			
			//全部采用iframe加载页面
			$parent.$("#ascy_content").attr("src",url);
			return false;
		});
	});
	//---------------------------------------------------------
});
</script>
		
		
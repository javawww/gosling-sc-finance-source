<!-- 头部-->
<#include "/finance/commons/_head.ftl" />

<style>
.pager li{padding-left:70px;}
.r_th,.page{width: 95%;}

</style>

<dl class="r_th" id="informations">
	<#if inforLists??>
		<#list inforLists as infoList>
	    <dd><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/informationdetail.html?id=${(infoList.id)!''}" bigtitle="新闻公告" smalltitle="详细内容">${(infoList.infTitle)!''}</a><span>${infoList.pubTime?datetime}</span></dd>
		</#list>
	</#if>
</dl>
<#if inforLists?? && inforLists?size &gt; 0>
<dl class="cf2 page">
	 <div class="text-right" >
		<ul class="pager">
			<#if page?? && page gt 1 >
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/information.html?page=${page-1}">上一页</a></li>
			<#else>
		    <li class="h4">上一页</li>
			</#if>
			
		    <li class="h4">第 ${(page)!''} 页 (${(rowsPerPage)!''} 条 / 页  共  ${(totalRecods)!''} 条)</li>
		    
		    <#if page lt totalPages >
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/information.html?page=${page+1}">下一页</a></li>
		    <#else>
		    <li class="h4">下一页</li>
		    </#if>
		</ul>
	</div>
</dl>
<#else>
<dl class="cf2 page">暂时没有数据</dl>
</#if>     
<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />

<script type="text/javascript">
$(function(){
	//---------------------------------------------------------
	
	//jquery 遍历器 快捷导航 绑定点击事件
	var _informations = $("dl#informations a[href]");
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
	//---------------------------------------------------------
});
</script>

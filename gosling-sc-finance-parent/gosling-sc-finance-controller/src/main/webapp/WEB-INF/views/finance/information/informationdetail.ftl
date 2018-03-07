	<!-- 头部-->
<#include "/finance/commons/_head.ftl" />

<style>
.infContent{
	word-break: break-all;
}
.infContent img[src^="http://123.207.28.216:8082"]{
	width: 100%;
	height: 100%;
}
</style>
<div style="text-align:center">
	<h2>${(information.infTitle)!''}</h2>
</div>
<div style="text-align:center">发布时间：${(information.pubTime)?datetime}</div>
<div class="infContent" style="padding:40px;">
<#noescape>
${(information.infContent)!''}
</#noescape>
</div>



	<!-- 底部-->
	<#include "/finance/commons/_footer.ftl" />
	<#include "/finance/commons/_iframejs.ftl" />

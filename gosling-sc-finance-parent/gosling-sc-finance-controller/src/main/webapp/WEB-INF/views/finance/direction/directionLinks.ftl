	<!-- 头部-->
<#include "/finance/commons/_head.ftl" />

<link href="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/css/style.min.css" rel="stylesheet">
<style>
.jstree-default .jstree-clicked{ background:none; border:none; box-shadow:none;}
.search{}
.search > span{ color:#a89425;}
.search > input[type=text]{ border:1px solid #ddd; border-radius:5px; padding:4px 8px; margin-left:8px; width:120px; margin-bottom:10px;}
.search > input[type=button]{ padding:5px 8px; margin-left:8px; border:0; background:#ddd; border-radius:3px;}
.search > div{ display:inline-block; color:#F33; margin-left:20px;}
#Tree{ margin-top:20px;}
#Tree > ul >li:first-child > i.open{ background-position:-126px -67px;}
#Tree > ul >li:first-child > i.show{ background-position:-161px -67px;}
.jstree-default .lady_icon i{ background-position:-197px -67px;}
.jstree-default .man_icon i{ background-position:-260px -4px;}
</style>

<#--
<form method='post' id="toform   action="">
	<div class="search">
		<span>会员编号</span> <input type="text" name="UserID" id="UserID"
			value="" placeholder="请输入会员编号" /> <input type="button" value="查询" />
		<input type="button" value="顶层"
			onclick="document.getElementById('UserID').value='';" />
		<div>团队人数：68人</div>

	</div>
</form>
-->


<div id="Tree">
	 <ul>
      <!-- 递归  宏定义 -->
      <#macro bpTree children>
        <#if children?? && children?size gt 0>
       <#list children as child>
        <#if child.nodes?? && child.nodes?size gt 0>
        <li class="treeview">
          <a href="javascript:void(0)">
            <span>
            	${child.memNum}(直推${(child.ztAmounts)!'0'}人,团队${(child.teamAmounts)!'0'}人)
            </span>
            <i class="fa fa-angle-left pull-right" aria-hidden="true"></i>
          </a>
          <ul class="treeview-menu">
            <@bpTree children=child.nodes />
          </ul>
        </li>
        <#else>
            <li><a href="javascript:void(0)" >
            ${child.memNum}(直推0人,团队0人)
            <#if child.jhState?? && child.jhState=1>
           		<font color="red">未激活</font>
            </#if>
            </a></li>   
        </#if>
       </#list>
    </#if>
    </#macro>
       <!-- 调用宏 生成递归树 -->
       <@bpTree children=memberModel />
  </ul>
  
  
</div>


	<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />
<!--end右宽度-->
<script src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/js/jstree.min.js"></script>
<script>
	$('#Tree').jstree();
	$("input[type=button]").click(function() {
		$("#toform").submit();
	});
</script>
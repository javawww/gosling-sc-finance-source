	<!-- 头部-->
<#include "/finance/commons/_head.ftl" />


<div class="container-fluid">
	<form class="form-horizontal" id="submitform">
	<!--  隐藏域-->
	<input type="hidden" value="2" name="optType">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">购买类型</label>
	    <div class="col-sm-10">
	    	<select class="form-control" name="rechargeType">
	    		<option value="1">激活积分</option>
	    	</select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">购买数量</label>
	    <div class="col-sm-10">
	      <input type="number" class="form-control" id="salary" name="salary" placeholder="请输入购买数量">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">上传凭证</label>
	    <div class="col-sm-10">
		      <p><img src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/uploadBtn.png" id="uploadimg"></p>
			 <p><img width="150" height="150" id="img-thumbnail" class="img-thumbnail" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1501911569092&di=cf963a7f05d2085bdbbea3b041bc63b0&imgtype=0&src=http%3A%2F%2Fwww.youlanw.com%2Fstatic%2Fimages%2Fman.jpg" /></p>
			 <input type="file" id="imageFile" name="imageFile" style="display: none" onchange="ajaxFileUpload()"/>
			 <input type="hidden" id="certificatePic" name="certificatePic" />
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">备注信息</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="rechargeMark" name="rechargeMark" placeholder="请输入备注信息">
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
<button type="button" class="btn btn-primary" id="submitbtn">申请购买</button>
</div>
<hr>
<div class="container-fluid">
	<h3 class="text-danger" style="font-size: 18px;">
		<blockquote style="border-left: 5px solid green;">
		收款信息
		</blockquote>
	</h3>
	<hr>
	<div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">银行卡类型</label>
	    <div class="col-sm-10">
	    <!--  0中国工商银行、1中国建设银行、2中国银行、3中国农业银行、4交通银行-->
	    	<select class="form-control" name="bankType" disabled="disabled">
	    		<option value="0" <#if member.bankType?? && member.bankType=0> selected="selected" </#if> >中国工商银行</option>
	    		<option value="1" <#if member.bankType?? && member.bankType=1> selected="selected" </#if> >中国建设银行</option>
	    		<option value="2" <#if member.bankType?? && member.bankType=2> selected="selected" </#if> >中国银行</option>
	    		<option value="3" <#if member.bankType?? && member.bankType=3> selected="selected" </#if> >中国农业银行</option>
	    		<option value="4" <#if member.bankType?? && member.bankType=4> selected="selected" </#if> >交通银行</option>
	    	</select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">银行卡号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.bankNum)!''}" readonly="readonly" placeholder="请输入银行卡号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">开户行户名</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.khhkName)!''}" readonly="readonly" placeholder="请输入开户行户名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">支付宝账号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.alipay)!''}" readonly="readonly" placeholder="请输入支付宝账号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">支付宝昵称</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.alipayName)!''}" readonly="readonly" placeholder="请输入支付宝昵称">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">微信账号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.weichat)!''}" readonly="readonly" placeholder="请输入微信账号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">收款二维码</label>
	    <div class="col-sm-10">
			 <p><img width="150" height="150" id="img-thumbnail" class="img-thumbnail" src="${(member.payPic)!'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1501911569092&di=cf963a7f05d2085bdbbea3b041bc63b0&imgtype=0&src=http%3A%2F%2Fwww.youlanw.com%2Fstatic%2Fimages%2Fman.jpg'}" /></p>
			 <input type="file" id="imageFile" name="imageFile" style="display: none" onchange="ajaxFileUpload()"/>
			 <input type="hidden" id="payPic" name="payPic" value="${(member.payPic)!''}" />
	    </div>
	  </div>
	  
</div>
<hr>

<!-- 渲染数据 -->
<div class="container-fluid">
	<table  class="table table-bordered table-striped table-hover "  style="text-align: center;">
		<thead>
			<tr>
				<th class="text-center">序号</th>
		        <th class="text-center">会员编号</th>
		        <th class="text-center">购买时间</th>
		        <th class="text-center">充值类型</th>
		        <th class="text-center">购买数量</th>
		        <th class="text-center">上传凭证</th>
		        <th class="text-center">审核时间</th>
		        <th class="text-center">备注</th>
		        <th class="text-center">状态</th>
			</tr>
		</thead>
		<tbody id="content">
			<#if inforLists??>
				<#list inforLists as infoList>
				<tr>
					<td>${infoList_index+1}</td>
					<td>${(infoList.memNum)!""}</td>
					<td>${infoList.createTime?datetime}</td>
					<td>激活积分</td>
					<td>${infoList.salary?string(',##0.00')!'0.00'}</td>
					<td>
						<img alt="" src="${(infoList.certificatePic)!''}" width="100" height="100">
					</td>
					<td>${(infoList.checkedTime?datetime)!''}</td>
					<td>${(infoList.rechargeMark)!""}</td>
					<td>
						<#if infoList.rechargeStatus?? && infoList.rechargeStatus=1>
						审核中
						<#elseif infoList.rechargeStatus?? && infoList.rechargeStatus=2>
						<font color="green">审核通过</font>
						<#elseif infoList.rechargeStatus?? && infoList.rechargeStatus=3>
						<font color="red">审核失败</font>
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
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/information_list.html?page=${page-1}">上一页</a></li>
			<#else>
		    <li class="h4">上一页</li>
			</#if>
			
		    <li class="h4">第 ${(page)!''} 页 (${(rowsPerPage)!''} 条 / 页  共  ${(totalRecods)!''} 条)</li>
		    
		    <#if page lt totalPages >
		    <li><a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/information_list.html?page=${page+1}">下一页</a></li>
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
// 上传图片功能
$("#uploadimg").click(function () {
	$('#imageFile').click();
});

function ajaxFileUpload() {
    $.ajaxFileUpload
    (
        {
            url:"${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/upload.html", //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'imageFile', //文件上传域的ID
            dataType:"TEXT", //返回值类型 一般设置为json
            type:"POST",
            success: function (data, status)  //服务器成功响应处理函数
            {
                $("#img-thumbnail").attr("src", data);
                $("#certificatePic").val(data);
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert(e);
            }
        }
    )
    return false;
};

$(function(){
	//------------------------------------------
	$("#submitbtn").click(function(){
		var salary = $("#salary").val();
		if (salary == null || salary == "") {
			layer.msg("请输入购买数量",{time:1000});
			return false;
		}
		
		var certificatePic = $("#certificatePic").val();
		if (certificatePic == null || certificatePic == "") {
			layer.msg("请上传凭证",{time:1000});
			return false;
		}
		
		var tradePass = $("#tradePass").val();
		if (tradePass == null || tradePass == "") {
			layer.msg("请输入二级密码",{time:1000});
			return false;
		}
		
		$("#submitbtn").attr("disabled","disabled");
		var params = $("#submitform").serialize();
		
		$.ajax({
			type:"POST",
			url:"${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/doRechargeInfo.html",
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
	//------------------------------------------
});
</script>

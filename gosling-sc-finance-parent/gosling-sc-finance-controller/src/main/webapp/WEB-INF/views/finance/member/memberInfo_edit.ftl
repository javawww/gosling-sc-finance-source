	<!-- 头部-->
<#include "/finance/commons/_head.ftl" />


<div class="container-fluid">
	<form class="form-horizontal" id="submitform">
	<!--  隐藏域-->
	<input type="hidden" value="${(member.id)!''}" name="id" id="id">
	<h3 class="text-danger" style="font-size: 18px;">
		<blockquote style="border-left: 5px solid green;">
		基本资料
		</blockquote>
	</h3>
	
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">会员编号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.memNum)!''}" readonly="readonly" placeholder="请输入转入会员编号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">推荐人编号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.tjrNum)!'无'}" readonly="readonly" placeholder="请输入推荐人编号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">接点人编号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.jiedianNum)!'无'}" readonly="readonly" placeholder="请输入接点人编号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">真实姓名</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.realName)!'无'}" id="realName" name="realName" placeholder="请输入真实姓名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">密保问题</label>
	    <div class="col-sm-10">
	      <!-- 0最喜欢看的电影是什么? 1曾经去过最远的地方是? 2父亲的生日日期是多少号? -->
	      <select class="form-control" name="protectQuest">
	      	<option value="1" <#if member.protectQuest?? && member.protectQuest=1> selected="selected" </#if> >最喜欢看的电影是什么</option>
	      	<option value="2" <#if member.protectQuest?? && member.protectQuest=2> selected="selected" </#if> >曾经去过最远的地方是</option>
	      	<option value="3" <#if member.protectQuest?? && member.protectQuest=3> selected="selected" </#if> >父亲的生日日期是多少号</option>
	      </select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">密保答案</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.protectAnswe)!'无'}" id="protectAnswe" name="protectAnswe" placeholder="请输入密保答案">
	    </div>
	  </div>
	  
	  <h3 class="text-danger" style="font-size: 18px;">
	  	<blockquote style="border-left: 5px solid green;">
		收款资料
		</blockquote>
	  </h3>
	  
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">银行卡类型</label>
	    <div class="col-sm-10">
	    <!--  0中国工商银行、1中国建设银行、2中国银行、3中国农业银行、4交通银行-->
	    	<select class="form-control" name="bankType">
	    		<option value="1" <#if member.bankType?? && member.bankType=1> selected="selected" </#if> >中国工商银行</option>
	    		<option value="2" <#if member.bankType?? && member.bankType=2> selected="selected" </#if> >中国建设银行</option>
	    		<option value="3" <#if member.bankType?? && member.bankType=3> selected="selected" </#if> >中国银行</option>
	    		<option value="4" <#if member.bankType?? && member.bankType=4> selected="selected" </#if> >中国农业银行</option>
	    		<option value="5" <#if member.bankType?? && member.bankType=5> selected="selected" </#if> >交通银行</option>
	    	</select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">银行卡号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.bankNum)!''}" id="bankNum" name="bankNum" placeholder="请输入银行卡号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">开户行户名</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.khhkName)!''}" id="khhkName" name="khhkName" placeholder="请输入开户行户名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">支付宝账号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.alipay)!''}" id="alipay" name="alipay" placeholder="请输入支付宝账号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">支付宝昵称</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.alipayName)!''}" id="alipayName" name="alipayName" placeholder="请输入支付宝昵称">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">微信账号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" value="${(member.weichat)!''}" id="weichat" name="weichat" placeholder="请输入微信账号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">收款二维码</label>
	    <div class="col-sm-10">
		      <p><img src="resources/front/images/uploadBtn.png" id="uploadimg"></p>
			 <p><img width="150" height="150" id="img-thumbnail" class="img-thumbnail" src="${(member.payPic)!'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1501911569092&di=cf963a7f05d2085bdbbea3b041bc63b0&imgtype=0&src=http%3A%2F%2Fwww.youlanw.com%2Fstatic%2Fimages%2Fman.jpg'}" /></p>
			 <input type="file" id="imageFile" name="imageFile" style="display: none" onchange="ajaxFileUpload()"/>
			 <input type="hidden" id="payPic" name="payPic" value="${(member.payPic)!''}" />
	    </div>
	  </div>
	  
	  
	</form>
</div>
<div class="container-fluid text-right">
<button type="button" class="btn btn-primary" id="submitbtn">确认更新</button>
</div>
<hr>


	<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />

<script type="text/javascript">
//收款二维码 上传功能
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
                $("#payPic").val(data);
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
	//----------------------------------------------
	$("#submitbtn").click(function(){
		
		$("#submitbtn").attr("disabled","disabled");
		var params = $("#submitform").serialize();
		
		$.ajax({
			type:"POST",
			url:"${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/doUpdateMemberInfo.html",
			dataType:"json",
			async : false,
			data : params,
			success:function(data){
				if(data.success){
					layer.msg("更新成功",{time:1000},function(){location.reload(true);}); 
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
	//----------------------------------------------
});
</script>

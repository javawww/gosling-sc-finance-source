<!-- 头部-->
<#include "/finance/commons/_head.ftl" />

<link href="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">

<div class="container-fluid">
		<form class="form-horizontal" id="submitform">
				<div class="form-group">
					<label class="col-md-2">邮件类型</label>
					<div class="col-md-10" >
					<!--  0注册问题 1安全问题 2账号问题3交易问题 4其他问题-->
						<select class="form-control"  name="msgType" placeholder="请选择">
							<option  value="0">注册问题</option>
							<option  value="1">安全问题</option>
							<option  value="3">账号问题</option>
							<option  value="4">其他问题</option>
						</select> 
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2">收件人编号</label> 
					<div class="col-md-10">
						 <input class="form-control" type="text" id="receMemNum" name="receMemNum" />
					</div>
				</div>  
				<div class="form-group">
					<label class="col-md-2">邮件主题</label> 
					<div class="col-md-10">
						 <input class="form-control" type="text" id="msgSubject" name="msgSubject" />
					</div>
				</div>  
				<div class="form-group">
					<label class="col-md-2">邮件内容</label> 
					<div class="col-md-10">
						 <script type="text/plain" id="myEditor" name="msgContent" style="width: 99%; height: 240px; max-height: 600px"></script>
					</div>
				</div>  
			</form>
	</div>
	
<div class="container-fluid text-right">
<button type="button" class="btn btn-primary" id="submitbtn">确认</button>
</div>
<hr>

<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />


<script type="text/javascript" src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/umeditor/umeditor.config.js"></script>
<script type="text/javascript" src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/umeditor/umeditor.min.js"></script>
<script type="text/javascript" src="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/umeditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
//---------------------------------------------------------
  	var um = UM.getEditor('myEditor');
  
    $(function(){
    	//-------------------------------------------------------------
    	
    	$("#submitbtn").click(function(){
    		
    		var receMemNum = $("#receMemNum").val();
    		if(receMemNum==null || receMemNum==""){
    			layer.msg("收件人编号不能为空",{time:1000});
    			return false;
    		}
    		
    		var msgSubject = $("#msgSubject").val();
    		if(msgSubject==null || msgSubject==""){
    			layer.msg("邮件主题不能为空",{time:1000});
    			return false;
    		}
    		
    		var infContent = um.getContent();
    		if(infContent == null || infContent==""){
    			layer.msg("邮件内容不能为空");
    			um.focus();
    			return false;
    		}
    		
    		$("#submitbtn").attr("disabled","disabled");
    		var params = $("#submitform").serialize();
    		
    		$.ajax({
    			type:"POST",
    			url:"${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/doEmailmsg_add.html",
    			dataType:"json",
    			async : false,
    			data : params,
    			success:function(data){
    				if(data.success){
    					// 跳转到用户中心
    					layer.msg("操作成功",{time:1000},function(){location.reload(true);});
    				
    				}else{
    					layer.msg(data.message);
    					$("#submitbtn").removeAttr("disabled");
    				}
    			},
    			error:function(){
    				layer.msg("服务异常，请稍后重试！",{time:1000});
    				$("#submitbtn").removeAttr("disabled");
    			}
    		});
    	});
    	//-------------------------------------------------------------
    });
</script>

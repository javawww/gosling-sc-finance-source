//验证手机号码
function isMobile(mobile){
    var re = /(^1[3|4|5|6|7|8|9][0-9]{9}$)/;
    return re.test(mobile);
}

// 验证邮箱
function isEmail(email){
	// 验证邮箱
	var flag = false;
	var re = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(re.test(email)==false){
	}else{
	   flag = true;
	}
	return flag;
}

// 验证座机号
function isPhone(phone) {
	var re = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
	return re.test(phone);
}

//14.验证中文 sp-chinese
//$scope.spChinese= /^[\u4E00-\u9FFF]+$/;
function isChinese(chinese){
	var re = /^[\u4E00-\u9FFF]+$/;
	return re.test(chinese);
}
//1.验证密码
//$scope.spPwd = /^[a-zA-Z0-9]{6,12}$;
function isPassword(password){
	var re = /^[a-zA-Z0-9]{6,12}$/;
	return re.test(password);
}

//11.验证用户名合法 sp-username
//$scope.spUsername= /^(?![^a-zA-Z]+$)(?!\D+$).{6,20}$/;
function isUsername(username){
//	var re = /^(?![^a-zA-Z]+$)(?!\D+$).{6,12}$/;
	var re = /^[a-zA-Z0-9]{6,12}$/;
	return re.test(username);
}
//校验表单数据
function check_form() {
	var username=document.getElementById("username");
	//用户名不能为空
	if(username==null||username.value==null||username.value==""){
		alert("用户名不能为空");
		username.focus();//文本框得到焦点
		return false;
	}
	
	var password=document.getElementById("password");
	//密码不能为空
	if(password==null||password.value==null||password.value==""){
		alert("密码不能为空");
		password.focus();//文本框得到焦点
		return false;
	}
	var key=document.getElementById("key");
	//验证码不能为空
	if(key==null||key.value==null||key.value==""){
		alert("验证码不能为空");
		key.focus();//文本框得到焦点
		return false;
	}
}


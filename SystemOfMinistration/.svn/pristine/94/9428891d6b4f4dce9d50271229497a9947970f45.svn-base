//检验 添加表单数据
function check(){
	var companyName=document.getElementById("companyName");
	var customerName=document.getElementById("customerName");
	
	//公司名称不能为空
	if(companyName==null||companyName.value==null||companyName.value==""){
		alert("公司名称不能为空!");
		companyName.focus();//文本框得到焦点的方法
		return false;
	}
	//公司联系人不能为空
	else if(customerName==null||customerName.value==null||customerName.value==""){
		alert("公司联系人不能为空!");
		customerName.focus();
		return false;
	}
	//联系电话不能为空且必须合法
	else
	if(customerTel==null||customerTel.value==null||customerTel.value==""){
		alert("联系电话不能为空!");
		customerTel.focus();
		return false;
	}else{
		var tel = /^1[3|4|5|8][0-9]\d{8}$/;
		if(!tel.test(customerTel.value)){
			alert("联系电话不合法！");
			customerTel.value="";
			customerTel.focus();
			return false;
		}
	}
}


//校验公司名称
function check_company(){
	var name=document.getElementById("companyName");
	if(name==null||name.value==null||name.value.trim()==""){
		document.getElementById("msg_com").innerHTML="公司名称不能为空";
		document.getElementById("msg_com").style.color="red";
	}
}
function check_company1(){
	document.getElementById("msg_com").innerHTML="";
}

//公司联系人 
function check_customer(){
	var name=document.getElementById("customerName");
	if(name==null||name.value==null||name.value.trim()==""){
		document.getElementById("msg_cus").innerHTML="公司联系人不能为空";
		document.getElementById("msg_cus").style.color="red";
	}
}
function check_customer1(){
	document.getElementById("msg_cus").innerHTML="";
}

//联系电话
function check_tel(){
	var name=document.getElementById("customerTel");
	if(name==null||name.value==null||name.value.trim()==""){
		document.getElementById("msg_tel").innerHTML="联系电话不能为空";
		document.getElementById("msg_tel").style.color="red";
	}
}
function check_tel1(){
	document.getElementById("msg_tel").innerHTML="";
}

//添加页面的返回按钮返回的页面
function goback(url){
	window.location.href=url;
}

//表单回写值的方法
function overrideValue(){
	
	//处理 按时间 排序的选中值
	var tempTime=document.getElementById("tempTime").value;
	var time=document.getElementById("time");//得到select下拉框对象
	var opts=time.options;//得到所有option数组
	for(var i=0;i<opts.length;i++){
		if(opts[i].value==tempTime){
			opts[i].selected=true;
			break;
		}
	}
	
	//处理 查询 的选中值
	var tempType=document.getElementById("tempType").value;
	var type=document.getElementById("type");//得到select下拉框对象
	var optss=type.options;//得到所有option数组
	//alert(degree.options.length);
	for(var j=0;i<optss.length;j++){
		if(optss[j].value==tempType){
			optss[j].selected=true;
			break;
		}
	}
}


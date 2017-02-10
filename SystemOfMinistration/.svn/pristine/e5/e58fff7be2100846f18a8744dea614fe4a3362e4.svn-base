
//校验模块名称
function cakeName() {
	var name=document.getElementById("cakeName").value;
	if(name.length>6){
		var str=name.substring(0,6);
		document.getElementById("cakeName").value=str;
		alert("不能超过6个字符!");
	}
}
//校验简单描述
function simple(){
	var name=document.getElementById("simple").value;
	if(name.length>10){
		var str=name.substring(0,10);
		document.getElementById("simple").value=str;
		alert("不能超过10个字符!");
	}
}
//校验详细描述
function detail(){
	var name=document.getElementById("detail").value;
	if(name.length>500){
		var str=name.substring(0,500);
		document.getElementById("detail").value=str;
		alert("不能超过500个字符!");
	}
}
//校验备注
function comment(){
	var name=document.getElementById("comment").value;
	if(name.length>50){
		var str=name.substring(0,50);
		document.getElementById("comment").value=str;
		alert("不能超过50个字符!");
	}
}

/*校验提交*/
function checkNull(){
	//校验项目名称
	var proName=document.getElementById("proName");
	if(proName.value==100){
		alert("请选择项目");
		return false;
	}
	//校验需求名称
	var needName=document.getElementById("needName");
	if(needName.value==100){
		alert("请选择需求");
		return false;
	}
	//校验标题
	var user=document.getElementById("cakeName");
	if(user==null||user.value==null||user.value==""){
		alert("标题不能为空！");
		return false;
	}
	//校验简单描述
	var user=document.getElementById("simple");
	if(user==null||user.value==null||user.value==""){
		alert("简单描述不能为空！");
		return false;
	}
	
	//校验备注
	var comment=document.getElementById("comment");
	if(comment==null||comment.value==null||comment.value==""){
		if(confirm("哟！真不写备注？")){
			return true;
		}else{
			return false;
		}
	}else{
		return true;
	}
	
}

//校验标题
function ptitle() {
	var name=document.getElementById("title").value;
	if(name.length>20){
		var str=name.substring(0,20);
		document.getElementById("title").value=str;
		alert("不能超过20个字符!");
	}
}
//校验简单描述
function simple(){
	var name=document.getElementById("simple").value;
	if(name.length>500){
		var str=name.substring(0,500);
		document.getElementById("simple").value=str;
		alert("不能超过500个字符!");
	}
}
//校验详细描述
function detail(){
	var name=document.getElementById("detail").value;
	if(name.length>5000){
		var str=name.substring(0,5000);
		document.getElementById("detail").value=str;
		alert("不能超过5000个字符!");
	}
}
//校验备注
function comment(){
	var name=document.getElementById("comment").value;
	if(name.length>500){
		var str=name.substring(0,500);
		document.getElementById("comment").value=str;
		alert("不能超过500个字符!");
	}
}

//校验提交
function checkNull(){	
	//校验项目名称
	var proName=document.getElementById("projectChoice");
	if(proName.value==100){
		alert("请选择项目");
		return false;
	}
	//校验标题
	var user=document.getElementById("title");
	if(user==null||user.value==null||user.value==""){
		alert("标题不能为空！");
		return false;
	}
	//校验简单描述
	var simple=document.getElementById("simple");
	if(simple==null||simple.value==null||simple.value==""){
		alert("简单描述不能为空！");
		return false;
	}
	
	//校验备注
	var comment=document.getElementById("comment");
	if(comment==null||comment.value==null||comment.value==""){
		if(confirm("不写备注？")){
			return true;
		}else{
			return false;
		}
	}else{
		return true;
	}
	
}

//校验项目名称
function projectName(){	
	var name=document.getElementById("projectName").value;
	if(name.length>5){
		var str=name.substring(0,5);
		document.getElementById("projectName").value=str;
		alert("不能超过5个字符!");
	}
}
//校验客户公司名称
function customerName() {
	var name=document.getElementById("customerName").value;
	if(name.length>20){
		var str=name.substring(0,5);
		document.getElementById("customerName").value=str;
		alert("不能超过5个字符!");
	}
}
//校验客户方负责人
function chargeName(){
	var name=document.getElementById("personInCharge").value;
	if(name.length>5){
		var str=name.substring(0,5);
		document.getElementById("personInCharge").value=str;
		alert("不能超过5个字符!");
	}
}
//校验经理名称
function managerName(){
	var name=document.getElementById("manager").value;
	if(name.length>5){
		var str=name.substring(0,5);
		document.getElementById("manager").value=str;
		alert("不能超过5个字符!");
	}
}
//校验人数
function personNum(){
	var num=document.getElementById("persons").value;	
	if(isNaN(num)){//判断是否不是数字
		document.getElementById("persons").value="";
		alert("开发人数必须是数字!");
	}
}
//校验备注
function comment(){
	var com=document.getElementById("comment").value;
	if(com.length>5){
		var str=com.substring(0,5);
		document.getElementById("comment").value=str;
		alert("备注不能超过5个字符！");
	}
}






//提交时校验是否为空
function checkNull(){
	
	//【注意:以下代码是，只要走了一个返回(return),则后面的代码都将不会再走】
	
	//校验项目名称是否为空
	var user=document.getElementById("projectName");
	if(user==null||user.value==null||user.value==""){
		alert("项目名称不能为空！");
		return false;
	}
	//校验客户公司名称是否为空
	var customer=document.getElementById("customerName");
	if(customer==null||customer.value==null||customer.value==""){
		alert("客户公司名称不能为空！");
		return false;
	}
	//校验负责人是否为空
	var charge=document.getElementById("personInCharge");
	if(charge==null||charge.value==null||charge.value==""){
		alert("负责人姓名不能为空啊！");
		return false;
	}
	//校验经理姓名是否为空
	var manager=document.getElementById("manager");
	if(manager==null||manager.value==null||manager.value==""){
		alert("经理姓名不能为空！");
		return false;
	}
	//校验开发人数
	var persons=document.getElementById("persons");
	if(persons==null||persons.value==null||persons.value==""){
		alert("开发人数不能为空！");
		return false;
	}
	//校验开始时间
	var starttime=document.getElementById("startTime");
	if(starttime==null||starttime.value==null||starttime.value==""){
		alert("开始时间不能为空！");
		return false;
	}
	//校验立项时间
	var relstarttime=document.getElementById("relstartTime");
	if(relstarttime==null||relstarttime.value==null||relstarttime.value==""){
		alert("立项时间不能为空！");
		return false;
	}
	//校验成本
	var cost=document.getElementById("cost");
	if(cost==null||cost.value==null||cost.value==""){
		alert("预估成本不能为空！");
		return false;
	}
	//校验计划完成时间
	var completetime=document.getElementById("completeTime");
	if(completetime==null||completetime.value==null||completetime.value==""){
		alert("计划完成时间不能为空！");
		return false;
	}
	//校验计划完成时间
	var completetime=document.getElementById("completeTime");
	if(completetime==null||completetime.value==null||completetime.value==""){
		alert("计划完成时间不能为空！");
		return false;
	}
	
	//校验备注
	var comment=document.getElementById("comment");
	if(comment==null||comment.value==null||comment.value==""){
		if(confirm("地球人，不写备注？")){
			return true;
		}else{
			return false;
		}
	}else{
		return true;
	}
	
}


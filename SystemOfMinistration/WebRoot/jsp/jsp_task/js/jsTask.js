/*---------------------------------------校验插入信息----------------------------------*/
//得到焦点触发的方法
function back() {

	window.location.href = "taskServlet";

}
function  getExecutor(){
	 
	window.location.href = "jquery.Servlet";
	 
	
}
function start() {

	var tidArr = document.getElementsByName("id");
	var tid = "";
	for ( var i = 0; i < tidArr.length; i++) {

		var checkedbox = tidArr[i];

		if (checkedbox.checked) {

		}

	}

	window.location.href = "taskServlet";

}

function check_Getplan() {

	document.getElementById("planOption").value = "";// 清空文本框的value值
	document.getElementById("msg_po").innerHTML = "请输入任务标题！";
}
// 文本框失去焦点触发的方法
function check_Loseplan() {

	var planOption = document.getElementById("planOption");// 清空文本框的value值
	if (planOption == null || planOption.value == null
			|| planOption.value.trim() == "") {
		document.getElementById("msg_po").innerHTML = "任务标题不能为空！";

		planOption.className = "red_css";// 设置文本框变成红色，js改操作样式表css
		document.getElementById("msg_po").style.color = "red";// js操作标签里属性里属性值
	}
}

// 验证获得焦点的详细说明文本区域方法
function check_Getdetail() {

	document.getElementById("DetailExplain").value = "";// 清空文本框的value值
	document.getElementById("msg_de").innerHTML = "请填写详细说明！";
}

// 验证失去焦点的详细说明文本区域方法
function check_Losedetail() {

	var detailExplain = document.getElementById("detailExplain");
	if (com.length > 10) {
		var str = com.substring(0, 10);
		document.getElementById("detailExplain").value = str;
		alert("详细说明不能超过3000个字符！");
	}

}

// 验证页面中，如果有红色提示，则不能提交
function check_form() {
	
	
	var res = document.getElementsByName("referenceSite");

	var reStr = "";
	for ( var i = 0; i < res.length; i++) {
		var checkbox = res[i];
		if (checkbox.selected) {
			reStr = reStr + checkbox.value + ",";
			break;
		}

	}
	document.getElementById("referenceSites").value = reStr.substring(0,
			reStr.length - 1);

	
	

	// 验证页面的任务标题
	var planOption = document.getElementById("planOption");// 清空文本框的value值
	if (planOption == null || planOption.value == null
			|| planOption.value.trim() == "") {
		document.getElementById("msg_po").innerHTML = "任务标题不能为空！";

		planOption.className = "red_css";// 设置文本框变成红色，js改操作样式表css
		document.getElementById("msg_po").style.color = "red";// js操作标签里属性里属性值
	}

	// 验证页面的详细说明
	var detailExplain = document.getElementById("detailExplain");
	if (detailExplain == null || detailExplain.value == null
			|| detailExplain.value.trim() == "") {
		document.getElementById("msg_de").innerHTML = "详细说明不能为空！";

		detailExplain.className = "red_css";// 设置文本框变成红色，js改操作样式表css
		document.getElementById("msg_de").style.color = "red";// js操作标签里属性里属性值
		if (confirm("详细说明确定为空吗？")) {
			alert("保存成功！");
			return true;
		} else {
			return false;
		}
	} else {
		alert("保存成功！");
		return true;
	}

}

function keyup() {
	// 通过id得到planOption并赋planOption
	var planOption = document.getElementById("planOption");
	// 判断如果DetailExplain不等于空的话
	if (planOption != null && planOption.value != null
			&& planOption.value != "") {
		planOption.className = "green_css";// 将文本框变为绿色
		document.getElementById("msg_po").innerHTML = "√";// 后方显示绿色的√
	} else {// 如果不符合，执行以下代码

		// 后方显示详细说明输入有误
		document.getElementById("msg_po").innerHTML = "任务标题不能为空！";
		planOption.className = "red_css";// 将文本框变为红色
		// 后方显示的文字变为红色
		document.getElementById("msg_po").style.color = "red";
	}
}

// 详细说明的松开键盘时的方法
function keyupDetail() {
	// 通过id得到DetailExplain并赋DetailExplain
	var detailExplain = document.getElementById("detailExplain");
	// 判断如果planOption不等于空的话
	if (detailExplain != null && detailExplain.value != null
			&& detailExplain.value != "") {
		detailExplain.className = "green_css";// 将文本框变为绿色
		document.getElementById("msg_po").innerHTML = "√";// 后方显示绿色的√
	} else {// 如果不符合
		document.getElementById("msg_po").innerHTML = "详细说明不能为空！";// 后方显示详细说明输入有误
		detailExplain.className = "red_css";// 将文本框变为红色
		document.getElementById("msg_po").style.color = "red";// 后方显示的文字变为红色

	}
}

/*---------------------------- 处理复选框------------------------------------------- */
function subDel() {

	if (confirm("您确定要删除吗")) {

		var flag = false;
		var boxArray = document.getElementsByName("id");// 得到复选框数组
		var str = "";
		for ( var i = 0; i < boxArray.length; i++) {
			if (boxArray[i].checked == true) {
				str = str + boxArray[i].value + ",";

				flag = true;
			}
		}
		if (flag) {
			var strArr = str.substring(0, str.length - 1);// 去掉最后的逗号，并赋给赋给隐藏域

			window.location.href = "deleteTask?id="+ strArr;

		}

	}
}

// 全选
function all() {
	var Array = document.getElementsByName("id");
	for ( var i = 0; i < Array.length; i++) {
		Array[i].checked = true;
	}
}
// 反选
function reAll() {
	var Array = document.getElementsByName("id");
	for ( var i = 0; i < Array.length; i++) {
		if (Array[i].checked) {
			Array[i].checked = false;
		} else {
			Array[i].checked = true;
		}
	}
}
// 提交form1
function subImage() {
	document.getElementById("form1").submit();
}

/*-- -----------------处理搜索表单值的回写：搜索与排序下拉框--------------- --*/
// 处理搜索条件下拉框
/*function searchBox() {
	var a = document.getElementById("condition");
	var Arrays = a.options;// 数组
	var older = document.getElementById("hides").value;
	for ( var j = 0; j < Arrays.length; j++) {

		if (older == Arrays[j].value) {
			Arrays[j].selected = true;
			break;
		}
	}

}*/
// 处理排序下拉框
function orderBox() {
	var aa = document.getElementById("orderby");
	var Array = aa.options;// 数组
	var old = document.getElementById("hid").value;
	for ( var i = 0; i < Array.length; i++) {
		if (old == Array[i].value) {
			Array[i].selected = true;
			break;
		}
	}
}

 

// 任务更新
function updateTask() {

	// 执行者的下拉框
	var referenceSite = document.getElementById("referenceSite").value;
	var rsArr = referenceSite.split(","); // 得到select下拉框对象
	var pid=document.getElementById("pid");// 得到所有option数组
	var nid=document.getElementById("nid");// 得到所有option数组

	for ( var i = 0; i < rsArr.length; i++) {
		if (rsArr[i] == pid.value) {

			rsArr[i].selected = true;

			break;
		}
		if (rsArr[i] == nid.value) {

			rsArr[i].selected = true;

			break;
		}
	}

	// 优先级的下拉框
	
	

	var exectuors = document.getElementById("exectuors").value;
	 
	
	var exectuor  = document.getElementById("exectuor");// 得到select下拉框对象
	var opts = exectuor .options;// 得到所有option数组

	for ( var i = 0; i < opts.length; i++) {
		if (opts[i].value == exectuors) {

			opts[i].selected = true;

			break;
		}
	}
	
 
	var grades = document.getElementById("grades").value;
	 
	
	var grade = document.getElementById("grade");// 得到select下拉框对象
	var opts = grade.options;// 得到所有option数组

	for ( var i = 0; i < opts.length; i++) {
		if (opts[i].value == grades) {

			opts[i].selected = true;

			break;
		}
	}
}
function newUpdate()  {

	// 执行者的下拉框
	var referenceSite = document.getElementById("referenceSite").value;
	var rsArr = referenceSite.split(","); // 得到select下拉框对象
	var pid=document.getElementById("pid");// 得到所有option数组
	 alert(22222222);
		alert(nid.value);
		alert(pid.value);
	for ( var i = 0; i < rsArr.length; i++) {
		if (rsArr[i] == pid.value) {

			rsArr[i].selected = true;

			break;
		}
		 
	}

	// 优先级的下拉框
	
	

	var exectuors = document.getElementById("exectuors").value;
	 
	
	var exectuor  = document.getElementById("exectuor");// 得到select下拉框对象
	var opts = exectuor .options;// 得到所有option数组

	for ( var i = 0; i < opts.length; i++) {
		if (opts[i].value == exectuors) {

			opts[i].selected = true;

			break;
		}
	}
	
 
	var grades = document.getElementById("grades").value;
	 
	
	var grade = document.getElementById("grade");// 得到select下拉框对象
	var opts = grade.options;// 得到所有option数组

	for ( var i = 0; i < opts.length; i++) {
		if (opts[i].value == grades) {

			opts[i].selected = true;

			break;
		}
	}
}

// 保存按钮
 
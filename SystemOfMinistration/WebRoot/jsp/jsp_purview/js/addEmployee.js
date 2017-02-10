function addEmployee() {
	var roleArr = document.getElementsByName("role");
	var rolStr = "";
	for ( var i = 0; i < roleArr.length; i++) {
		var checkbox = roleArr[i];
		if (checkbox.checked) {
			rolStr = rolStr + checkbox.value + ",";

		}
	}
	document.getElementById("roles").value = rolStr.substring(0,
			rolStr.length - 1);

	// 校验人员增加表的js==================================

	var name = document.getElementById("name");
	if (name == null || name.value == null || name.value == "") {
		var msg = document.getElementById("msgName");
		msg.innerHTML = "姓名不能空";
		msg.style.color = "red";

		name.focus();
		return false;
	}

	var age = document.getElementById("age");
	var msgAge = document.getElementById("msgAge");
	if (age == null || age.value == null || age.value == "") {
		msgAge.innerHTML = "年龄不能为空";
		msgAge.style.color = "red";
		age.focus();
		return false;
	}

	var ageRe = /^([1-9][0-9]*)+(.[0-9]{1,3})?$/;
	if (!ageRe.test(age.value)) {
		msgAge.innerHTML = "年龄不合法！请重新输入";
		msgAge.style.color = "red";

		age.value = "";
		age.focus();
		return false;
	}
	var tel = document.getElementById("tel");
	var msgTel = document.getElementById("msgTel");
	if (tel == null || tel.value == null || tel.value == "") {
		alert(33333333);
		msgTel.innerHTML = "电话不能为空";
		alert(33333333);
		msgTel.style.color = "red";
		alert(33333333);
		tel.focus();
		return false;
	}
	var telRe = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
	if (!telRe.test(tel.value)) {
		msgTel.innerHTML = "电话不合法！请重新输入";
		msgTel.style.color = "red";
		tel.value = "";
		tel.focus();
		return false;
	}

	var cardNum = document.getElementById("cardNum");

	var msgCardNum = document.getElementById("msgCardNum");
	if (cardNum == null || cardNum.value == null || cardNum.value == "") {
		msgCardNum.innerHTML = "身份证号不能为空";
		msgCardNum.style.color = "red";
		cardNum.focus();
		return false;
	}
	var cardNumRe = /^\d{15}|\d{18}$/;
	if (!cardNumRe.test(cardNum.value)) {
		msgCardNum.innerHTML = "身份证不合法！请重新输入";
		msgCardNum.style.color = "red";
		cardNum.value = "";
		cardNum.focus();
		return false;
	}

	var entryTime = document.getElementById("entryTime");

	var msgEntryTime = document.getElementById("msgEntryTime");
	if (entryTime == null || entryTime.value == null || entryTime.value == "") {
		msgEntryTime.innerHTML = "入职时间不能为空";
		msgEntryTime.style.color = "red";
		entryTime.focus();
		return false;
	}

	var remark = document.getElementById("remark");

	var msgRemark = document.getElementById("msgRemark");
	if (remark == null || remark.value == null || remark.value == "") {
		msgRemark.innerHTML = "备注不能为空不能为空";
		msgRemark.style.color = "red";
		remark.focus();
		return false;
	}

	// //////////////////增加表单的校验///////////////////////////////////////

}

function addEmployeejs() {

	window.location.href = "queryEmployeeAllRole.Servlet";
}
function updateEmployee() {

	// 处理下拉框的选中值 职业的回写
	var tempPosition = document.getElementById("tempPosition").value;
	var position = document.getElementById("position");// 得到select下拉框对象
	var opts = position.options;// 得到所有option数组

	for ( var i = 0; i < opts.length; i++) {
		if (opts[i].value == tempPosition) {

			opts[i].selected = true;

			break;
		}
	}
	// 处理下拉框的选中值 性别的回写
	var sexs = document.getElementById("sexs").value;
	var sex = document.getElementById("sex");// 得到select下拉框对象
	var opts = sex.options;// 得到所有option数组
	for ( var i = 0; i < opts.length; i++) {
		if (opts[i].value == sexs) {
			opts[i].selected = true;
			break;
		}
	}

	// 处理复选框 角色的回写
	var roles = document.getElementById("roles").value;// 1,2,3
	// 得到servlet传过来的爱好拼接串
	var rolesArray = roles.split(",");// 把1,2,3转成一个数组方便下面处理
	var role = document.getElementsByName("role");// 得到爱好数组
	for ( var i = 0; i < role.length; i++) {
		for ( var j = 0; j < rolesArray.length; j++) {
			if (role[i].value == rolesArray[j]) {
				role[i].checked = true;
				break;
			}
		}

	}

}

function NewUpdateEmployee() {

	var roleArr = document.getElementsByName("role");

	var roleStr = "";

	for ( var i = 0; i < roleArr.length; i++) {
		var checkbox = roleArr[i];
		if (checkbox.checked) {

			roleStr = roleStr + checkbox.value + ",";
		}
	}
	document.getElementById("roles").value = roleStr.substring(0,
			roleStr.length - 1);

	var sexArr = document.getElementsByName("sex");

	for ( var i = 0; i < sexArr.length; i++) {
		var checkbox = sexArr[i];

		if (sexArr.value == checkbox.value) {

			checkbox.selected = true;

			break;
		}
	}
	// 、、、、、、、、、、回写表单的校验、、、、、、、、、、、、、、、、、、、、、、、、、、

	var name = document.getElementById("name");
	if (name == null || name.value == null || name.value == "") {
		var msg = document.getElementById("msgName");
		msg.innerHTML = "姓名不能空";
		msg.style.color = "red";

		name.focus();
		return false;
	}

	var age = document.getElementById("age");
	var msgAge = document.getElementById("msgAge");
	if (age == null || age.value == null || age.value == "") {
		msgAge.innerHTML = "年龄不能为空";
		msgAge.style.color = "red";
		age.focus();
		return false;
	}
	var ageRe = /^([1-9][0-9]*)+(.[0-9]{1,3})?$/;
	if (!ageRe.test(age.value)) {
		msgAge.innerHTML = "年龄不合法！请重新输入";
		msgAge.style.color = "red";
		age.value = "";
		age.focus();
		return false;
	}

	var tel = document.getElementById("tel");

	var msgEntryTime = document.getElementById("tel");
	if (tel == null || tel.value == null || tel.value == "") {
		msgEntryTime.innerHTML = "电话不能为空";
		msgEntryTime.style.color = "red";
		tel.focus();
		return false;
	}
	var telRe = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
	if (!telRe.test(tel.value)) {
		msgEntryTime.innerHTML = "电话不合法！请重新输入";
		msgEntryTime.style.color = "red";
		tel.value = "";
		tel.focus();
		return false;
	}

	var cardNum = document.getElementById("cardNum");

	var msgCardNum = document.getElementById("msgCardNum");
	if (cardNum == null || cardNum.value == null || cardNum.value == "") {
		msgCardNum.innerHTML = "身份证号不能为空";
		msgCardNum.style.color = "red";
		cardNum.focus();
		return false;
	}
	var telRe = /^\d{15}|\d{18}$/;
	if (!telRe.test(cardNum.value)) {
		msgCardNum.innerHTML = "电话不合法！请重新输入";
		msgCardNum.style.color = "red";
		cardNum.value = "";
		cardNum.focus();
		return false;
	}

	var entryTime = document.getElementById("entryTime");

	var msgEntryTime = document.getElementById("msgEntryTime");
	if (entryTime == null || entryTime.value == null || entryTime.value == "") {
		msgEntryTime.innerHTML = "入职时间不能为空";
		msgEntryTime.style.color = "red";
		entryTime.focus();
		return false;
	}

}

function allSelect() {

	var allSelect = document.getElementsByName("id");

	for ( var i = 0; i < allSelect.length; i++) {
		allSelect[i].checked = true;

	}
}
function allNoSelect() {

	var allSelect = document.getElementsByName("id");

	for ( var i = 0; i < allSelect.length; i++) {
		if (allSelect[i].checked == true) {

			allSelect[i].checked = false;

		} else {
			allSelect[i].checked = true;

		}
	}

}
function getEid() {
 
	var allSelect = document.getElementsByName("id");

	var eid = "";
	var flag = false;
	for ( var i = 0; i < allSelect.length; i++) {
		if (allSelect[i].checked == true) {

			eid = eid + allSelect[i].value + ",";
			alert(333);
			flag = true;

		}
	}
	if (eid == "") {
		 
		alert("你还没勾选。请先勾选，在执行！！");
		flag = false;
	}
	if (flag) {
		 
		if (confirm("确定要注销吗？？？")) {
			eids = eid.substring(0, eid.length - 1);
			window.location.href = "cancel.Servlet?eid=" + eids;
		}
	}
}
function deleteEmployee(id) {
	if (confirm("确定删除吗？？？")) {

		window.location.href = "deleteEmployee.Servlet?eid=" + id;
	}

}

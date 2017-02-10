<%@page import="com.zrgk.purview.model.Employee"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>编辑用户信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<%--  <script type="text/javascript" src="<%=basePath%>jsp/jsp_purview/js/addEmployee.js"></script>
 --%>


<!-- <script type="text/javascript">
 	function submit(){
 		document.getElementById("update").submit();
 	}
 
 </script>
 
 -->

<script type="text/javascript" src="jsp/jsp_purview/js/addEmployee.js"></script>
<script type="text/javascript"  src="<%=basePath%>My97DatePicker/WdatePicker.js" ></script>

</head>




<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'
	onload="updateEmployee();">

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:权限管理>>编辑用户</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<form name="form2" id="update" action="update.Servlet" method="post"
		onsubmit="return NewUpdateEmployee();">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top:8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑用户&nbsp;</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select
					id="position" name="position">
						<option value="1">初级开发工程师</option>
						<option value="2">中级开发工程师</option>
						<option value="3">高级开发工程师</option>
						<option value="4">项目经理</option>
						<option value="5">其它</option>
				</select> <input type="hidden" id="tempPosition" name="tempPosition"
					value="${empl.getPosition()}" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					value="${empl.getName()}" id="name" name="name" /><span id="msgName"></span></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select
					id="sex" name="sex">
						<option value="1" >男</option>
						<option value="2">女</option>
				</select> <input type="hidden" id="sexs" name="sexs" value="${empl.getSex()}" />


				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					value="${empl.getAge() }" id="age" name="age" maxlength="3"/><span id="msgAge"></span></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					value="${empl.getTel()}" id="tel" name="tel" maxlength="11"/><span id="msgTel"></span></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input value="${empl.getEntryTime()}" id="entryTime" name="entryTime" maxlength="15" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'entryTime\')|| \'2020-10-01\'}'})"/>
					<span id="msgEntryTime"></span>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					value="${empl.getCardNum()}" id="cardNum" name="cardNum" maxlength="20"/><span id="msgCarNum"></span></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">赋角色：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<c:forEach var="me" items="${addRole}" varStatus="statu">
						<input type="checkbox" value="${me.rid }" id="role" name="role" />${me.roleName } &nbsp;&nbsp;&nbsp;
					</c:forEach>
					<input type="hidden" id="roles" name="roles" value="${empl.getRoles()}" />
				</td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';"><textarea
						rows=10 cols=130 id="remark" name="remark">${empl.getRemark()}</textarea>
				</td>
			</tr>


			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; <input
					type="submit" value="保存" class="coolbg" /> <a
					href="queryAll.Servlet" class="coolbg">返回</a>
				<input id="eid" name="eid" type="hidden" value="${empl.eid }"/>
				</td>
			</tr>
		</table>

	</form>


</body>
</html>

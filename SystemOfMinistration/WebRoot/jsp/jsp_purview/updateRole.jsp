<%@page import="com.zrgk.purview.model.Employee"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>查看角色信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="<%=basePath%>jsp/jsp_purview/js/addRole.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.js"></script>
 

</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'
	onload="updateRole();">

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:权限管理>>查看角色信息</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<form id="form2" action="updateRole.Servlet" method="post" onsubmit=" return NewUpdateRole()" >

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top:8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;查看角色信息&nbsp;</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">角色编号：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="roleNum" name="roleNum" maxlength="10"
					value="${role.roleNum}" /><span id="msgRoleNum"></span></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">角色名称：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input value="${role.roleName}"  id="roleName" name="roleName" maxlength="10"/><span id="msgRoleName"></span></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<select id="state" name="state">
						<option value="1" checked="checked">启用</option>
						<option value="2">禁用</option>
					</select>
					<input type="hidden" id="states" name="states" value="${role.state}"/>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">赋菜单资源：</td>
					<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<c:forEach var="me" items="${menulist}" varStatus="statu">
						<c:if test="${me.parentId!=0 }">
							&nbsp;&nbsp;&nbsp;
						</c:if>
							<input type="checkbox" value="${me.mid }" id="menu" name="menu" />${me.menuName }<br />
					</c:forEach>
						<input type="hidden" id="menus" name="menus" value="${role.menus }" />
				</td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';">
					<textarea id="remark" name="remark">${role.remark }</textarea>
				</td>
			</tr>


			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp;
					<input type ="submit" value ="保存"   class="coolbg"  />
					<a href="<%=basePath%>queryAllRole.Servlet" class="coolbg">返回</a>
					<input id="rid" name="rid" type="hidden" value="${role.rid }"/>
				</td>
			</tr>
		</table>

	</form>


</body>

</html>
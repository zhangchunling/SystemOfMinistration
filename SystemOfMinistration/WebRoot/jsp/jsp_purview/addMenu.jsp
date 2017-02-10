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
<title>添加菜单资源</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="<%=basePath%>jsp/jsp_purview/js/addMenu.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.js"></script>




</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:权限管理>>添加菜单资源
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form2" action="<%=basePath%>insertMenu.Servlet" method="post" onsubmit="return addMenuJs();">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;添加菜单资源&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">菜单资源编号：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="menuNum" name="menuNum" maxlength="10"/><span id="msgMenuNum"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">菜单资源名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="menuName" name="menuName" maxlength="15"/><span id="msgMenuName"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">父菜单：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="parentId" name="parentId">
			<option value="0">顶级菜单</option>
			<c:forEach var="me" items="${addMenu}" varStatus="statu">
				<c:if test="${me.parentId==0 }">
					<option value="${me.mid }">${me.menuName }</option>
				</c:if>
			</c:forEach>
		</select>
	
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">菜单资源路径：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="menuPath" name="menuPath" maxlength="100"/><span id="msgMenuPath"></span></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 id="remark" name="remark"></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:onclick=saveForm();" class="coolbg">保存</a>
	<a href="<%=basePath%>queryAllMenu.Servlet" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>
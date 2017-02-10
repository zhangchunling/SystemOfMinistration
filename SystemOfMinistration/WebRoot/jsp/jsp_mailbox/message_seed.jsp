
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发信息的jsp页面</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="text/javascript" src="<%=basePath%>jsp/jsp_mailbox/js/message_seed.js"></script>

</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:信息箱>>发信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form2" name="form2" action="<%=basePath %>up.servlet.action" enctype="multipart/form-data"  method="post" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;发信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">收件人：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<select id="adressee" name="adressee">
		<c:forEach var="u" items="${QueryAll }">
			<option value="${u.eid}">${u.name }--
				<c:if test="${u.position==1 }">初级程序员</c:if>
				<c:if test="${u.position==2 }">中级程序员</c:if>
				<c:if test="${u.position==3 }">高级程序员</c:if>
				<c:if test="${u.position==4 }">项目经理</c:if>
				<c:if test="${u.position==5 }">其它</c:if>
			</option>
		</c:forEach>		
	</select></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input  id="title" name="title" value="" onblur="checktitle();"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">内容：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea rows=15 cols=130 id="content" name="content"  onblur="checkcontent();"></textarea></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >附件：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<input type="file" id="slave" name="slave"/>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center >
	&nbsp;
<a href="javascript:onclick=submitForm();" class="coolbg" type="submit">发送</a>
	
</td>
</tr>
</table>

</form>
  

</body>
</html>
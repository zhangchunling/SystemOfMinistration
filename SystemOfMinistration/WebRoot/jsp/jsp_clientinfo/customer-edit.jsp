<%@page import="com.zrgk.clientinfo.model.Customers"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>编辑客户信息</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>skin/css/base.css">
<script type="text/javascript" src="<%=basePath%>jsp/jsp_clientinfo/js/customer-add.js"></script>
</head>
<body leftmargin="8" topmargin="8" background='<%=basePath%>skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="<%=basePath%>skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:客户信息管理>>编辑客户信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" action="<%=basePath%>meditUserServlet.action" method="post" onsubmit="return check();" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="<%=basePath%>skin/images/tbg.gif">&nbsp;编辑客户信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22" >公司名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<!-- 用一个隐藏域把用户表的主键传到sevlet里去 -->
	<input type="hidden" id="cid" name="cid" value=${upda.cid } />
	<input id="companyName" name="companyName" value=${upda.companyName } onfocus="check_company1();" onblur="check_company();" /><span id="msg_com"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">公司联系人：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="flag" name="flag" type="hidden" value="1"/><input id="customerName" name="customerName" value=${upda.customerName } onfocus="check_customer1();" onblur="check_customer();" /><span id="msg_cus"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">公司地址：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="companyAddress" name="companyAddress" value=${upda.companyAddress } ></input></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="customerTel" name="customerTel" value=${upda.customerTel } onfocus="check_tel1();" onblur="check_tel();" /><span id="msg_tel"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">座机：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="companyTel" name="companyTel" value=${upda.companyTel } ></input></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">公司简介：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<textarea  id="companyIntroduction" name="companyIntroduction" rows=15 cols=130>${upda.companyIntroduction}</textarea></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
	<textarea id="remark" name="remark"  rows=10 cols=130>${upda.remark }</textarea></td>
</tr>

<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<input type="submit" class="coolbg" value="保存" /> 
	<input type="button" class="coolbg" value="返回" onclick="goback('<%=basePath %>musersListServlet.action');" />
</td>
</tr>
</table>

</form>
  

</body>
</html>
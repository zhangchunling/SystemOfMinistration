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
<title>menu</title>
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="skin/js/frame/menu.js"></script>
<base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
	<!-- Item  Strat -->
     
      
      <c:forEach var="m" items="${menulist }" varStatus="sta">
      			<c:if test="${m.parentId==0 }">
			      	 <dl class='bitem'>
				        <dt onClick='showHide("items${sta.count }_1")'><b>${m.menuName }</b></dt>
				        <dd style='display:block' class='sitem' id='items${sta.count }_1'>
				          <ul class='sitemu'>
				            
								      <c:forEach var="m1" items="${menulist }" varStatus="sta1">
								      			<c:if test="${m1.parentId==m.mid }">
				           								 <li><a href='<%=basePath %>${m1.menuPath }' target='main'>${m1.menuName }</a> </li>
								      			</c:if>
								      </c:forEach>
				          </ul>
				        </dd>
				      </dl>
				   </c:if>
      </c:forEach>
    
	  </td>
  </tr>
</table>
</body>
</html>
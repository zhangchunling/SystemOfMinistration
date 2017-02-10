<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>编辑需求分析信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<!-- 引入js脚本 -->
<script type="text/javascript" src="<%=basePath%>/jsp/jsp_project/js/need_edit.js"></script>
<!-- 头部脚本 -->
 <script type="text/javascript">
	
	//js提交表单
	function sub(){	
		var flag=checkNull();	
		if(flag==true){
			document.getElementById("form9").submit();//校验为true后才提交
		}	
		
	}
 </script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>编辑需求分析信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form9" name="form9" action="<%=basePath%>needUpdateServlet.action?sendid=${needer.pid}" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑需求信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">项目：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<span id="pname" name="pname"> ${basicer.projectName }</span>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="title" name="title" onblur="ptitle();" value="${needer.ptitle }"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">简单描述：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea id="simple" name="simple" onblur="simple();" rows=10 cols=130>${needer.simpleStatement }</textarea></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">详细描述：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea id="detail" name="detail" onblur="detail();" rows=15 cols=130>${needer.detail }</textarea></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea id="comment" name="comment" onblur="comment();" rows=10 cols=130>${needer.comment }</textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:onclick=sub();" class="coolbg" id="save" name="save">保存</a>
	<a href="needServlet.action" class="coolbg" id="back" name="back">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>
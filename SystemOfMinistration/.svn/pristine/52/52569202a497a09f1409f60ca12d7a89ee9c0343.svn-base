<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>添加项目信息</title>
<!-- -----------------------------------javaScript--------------------------------------------------- -->
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<!-- 引入js脚本 -->
<script type="text/javascript" src="<%=basePath%>/jsp/jsp_project/js/basic_add.js"></script>
<!-- 加载事件脚本 -->
	<script type="text/javascript">
		//js提交表单
		function saveForm(){
			var flag=checkNull();	
			if(flag==true){
				document.getElementById("myform").submit();
				alert("保存成功");
			}					
			
		}
	</script>
	<script type="text/javascript" src="<%=basePath %>/My97DatePicker/WdatePicker.js"></script><!-- 导入选择日期的jsq -->
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  ----------------------------------快速转换位置按钮--------------------------------------------------  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>添加项目基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>


<!-- -----------------------------------------内容表单------------------------------------------------------------- -->
<form id="myform" name="myform" action="<%=basePath%>basicInsertServlet.action" method="post" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;添加新项目信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">项目名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="projectname" name="projectname"  onblur="projectName();"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="customername" name="customername" onblur="customerName();"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="personIncharge" name="personIncharge" onblur="chargeName();"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="manager" name="manager" onblur="managerName();"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">开发人数：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="persons" name="persons" onblur="personNum();"/>人</td>
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

	
	 <!-- ------------------下面日期控件可使后面日期不能早于前面日期------------------ -->
	 <input id="starttime" name="starttime" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'relstarttime\')||\'2020-10-01\'}'})"/>
	 <!-- -------------要与后面的日期作比较，则({maxDate:'#F{$dp.$D(\'relstarttime\')里填的是后面日期的id -->

	 </td>
	
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td><!-- -------------日期控件--------- -->
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	
	<input id="relstarttime" name="relstarttime" onblur="relstartTime();"  class="Wdate" type="text"  onfocus="WdatePicker({minDate:'#F{$dp.$D(\'starttime\')}',maxDate:'2020-10-01'})" width="16" height="22" align="absmiddle"/></td>
	
	<td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="cost" name="cost"/>万</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select id="level" name="level"><option value=1>紧急</option><option value=2>一般</option><option value=3>暂缓</option></select></td>
	<td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	
	<input id="completetime" name="completetime" class="Wdate" type="text"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'relstarttime\')||\'2020-10-01\'}'})" src="<%=basePath %>My97DatePicker/skin/datePicker.gif"/></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=15 cols=130 id="comment" name="comment" onblur="comment();"></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:onclick=saveForm();" class="coolbg" id="save" name="save">保存</a>
	<a href="basicServlet.action" class="coolbg" id="back" name="back" onclick="back();">返回</a><!-- back()方法用于判断，没写 -->
</td>
</tr>
</table>

</form>
  

</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>编辑项目信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<!-- -------------------引入js脚本：添加与编辑的一样------------------- -->
<script type="text/javascript" src="<%=basePath%>/jsp/jsp_project/js/basic_edit.js"></script>
 <script type="text/javascript">	
	
	function saveForm(){	
		var flag=checkNull();							//获得js校验后返回的值
		if(flag==true){
			document.getElementById("form2").submit();	//js提交表单
		}else{
			
		}
		
	}
 </script>

<script type="text/javascript" src="<%=basePath %>/My97DatePicker/WdatePicker.js"></script><!-- 导入选择日期的js包 -->
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td>
    当前位置:项目管理>>编辑项目基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>
<!-- -----------------------------------内容列表---------------------------------------------- -->
<form name="form2" id="form2" action="<%=basePath%>basicUpdateServlet.action?name=${basicer.pid}" method="post" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;编辑项目信息&nbsp;	
	</td>	
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">项目名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="projectName" name="projectName" value="${basicer.projectName}" onblur="projectName();"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="customerName" name="customerName" value="${basicer.customerName}" onblur="customerName();"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="personInCharge" name="personInCharge" value="${basicer.personInCharge}" onblur="chargeName();"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="manager" name="manager" value="${basicer.manager}" onblur="managerName();"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">开发人数：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="persons" name="persons" value="${basicer.persons}" onblur="personNum();">人</td>
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="startTime" name="startTime" class="Wdate" value="${basicer.startTime}" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'relstartTime\')||\'2020-10-01\'}'})"/>
	<!-- -------要使开始时间早于立项时间，则须将开始时间的onFocus里写成max（定认成最早时间），且后面的id填写立项时间的id------- -->
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="relstartTime" name="relstartTime" class="Wdate" value="${basicer.relstartTime}" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')||\'2020-10-01\'}'})"/>
	<!-- 要使立项时间晚于开始时间，则须使onFocus里写成min,且后面的id填写开始时间的id -->
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="cost" name="cost" value="${basicer.cost}"/>万</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">级别：
		<!-- 隐藏域用以接收之前传来的value值 -->
		<input type="hidden" id="receiveSelect" name="receiveSelect" value="${basicer.level }" />
	</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select id="level" name="level"><option value="1" >紧急</option><option value="2" >一般</option><option value="3">暂缓</option></select></td>
	<td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="completeTime" name="completeTime" class="Wdate" type="text"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'relstartTime\')||\'2020-10-01\'}'})"value="${basicer.completeTime}" />
	<!-- 要使完成时间晚于立项时间，则立项时间的onFocus里须写成min,且后面的id写立项时间的id -->
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea id="comment" name="comment" rows=15 cols=130  onblur="comment();">${basicer.comment}</textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center> &nbsp;
	<a href="javascript:onclick=saveForm();" class="coolbg" id="save" name="save">保存</a>
	<a href="basicServlet.action" class="coolbg" id="back" name="back">返回</a>
	
</td>
</tr>
</table>

</form>
<!-- 
	在body标签里填写的javascript的方法，只需要在里面调用一次，便会执行该方法
 -->
  <script type="text/javascript">
  	function test(){
  		//处理下拉框--级别的值回写需要用到的js 
		var level=document.getElementById("level");
		var opt=level.options;//得出多个option
		var receiveSelect=document.getElementById("receiveSelect").value;
		for(var i=0;i<opt.length;i++){
			if(opt[i].value==receiveSelect){
				opt[i].selected=true;
				break;
			}
		}
  	}
  	test();//只要这儿调用，则会执行test()方法
  </script>

</body>
</html>
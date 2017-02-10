<%@ page import="com.zrgk.task.model.Task"%>
<%@ page import="com.zrgk.project.model.Basicer" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<title>创建任务</title>	
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 调用CSS样式  -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>skin/css/base.css">
	
	<script type="text/javascript" src="<%=basePath%>jsp/jsp_task/js/jsTask.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.js"></script>	
	<script type="text/javascript"  src="<%=basePath%>jsp/jsp_task/js/jquery.js"></script>
	<script type="text/javascript"  src="<%=basePath%>jsp/jsp_task/js/My97DatePicker/WdatePicker.js"></script>
	<style type="text/css">
		.gren_css{
			border-color: green;
		}
		.red_css{
			border-color: red;
		}
	</style>
  </head>
  <body leftmargin="8" topmargin="8" onLoad="getProjectName();">
  	<span id="msg"></span>

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
		<tr>
		 <td height="26" background="skin/images/newlinebg3.gif">
		  <table width="58%" border="0" cellspacing="0" cellpadding="0">
			  <tr>
			  	<td>当前位置:任务管理>>创建任务 </td>
			  </tr>
		  </table>
		</td>
	 </tr>
</table>
		
		<form name="form2" action="<%=basePath%>insertTask.Servlet"	method="post" onsubmit=" return check_form();">
		
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';"height="22">
							
							<select id=pid name="pid" onChange="getNeed(this.value);">
								<option checked="checked">请选择</option></select>-
							<select id="nid" name="nid">
									
							</select> 
							 
						<input type="hidden" id="referesnceSites" name="referenceSites">
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<input id="planOption" name="planOption"       />
						<span id="msg_po" style="color: green"></span>	
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<input id="d4311" name="beginTime" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})"/>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<input id="d4312" name="endTime" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})"/>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<select id="executor" name="executor" onChange="getExecutor(this.value);">
						
							<option value=1>请选择</option>
							
							<c:forEach var="em" items="${name }" varStatus="i">	
								<option value="${em.eid }" >${em.name }</option>
							</c:forEach>
							 		 				
						</select>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<select id="grade" name="grade">
							<option value="1">高</option>
							<option value="2">中</option>
							<option value="3">低</option>
							<option value="4">暂缓</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td align="right" bgcolor="#FAFAF1">详细说明：</td>
					<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
						<textarea id="detailExplain" name="detailExplain" rows=10 cols=130 onfocus="check_Getdetail();" onblur="check_Losedetail();" onKeyUp="keyupDetail();"></textarea>
						<span id="msg_de" style="color: green"></span>
					</td>
				</tr>
				<tr bgcolor="#FAFAF1">
					<td height="28" colspan=4 align=center>&nbsp;
						<input  type="submit" value="保存" class="coolbg"   >
						<input type="button" value="返回" class="coolbg" onclick="back();">						
					</td>
				</tr>
			</table>	
		</form> 	
	</body>
</html>
<%@ page import="com.zrgk.task.model.Task"%>
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
    
    <title>编辑任务</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		
	<!-- 调用CSS样式 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>skin/css/base.css">
	<script type="text/javascript" src="jsp/jsp_task/js/jsTask.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.js"></script>	
	<script type="text/javascript"  src="<%=basePath%>jsp/jsp_task/js/jquery.js"></script>
	<script type="text/javascript"  src="<%=basePath%>jsp/jsp_task/js/My97DatePicker/WdatePicker.js"></script>
	
	
  </head>
	 <body leftmargin="8" topmargin="8" onload="updateTask();">
	 <script type="text/javascript">
	 	getProjectName();
	 </script>
	
		<!--  快速转换位置按钮  -->
		<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
		<tr>
		 <td height="26" background="skin/images/newlinebg3.gif">
		  <table width="58%" border="0" cellspacing="0" cellpadding="0">
		  <tr><td>当前位置:任务管理>>编辑任务 </td>
		 </tr>
		</table>
		</td>
		</tr>
		</table>
		
		<form name="form2" id="update" action="updateTask.Servlet" method="post" onsubmit="newUpdate();">		
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑任务&nbsp;</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
					<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<select id=pid name="pid" onChange="getNeed(this.value);">
								<!-- <option checked="checked">请选择</option> -->
						</select>-
						<select id="nid" name="nid">
							<option checked="checked">请选择</option>
						</select> 
							<input type="hidden" id="referenceSite" name="referenceSite" value="${task.referenceSite}"/>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
					<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input id="planOption" name="planOption" value=" ${task.planOption}"/></td>
					
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input value="${task.getBeginTime()}" id="beginTime" name="beginTime"/></td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input value="${task.getEndTime()}" id="endTime" name="endTime"/></td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
					<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<select id="executor" name="executor">
					<c:forEach var="em" items="${name }" >	
					 	<option value="${task.executor==em.eid}">${em.name }</option>
					</c:forEach>
						</select>
						<input type="hidden" id="exectuors" name="exectuors" value="${task.executor }"/>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<select id="grade" name="grade">
							<option value=1>高</option>
							<option value=2>中</option>
							<option value=3>低</option>
							<option value=4>暂缓</option>
						</select>
						<input type="hidden" id="grades" name="grades" value="${task.grade}"/>
					</td>
				</tr>
				
				<tr>
					<td align="right" bgcolor="#FAFAF1" >详细说明：</td>
					<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
						<textarea id="detailExplain" name="detailExplain" rows=10 cols=130>${task.detailExplain}</textarea>
					</td>
				</tr>
				<tr bgcolor="#FAFAF1">
					<td height="28" colspan=4 align=center>&nbsp;
						<input type="submit" value="保存" class="coolbg">	
						<input  type="button" value="返回" class="coolbg" onclick="back();" >
						<input id="tid" name="tid" type="hidden" value="${task.tid}"/>
					</td>
				</tr>
			</table>		
		</form>	
	</body>
</html>
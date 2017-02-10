<%@ page import="com.zrgk.task.model.Task"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看任务</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 调用CSS样式 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>skin/css/base.css">
	
	<script type="text/javascript" src="<%=basePath%>jsp/jsp_task/js/jsTask.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.js"></script>

  </head>
  
  <body leftmargin="8" topmargin="8">

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
		<tr>
		 <td height="26" background="skin/images/newlinebg3.gif">
		  <table width="58%" border="0" cellspacing="0" cellpadding="0">
		  <tr><td>当前位置:任务管理>>查看任务</td></tr>
		  </table>
		 </td>
		</tr>
		</table>
		<!-- 查看任务表单 -->
		<form name="form2">		
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;查看任务&nbsp;</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
					<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">农业银行自助管理系统</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
					<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<input id="planOption" name="planOption" value="${task.planOption}"/>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
					<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<input id="beginTime" name="beginTime" value="${empl.beginTime}"/>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<input id="endTime" name="endTime" value="${task.endTime}"/>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
					<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<input id="position" name="position" 
							value='<c:choose>
									<c:when test="${empl.position==1}">张含馨--初级程序员</c:when>
									<c:when test="${empl.position==2}">张&nbsp;&nbsp;伟--中级程序员</c:when>
									<c:when test="${empl.position==3}">孙传杰--项目经理</c:when>
									<c:otherwise>其&nbsp;&nbsp;他</c:otherwise>
							</c:choose>'/>
						</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">发布人：</td>
					<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<input id="executor" name="executor" value="${task.executor}"/>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
					<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<input id="state" name="state" value="
							<c:choose>
									<c:when test="${task.position==1}">未开始</c:when>
									<c:when test="${task.position==2}">进行中...</c:when>
									<c:when test="${task.position==3}">结束</c:when>
							</c:choose>"/>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
					<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<input id="grade" name="grade" value="
							<c:choose>
									<c:when test="${task.position==0}">暂缓</c:when>
									<c:when test="${task.position==1}">低</c:when>
									<c:when test="${task.position==2}">中</c:when>
									<c:when test="${task.position==3}">高</c:when>
							</c:choose>"/>
					</td>
				</tr>		
				<tr>
					<td align="right" bgcolor="#FAFAF1" >详细说明：</td>
					<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
						<input id="detailExplain" name="detailExplain" value="${task.detailExplain}"/>
					</td>
				</tr>
				<tr bgcolor="#FAFAF1">
					<td height="28" colspan=4 align=center>&nbsp;
						<input type="submit" value="返回" class="coolbg" onClick="task.jsp">
						<input id="tid" name="tid" type="hidden" value="${task.tid}"/>
						
						<%-- <a href="<%=basePath%>queryAll.Servlet" class="coolbg">返回</a> --%>
						
					</td>
				</tr>
			</table>	
		</form>	
	</body>
</html>
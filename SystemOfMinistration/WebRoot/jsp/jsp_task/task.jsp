<%@ page import="com.zrgk.task.model.Task"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 导入c标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>任务信息</title>
	    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 调用CSS样式中的base.css -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>skin/css/base.css">
	<!-- 引用脚本 -->
	<script type="text/javascript" src="<%=basePath%>jsp/jsp_task/js/jsTask.js"></script>
  </head>
	 <body leftmargin="8" topmargin="8">
	
		<!---------------------------------------- 快速转换位置按钮 -------------------------------------- -->
		<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
			<tr>
			 <td height="26" background="skin/images/newlinebg3.gif">
			  <table width="58%" border="0" cellspacing="0" cellpadding="0">
				 <tr>
				  <td>当前位置:任务管理>>任务信息 </td>
				  <td><input type='button' class="coolbg np" onclick="getExecutor();" value='添加任务' /></td>
				 </tr>
			  </table>
			 </td>
			</tr>
		</table>
		
		<!-- --------------------------------------搜索表单 -------------------------------------- -->
		<form name='form1' name="form1" action='<%=basePath %>taskServlet' method='post'>
			<input type='hidden' name='dopost' value='' />
			<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
			  <tr bgcolor='#EEF4EA'>
			    <td background='skin/images/wbg.gif' align='center'>
			      <table border='0' cellpadding='0' cellspacing='0'>
			        <tr><td width='90' align='center'>状态：</td>
			          <td width='160'>
				          <select name='cid' id = "cid" style='width:150'>
				          	<option value='0'>请选择</option>
				          	<option value='1'>未开始</option>
				          	<option value='2'>进行中</option>
				          	<option value='3'>已完成</option>
				          </select>
			        </td>
			          <td width='90' align='center'>搜索条件：</td>
			          <td width='160'>
			          <!-- ----------------隐藏域存回写值--------------------------- -->
			          <input type="hidden" id="hides" name="hides" value=${search }/>
				         <select id="search" name='search' style='width:150'  >
				          	<option value='0'>选择类型...</option>
				          	<option value='4'>任务标题</option>
				          	<option value=''>执行者</option>
				          </select>
			        </td>
			        <td width='70'>关键字：</td>
			        <td width='160'>
			        	<!--------- 小标记：在servlet里，可判断值是否从搜索表单提交过去 ------>
			          	<input type='text' id="keyword" name='keyword' style='width:120px' value='${key }' />
			        </td>
			        <td width='110'>
			        	<input type="hidden" id="hid" name="hid" value=${orderBy } />
			    		<select  id="orderby" name='orderby' style='width:120px'>
				            <option value='id'>排序...</option>
				            <option value='1'>开始时间</option>
				            <option value='2'>结束时间</option>
			      		</select>
			        </td>
			        <td>
			          &nbsp;&nbsp;&nbsp;<input type="submit" value="搜索"  width="45" height="20" border="0" class="np" />
			        </td>
			       </tr>
			      </table>
			    </td>
			  </tr>
			</table>
		</form>
		<!-- ------------------------------------------------内容列表  -------------------------- -->
		<form id="form2" name="form2" action="<%=basePath %>DeleteTaskServlet" method="post">
			<!-- ----------------隐藏域：存js处理后的复选框的值--------------------- -->	
			<input type="hidden" id="hiddel" name="hiddel" />
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;任务信息&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">选择</td>
					<td width="6%">序号</td>
					<td width="10%">任务标题</td>
					<td width="10%">执行者</td>
					<td width="8%">状态</td>
					<td width="8%">优先级</td>
					<td width="8%">开始时间</td>
					<td width="8%">结束时间</td>
					<td width="15%">操作</td>
				</tr>
				<c:forEach var="task" items="${list}" varStatus="statu">				
					<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
						<td><input name="id" type="checkbox" id="id" value="${task.tid}" class="np"/></td>
						<!-- 通过循环取变量值 -->
						<td>${task.tid}</td>
						<td>${task.planOption}</td>
						<td align="center">
						<c:forEach var="em" items="${name }" >	
							 <c:if test="${task.executor==em.eid}">${em.name }</c:if>
							</c:forEach>
						</td>
						<td align="center">
							<!-- ----用C标签进行状态的判断赋值---- -->		
							<c:choose >
								<c:when test="${task.status==1}">未开始</c:when>
								<c:when test="${task.status==2}">进行中</c:when>
								<c:when test="${task.status==3}">完成</c:when>
							</c:choose>
						</td>
						<td align="center"> 
							<c:choose >
									<c:when test="${task.grade==1}">高</c:when>
									<c:when test="${task.grade==2}">中</c:when>
									<c:when test="${task.grade==3}">低</c:when>
									<c:when test="${task.grade==4}">暂缓</c:when>
							</c:choose>
							
						
						
						</td>
						<td>${task.beginTime}</td>
						<td>${task.endTime}</td>
						<td>
							<!------- 添加计时器  ---------->						
							<a href="<%=basePath%>updateByTidTaskServlet?tid=${task.tid }" >开始任务</a> | 
							<a href="<%=basePath%>updateByTidEndTaskServlet?tid=${task.tid}">任务完成</a> |
							<a href="<%=basePath%>queryByIdTask?tid=${task.tid}">编辑</a> | 
							<a href="<%=basePath%>queryAllTask.Servlet?tid=${task.tid}">查看详情</a>
						</td>
					</tr>
				</c:forEach>	
				<!----------------- 对任务信息中的对表格进行——全选、反选、删除与导出Excel操作的单元格设计 -------------->
				<tr bgcolor="#FAFAF1">
					<td height="28" colspan="12">
						&nbsp;
						<a href="javascript:onclick=all();" class="coolbg">全选</a>
						<a href="javascript:onclick=reAll();" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:onclick=subDel();" class="coolbg">&nbsp;删除&nbsp;</a>
						<a href="<%=basePath%>excelServlet" class="coolbg">&nbsp;导出Excel&nbsp;</a>
					</td>
				</tr>
				<tr align="right" bgcolor="#EEF4EA">
									
					<td height="36" colspan="12" align="center">
						<!------------------------------翻页代码 -------------------------------->
						 <%
							Task task=(Task)request.getAttribute("task");
							
							if(task!=null){
				    		for(int i=1;i<=task.getTotalPage();i++){
				    			%>
				    				<a href="<%=basePath%>taskServlet?currentPage=<%=i%>"><%=i%></a> 
				    			<% 
				    		}
				    	}
				    	 %>
					</td>
				</tr>
			</table>	
		</form>
		<script typt="text/javascript">
			/* 搜索下拉框脚本  */
			searchBox();
			/* 排序下拉框脚本  */
			orderBox();
		</script>
	</body>
</html>
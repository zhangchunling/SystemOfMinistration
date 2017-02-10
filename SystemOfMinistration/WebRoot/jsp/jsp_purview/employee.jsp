<%@page import="com.zrgk.purview.model.Employee"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="jsp/jsp_purview/js/addEmployee.js"></script>
<style type="text/css">
a:ACTIVE {
	letter-spacing: 5px;
	text-decoration: none;
	color: red;
}


</style>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:权限管理>>用户管理</td>
						<td><input type='button' class="coolbg np"
							onclick="addEmployeejs();" value='添加用户' /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!--  搜索表单  -->
	<form name='form3' action="<%=basePath%>queryAll.Servlet" method='post'>
		<input type='hidden' name='dopost' value='' />
		<table width='98%' border='0' cellpadding='1' cellspacing='1'
			bgcolor='#CBD8AC' align="center" style="margin-top:8px">
			<tr bgcolor='#EEF4EA'>
				<td background='skin/images/wbg.gif' align='center'>
					<table border='0' cellpadding='0' cellspacing='0'>
						<tr>
							<td width='90' align='center'>搜索条件：</td>
							<td width='160'><select name='cid' style='width:150'>
									<option value='0'>选择类型...</option>
									<option value='1'>姓名</option>
									<option value='2'>联系电话</option>
							</select></td>
							<td width='70'>关键字：</td>
							<td width='160'><input type='text' name="keyword"   id="keyword" value="${key }" style='width:120px' /></td>
							<td width='110'><select name='time' id="time"
								style='width:120px'> 
									<option checked="checked" >排序...</option>
									<option value='1'>添加时间</option>
									<option value='2'>修改时间</option>
							</select></td>
							<td>&nbsp;&nbsp;&nbsp;<input type="submit" value="搜索" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<!--  内容列表   -->
	<form name="form2">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top:8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;用户列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">选择</td>
				<td width="6%">编号</td>
				<td width="6%">序号</td>
				<td width="10%">姓名</td>
				<td width="10%">职位</td>
				<td width="10%">性别</td>
				<td width="10%">年龄</td>
				<td width="10%">联系电话</td>
				<td width="8%">入职时间</td>
				<td width="8%">状态</td>
				<td width="10%">操作</td>
			</tr>

			<c:forEach var="empl" items="${list}" varStatus="statu">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><input name="id" type="checkbox" value="${empl.eid}"
						class="np"> <input type="hidden" id="selects"></td>
					<td>${statu.count}</td>
					<td>${empl.eid}</td>
					<td>${empl.name}</td>
					<td><c:choose>
							<c:when test="${empl.position==1}">初级开发工程师</c:when>
							<c:when test="${empl.position==2}">中级开发工程师</c:when>
							<c:when test="${empl.position==3}">高级开发工程师</c:when>
							<c:when test="${empl.position==4}">项目经理</c:when>
							<c:otherwise>其它</c:otherwise>
						</c:choose></td>
					<td><c:if test="${empl.sex==1}">男</c:if> <c:if
							test="${empl.sex==2}">女</c:if></td>
					<td>${empl.age}</td>
					<td>${empl.tel}</td>
					<td>${empl.entryTime}</td>
					<td><c:if test="${empl.state==1}">正常</c:if> <c:if
							test="${empl.state==2}">注销</c:if></td>


					<td><a href="javascript:onclick=deleteEmployee('${empl.eid}');">删除</a> &nbsp; |&nbsp;
						<a href="<%=basePath%>queryByEid.Servlet?eid=${empl.eid}">编辑</a>&nbsp;|<a
						href="<%=basePath%>lookEmployee.Servlet?eid=${empl.eid}">查看详情</a>
							<input type="hidden" id="eid" value="${empl.eid}">
						</td>
				
				</tr>

			</c:forEach>


			<tr bgcolor="#FAFAF1">
				<td height="28" colspan="12">&nbsp; <a
					href="javascript:onclick=allSelect();" class="coolbg">全选</a> <a
					href="javascript:onclick=allNoSelect();" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:onclick=getEid();" class="coolbg">&nbsp;注销&nbsp;</a>
					<a href="export.Servlet" class="coolbg">&nbsp;导出Excel&nbsp;</a>
				</td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="12" align="center">
					<!--翻页代码 -->
				<%
				Employee em=(Employee)request.getAttribute("employee");
				
				int nextPage=1;
				if(em.getCurrentPage()==em.getTotalPage()){
				 
					nextPage=em.getCurrentPage();	
				}else{
				
					nextPage=em.getCurrentPage()+1;	
				
				}
				
				int upPage=1;
				if(em.getCurrentPage()>1){
				
					upPage=em.getCurrentPage()-1;	
				}
				 
				 %>
					
					
				 <a href="<%=basePath%>queryAll.Servlet?currentPage=1">首页</a>
				 <a href="<%=basePath%>queryAll.Servlet?currentPage=<%=upPage%>">上一页</a>
				<a href="<%=basePath%>queryAll.Servlet?currentPage=<%=nextPage%>">下一页</a>
				<a href="<%=basePath%>queryAll.Servlet?currentPage=<%=em.getTotalPage()%>">尾页</a><br/><br/>
 	  
				
				</td>
			</tr>
		</table>

	</form>
</body>
</html>
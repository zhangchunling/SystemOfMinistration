<%@page import="com.zrgk.purview.model.Role"%>
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
<title>角色管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="<%=basePath%>jsp/jsp_purview/js/addRole.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.js"></script>


</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:权限管理>>角色管理</td>
						<td><input type="button" class="coolbg np"
							onclick="addRole()" value='添加角色' /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<!--  搜索表单  -->
	<form name='form3' action="<%=basePath%>queryAllRole.Servlet" method='post'>
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
									<option value='1'>角色名称</option>
							</select></td>
							<td width='70'>关键字：</td>
							<td width='160'><input type='text' id='keyword'  name="keyword" value="${keyRole }"
								style='width:120px' /></td>
							<td>&nbsp;&nbsp;&nbsp;<input name="imageField" type="submit"
							value="搜索" 	src="skin/images/frame/search.gif" width="45" height="20"
								border="0" class="np" />
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
				<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;角色列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">选择</td>
				<td width="6%">编号</td>
				<td width="6%">序号</td>
				<td width="10%">角色编号</td>
				<td width="10%">角色名称</td>
				<td width="8%">状态</td>
				<td width="10%">操作</td>
			</tr>

			<c:forEach var="empl" items="${list}" varStatus="statu">

				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><input name="id" type="checkbox" id="id" value="${empl.rid}"
						class="np">
						<input type="hidden" id="selects" >
					</td>
					<td>${statu.count}</td>
					<td>${empl.rid}</td>
					<td>${empl.roleNum}</td>
					<td align="center">${empl.roleName}</td>
					<td><c:if test="${empl.state==1}">启用</c:if> <c:if
							test="${empl.state==2}">禁用</c:if></td>
					<td><a href="javascript:onclick=deleteRole('${empl.rid}');">删除</a>
						|<a href="<%=basePath%>queryByRid.Servlet?rid=${empl.rid}">编辑</a>
						| <a href="<%=basePath%>lookRole.Servlet?rid=${empl.rid}">查看详情</a>
					</td>
				</tr>

			</c:forEach>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan="12">&nbsp; <a href="javascript:onclick=allSelect();" class="coolbg">全选</a>
					<a href="javascript:onclick=allNoSelect();" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:onclick=getRid();" class="coolbg">&nbsp;禁用&nbsp;</a>
				</td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="12" align="center">
					<!--翻页代码 -->
					
					<%
				Role em=(Role)request.getAttribute("role");
				
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
					
				 <a href="<%=basePath%>queryAllRole.Servlet?currentPage=1">首页</a>
				 <a href="<%=basePath%>queryAllRole.Servlet?currentPage=<%=upPage%>">上一页</a>
				<a href="<%=basePath%>queryAllRole.Servlet?currentPage=<%=nextPage%>">下一页</a>
				<a href="<%=basePath%>queryAllRole.Servlet?currentPage=<%=em.getTotalPage()%>">尾页</a><br/><br/>
 	  
				 
				</td>
			</tr>
		</table>

	</form>


</body>
</html>

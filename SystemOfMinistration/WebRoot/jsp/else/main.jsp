<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>main</title>
	<base target="_self">
	<!-- CSS样式 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>skin/css/base.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>skin/css/main.css" />
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body leftmargin="8" topmargin='8'>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td><div style='float:left'> <img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用中软高科实训项目管理系统</div>
	      <div style='float:right;padding-right:8px;'>
	        <!--  //保留接口  -->
	      </div>
	    </td>
	  </tr>
	  <tr>
	    <td height="1" background="skin/images/frame/sp_bg.gif" style='padding:0px'></td>
	  </tr>
	</table>
	<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
	  <tr>
	    <td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>待完成任务</span></td>
	  </tr>
	  <tr bgcolor="#FFFFFF">
	    <td>您有<a href=""><font color="red">2</font></a>个任务未完成……&nbsp;</td>
	  </tr>
	</table>
	<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
	  <tr>
	    <td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>未读消息</span></td>
	  </tr>
	  <tr bgcolor="#FFFFFF">
	    <td>您有<a href="<%=basePath %>q.servlet"><font color="red">10</font></a>条未读消息……&nbsp;</td>
	  </tr>
	</table>
	<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
	  <tr>
	    <td colspan="2" background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'>
	    	<div style='float:left'><span>快捷操作</span></div>
	    	<div style='float:right;padding-right:10px;'></div>
	   	</td>
	  </tr>
		  <tr bgcolor="#FFFFFF">
		    <td height="30" colspan="2" align="center" valign="bottom">
			    <table width="100%" border="0" cellspacing="1" cellpadding="1">
			        <tr>
			          <td width="15%" height="31" align="center"><img src="skin/images/frame/qc.gif" width="90" height="30" /></td>
			          <td width="85%" valign="bottom">
			          		<div class='icoitem'>
				              <div class='ico'><img src='skin/images/frame/addnews.gif' width='16' height='16' /></div>
				              <div class='txt'><a href='project-base.jsp'><u>查看项目信息</u></a></div>
				            </div>
				            <div class='icoitem'>
				              <div class='ico'><img src='skin/images/frame/menuarrow.gif' width='16' height='16' /></div>
				              <div class='txt'><a href='task-my.jsp'><u>查看任务</u></a></div>
				            </div>
				            <div class='icoitem'>
				              <div class='ico'><img src='skin/images/frame/manage1.gif' width='16' height='16' /></div>
				              <div class='txt'><a href='task-add.jsp'><u>发布任务</u></a></div>
				            </div>
				            <div class='icoitem'>
				              <div class='ico'><img src='skin/images/frame/file_dir.gif' width='16' height='16' /></div>
				              <div class='txt'><a href='<%=basePath%>q.servlet'><u>收件箱</u></a></div>
				            </div>
				            <div class='icoitem'>
				              <div class='ico'><img src='skin/images/frame/part-index.gif' width='16' height='16' /></div>
				              <div class='txt'><a href='info.jsp'><u>个人信息</u></a></div>
				            </div>
				            <div class='icoitem'>
				              <div class='ico'><img src='skin/images/frame/manage1.gif' width='16' height='16' /></div>
				              <div class='txt'><a href='modpassword.jsp'><u>修改密码</u></a></div>
				            </div>
			            </td>
			        </tr>
			      </table>
		      </td>
		  </tr>
		</table>
	<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
	  <tr bgcolor="#EEF4EA">
	    <td colspan="2" background="skin/images/frame/wbg.gif" class='title'><span>温馨信息</span></td>
	  </tr>
	  <tr bgcolor="#FFFFFF">
	    <td width="25%" bgcolor="#FFFFFF">您的级别：</td>
	    <td width="75%" bgcolor="#FFFFFF">管理员</td>
	  </tr>
	</table>
</body>
</html>
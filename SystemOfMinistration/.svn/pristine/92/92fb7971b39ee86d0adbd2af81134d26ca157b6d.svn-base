<%@page import="com.zrgk.myinfo.model.Employee"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<base href="<%=basePath%>">

<TITLE>欢迎登陆中软高科实训项目管理系统</TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2800.1611" name=GENERATOR>
<LINK href="<%=basePath%>images/css1.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath%>images/newhead.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="<%=basePath%>jsp/jsp_myinfo/js/login.js">
	
</script> 

<script language="javascript" type="text/javascript">//验证码刷新
  function changeImage(){
	//验证码请求的servlet地址 后面传随机生成的a的参数目的：解决浏览的缓存
  	var url="<%=basePath%>getKey?a="+Math.random();
   	document.getElementById("imgkey").src=url;//给img标签的src属性赋一个新请求地址实现刷新验证码
  }
 </script>

</HEAD>
<BODY bgColor=#eef8e0 leftMargin=0 topMargin=0 MARGINWIDTH="0" MARGINHEIGHT="0">
	<FORM name=adminlogin action="<%=basePath %>loginServlet" method=post onsubmit="return check_form();">
		<TABLE cellSpacing=0 cellPadding=0 width=1004 border=0 align="center">
		
			<TBODY>
				<TR>
					<TD colSpan=6><IMG height=92 alt="" src="<%=basePath%>images/crm_1.gif" width=345></TD>
					<TD colSpan=4><IMG height=92 alt="" src="<%=basePath%>images/crm_2.gif" width=452></TD>
					<TD><IMG height=92 alt="" src="<%=basePath%>images/crm_3.gif" width=207></TD>
				</TR>
				<TR>
					<TD colSpan=6><IMG height=98 alt="" src="<%=basePath%>images/crm_4.gif" width=345></TD>
					<TD colSpan=4><IMG height=98 alt="" src="<%=basePath%>images/crm_5.gif" width=452></TD>
					<TD><IMG height=98 alt="" src="<%=basePath%>images/crm_6.gif" width=207></TD>
				</TR>
				<TR>
					<TD rowSpan=5><IMG height=370 alt="" src="<%=basePath%>images/crm_7.gif" width=59></TD>
					<TD colSpan=5><IMG height=80 alt="" src="<%=basePath%>images/crm_8.gif" width=286></TD>
					<TD colSpan=4><IMG height=80 alt="" src="<%=basePath%>images/crm_9.gif" width=452></TD>
					<TD><IMG height=80 alt="" src="<%=basePath%>images/crm_10.gif" width=207></TD>
				</TR>
				<TR>
					<TD><IMG height=110 alt="" src="<%=basePath%>images/crm_11.gif" width=127></TD>
					<TD background=<%=basePath%>images/crm_12.gif colSpan=6>
						<TABLE id=table1 cellSpacing=0 cellPadding=0 width="98%" border=0>
							<TBODY>
								<TR>
									<TD>
										<TABLE id=table2 cellSpacing=1 cellPadding=0 width="100%" border=0>
											<TBODY>
												<TR><!-- 用户名 -->
													<TD  align=middle width=81><FONT color=#ffffff>用户名：</FONT></TD>
													<TD><INPUT class=regtxt title=请填写用户名 maxLength=16
														size=16  id="username" name="username"></TD>
												</TR>
												<TR><!-- 密码 -->
													<TD align=middle width=81><FONT color=#ffffff>密&nbsp;码：</FONT></TD>
													<TD><INPUT class=regtxt title=请填写密码 type="password"
														maxLength=16 size=16 id="password"  name="password"></TD>
												</TR>
											 	<TR><!-- 验证码 -->
													<TD align=middle width=81><FONT color=#ffffff>验证码：</FONT></TD>
													<TD><INPUT type="text" class=regtxt title=请填写验证码 size="10" id="key" name="key"/>
														<INPUT type=hidden value=check name=login id=login/> 
														 <a href="javascript:onclick=changeImage()">
														<img alt="点击刷新验证码" src="<%=basePath%>getKey" id="imgkey"/></a>&nbsp;&nbsp;${msg}			
														</TD>
												</TR> 
						
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD colSpan=2 rowSpan=2><IMG height=158 alt="" src="<%=basePath%>images/crm_13.gif" width=295></TD>
					<TD rowSpan=2><IMG height=158 alt="" src="<%=basePath%>images/crm_14.gif" width=207></TD>
				</TR>
				<TR>
					<TD rowSpan=3><IMG height=180 alt="" src="<%=basePath%>images/crm_15.gif" width=127></TD>
					<TD rowSpan=3><IMG height=180 alt="" src="<%=basePath%>images/crm_16.gif" width=24></TD>
					<TD><INPUT title=登录中软高科实训项目管理系统 type=image height=48 alt="" width=86 src="<%=basePath%>images/crm_17.gif" name=image></TD>
					<TD><IMG height=48 alt="" src="<%=basePath%>images/crm_18.gif" width=21></TD>
					<TD colSpan=2><A><IMG title=关闭页面 height=48 alt="" src="<%=basePath%>images/crm_19.gif" width=84 border=0></A></TD>
					<TD><IMG height=48 alt="" src="<%=basePath%>images/crm_20.gif" width=101></TD>
					
				</TR>
				<TR>
					<TD colSpan=5 rowSpan=2><IMG height=132 alt="" src="<%=basePath%>images/crm_21.gif" width=292></TD>
					<TD rowSpan=2><IMG height=132 alt="" src="<%=basePath%>images/crm_22.gif" width=170></TD>
					<TD colSpan=2><IMG height=75 alt="" src="<%=basePath%>images/crm_23.gif" width=332></TD>
				</TR>
				<TR>
					<TD colSpan=2><IMG height=57 alt="" src="<%=basePath%>images/crm_24.gif" width=332></TD>
				</TR>
				<TR>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=59></TD>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=127></TD>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=24></TD>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=86></TD>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=21></TD>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=28></TD>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=56></TD>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=101></TD>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=170></TD>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=125></TD>
					<TD><IMG height=1 alt="" src="<%=basePath%>images/spacer.gif" width=207></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>

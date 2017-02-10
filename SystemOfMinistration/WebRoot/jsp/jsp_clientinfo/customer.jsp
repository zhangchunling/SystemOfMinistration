<%@page import="com.zrgk.clientinfo.model.Customers"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>客户信息管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>skin/css/base.css">
<script type="text/javascript" >

//全选
function all(){
		var Array=document.getElementsByName("id");
		for(var i=0;i<Array.length;i++){
				Array[i].checked=true;
		}
	}

//反选
function reAll(){
		var Array=document.getElementsByName("id");
		for(var i=0;i<Array.length;i++){
			if(Array[i].checked){
				Array[i].checked=false;
			}else{
				Array[i].checked=true;
			}
		}
	}


//删除
function delForm2(){
	var cusArray=document.getElementsByName("id");//得到复选框的数组
			var str="";
			for(var i=0;i<cusArray.length;i++){
				if(cusArray[i].checked){
					str=str+cusArray[i].value+",";//拼接字符串
				}
			}
		document.getElementById("hidd").value=str.substring(0,str.length-1);//去掉最后的逗号，并赋给赋给隐藏域
	if(document.getElementById("hidd").value!=null&&document.getElementById("hidd").value!=""){
		if (confirm("确定要删除吗？")){
			document.getElementById("form2").submit();
		}
	}else{	
		alert("请选择要删除的语句");
 	}
 }
 
 // 导出excel
 function excel(url){
	var cusArray=document.getElementsByName("id");//得到复选框的数组
			var str="";
			for(var i=0;i<cusArray.length;i++){
				if(cusArray[i].checked){
					str=str+cusArray[i].value+",";//拼接字符串
				}
			}	
	document.getElementById("hidd").value=str.substring(0,str.length-1);//去掉最后的逗号，并赋给赋给隐藏域
	if(document.getElementById("hidd").value!=null&&document.getElementById("hidd").value!=""){
		if (confirm("确定要导出吗？")){
			window.location.href=url+"?hidd="+str.substring(0,str.length-1);
		}
	}else{	
		alert("请选择要导出的语句");
 	} 
 }
 
 
 
//提交form3
	function subForm3(){
		document.getElementById("form3").submit();
	}
	
</script>
</head>
<body leftmargin="8" topmargin="8" background='<%=basePath%>skin/images/allbg.gif'>


<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="<%=basePath%>skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:客户信息管理>>客户信息
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='<%=basePath %>jsp/jsp_clientinfo/customer-add.jsp';" value='添加客户信息' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='<%=basePath%>musersListServlet.action' method='post' onsubmit="return overrideValue();">
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='<%=basePath%>skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select id='type' name='type' style='width:150'>
          <option value='0' <c:if test="${sell=='0'}"/> >选择类型...</option>
          <option value='1' <c:if test="${sell=='1'}"/> >客户所在公司名称</option>
          <option value='2' <c:if test="${sell=='2'}"/> >联系人姓名</option>
          </select>
          <input type="hidden" id="tempType" name="tempType" value=${u.type }  >
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type="text" id="keyword" name="keyword" value="" style="width:120px"/>
          	<input type="hidden" id="fla" name="fla" value="1"/>
        </td>
        <td width='110'>
    		<select id='time' name='time' style='width:120px'>
            <option value='0'>排序...</option>
            <option value='1'>添加时间</option>   
      	</select>
      	<input type="hidden" id="tempTime" name="tempTime" value=${u.time }  >
        </td>
        <td>
          &nbsp;&nbsp;&nbsp; 
         <input name="imageField" type="image" src="<%=basePath%>skin/images/frame/search.gif" width="45" height="20" border="0" class="np" /> 
        </td> 
       </tr>
      </table>
    </td> 
  </tr>
</table>
</form>
<!--  内容列表   -->

<form name="form2" id="form2" class="coolbg" action='<%=basePath%>mdeleteUserServlet.action' method="post" >
<input type="hidden" id="hidd" name="hidd"/>

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">

<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="<%=basePath%>skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">联系人</td>
	<td width="10%">公司名称</td>
	<td width="8%">添加时间</td>
	<td width="8%">联系电话</td>
	<td width="10%">操作</td>
</tr>

<c:forEach var="custom" items="${list}" varStatus="statu">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="id" type="checkbox" id="id" value="${custom.cid}" class="np"></td>
	<td>${custom.cid}</td>
	<td>${custom.customerName}</td>
	<td align="center">${custom.companyName}</td>
	<td>${custom.addTime}</td>
	<td>${custom.customerTel}</td>
	<td><a href="<%=basePath %>mbyIdServlet.action?id=${custom.cid}">编辑</a> | 
	<a href="<%=basePath %>mlookUserServlet.action?id=${custom.cid}">查看详情</a></td>

</tr>
</c:forEach>
<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:onclick=all();" class="coolbg">全选</a>
	<a href="javascript:onclick=reAll();" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:onclick=delForm2();" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="javascript:onclick=excel('<%=basePath %>mexcelServlet.action');" class="coolbg">&nbsp;导出Excel&nbsp;</a>
	
</td>
</tr>
<!--翻页代码 -->

<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center">
	<%
		Customers user=(Customers)request.getAttribute("user");
	 	//计算下一页的值
	 	int nextPage=1;
	 	//如果当前页已经是最后一页则不加值
    	if(user.getCurrentPage()==user.getTotalPage()){
    		nextPage=user.getCurrentPage();
    	}else{
    		nextPage=user.getCurrentPage()+1; //下一页计算的值 
    	}   
	 	//计算上一页的值 
    	int upPage=1;
    	if(user.getCurrentPage()>1){
    		upPage=user.getCurrentPage()-1;
	 	}
	 %>
	 
	<a href="<%=basePath%>musersListServlet.action?currentPage=1">首页</a>  
	<a href="<%=basePath%>musersListServlet.action?currentPage=<%=upPage%>">上一页 </a> 
	<a href="<%=basePath%>musersListServlet.action?currentPage=<%=nextPage%>">下一页</a>  
	<a href="<%=basePath%>musersListServlet.action?currentPage=<%=user.getTotalPage()%>">尾页</a>
	</td></tr>



</table>
</form>
  

</body>
</html>
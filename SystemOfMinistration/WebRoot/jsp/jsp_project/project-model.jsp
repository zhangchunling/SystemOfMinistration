<%@page import="com.zrgk.project.model.Caker"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>模块管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>模块管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='<%=basePath %>/jsp/jsp_project/project-model-add.jsp';" value='添加新模块' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          
          <td width='160'>
          <input type="hidden" id="hides" name="hides" value=${needConditon } /><!-- 隐藏域存回写值 -->           
          <select id="cakeCondition" name='cakeCondition' style='width:150'>          
          <option value='0'>选择类型...</option>
          	<option value='1'>项目名称</option>
          	<option value='2'>需求名称</option>
          	<option value='3'>模块名称</option>
          </select>
        </td>
        
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
       		<input type="hidden" id="keyhid" name="keyhid" value=1 /><!-- 标记：在servlet里可判断值是否从搜索表单提交过去 -->
          	<input type='text' id="keyword" name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
        	<input type="hidden" id="hid" name="hid" value=${order } />
    		<select id="orderby" name='orderby' style='width:120px'>
            <option value='id'>排序...</option>
            <option value='pubdate'>添加时间</option>
            <option value='pubdate'>修改时间</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;模块列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">模块名称</td>
	<td width="10%">需求名称</td>
	<td width="10%">项目名称</td>
	<td width="10%">优先级</td>
	<td width="8%">添加时间</td>
	<td width="8%">修改时间</td>
	<td width="10%">操作</td>
</tr>
<c:forEach var="caker" items="${list }" varStatus="sta">
	<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
		<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
		<td>${sta.index+1 }</td>
		<td align="center"><a href=''><u>${caker.cakeName }</u></a></td>
		<td align="center"><a href=''><u>${caker.needName }</u></a></td>
		<td align="center"><a href=''><u>${caker.proName }</u></a></td>
		<td>
			<!-- 用C标签进行状态的判断赋值 -->		
			<c:choose >
				<c:when test="${caker.priority==1}">高</c:when>
				<c:when test="${caker.priority==2}">中</c:when>
				<c:when test="${caker.priority==3}">低</c:when>
				<c:when test="${caker.priority==4}">暂缓</c:when>
			</c:choose>		
		</td>
		<td>${caker.createTime }</td>
		<td>${caker.updateTime }</td>
		<td><a href="<%=basePath %>cakeEditServlet.action?cid=${caker.cid }">编辑</a> | <a href="<%=basePath %>cakeLookservlet.action?cid=${caker.cid}">查看详情</a></td>
	</tr>
</c:forEach>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 -->
	<!--------------------翻页代码------------------有时间改成EL表达式 -->
	<%    		
    		Caker caker=(Caker)request.getAttribute("caker");//通过"user"得到封装着部分信息的user
    		//计算下一页的值
    		int nextPage=1;    		
    		//注：总页数已在javabean里封装对象里算出了值
    		if(caker.getCurrentPage()==caker.getTotalPage()){	//如果当前页已经是最后一页则不加值,始终等于最后一页
    			nextPage=caker.getCurrentPage();
    		}else{
    			nextPage=caker.getCurrentPage()+1; 				//下一页计算的值 
    		}
    		
    		//计算上一页的值 
    		int upPage=1;
    		if(caker.getCurrentPage()>1)
    		upPage=caker.getCurrentPage()-1;
    	 %>
	<a href="<%=basePath%>cakeServlet.action?currentPage=1&acon=${cakeConditon }&akey=${key }&aorder=${order }" >＜＜首页</a> 
	<a href="<%=basePath%>cakeServlet.action?currentPage=<%=upPage%>&acon=${cakeConditon }&akey=${key }&aorder=${order }">＜上一页 </a> 
	<a href="<%=basePath%>cakeServlet.action?currentPage=<%=nextPage%>&acon=${cakeConditon }&akey=${key }&aorder=${order }">下一页＞</a>  
 	<a href="<%=basePath%>cakeServlet.action?currentPage=<%=caker.getTotalPage()%>&acon=${cakeConditon }&akey=${key }&aorder=${order }">尾页＞＞</a>
	<input type="hidden" id="heidder" name="heidder" /><!-- ----隐藏域存js处理后的复选框的值--- -->
	</td>
</tr>
</table>

</form>
   <!-- ---------------处理搜索表单的回写：下拉框---------------- -->
<script type="text/javascript">	
	//处理搜索条件下拉框
	function checkcon(){	
		var a=document.getElementById("cakeCondition");		//获取select对象	
		var Arrays=a.options;								//获取option数组
		var older=document.getElementById("hides").value;	//获取隐藏域里接收的值
		for(var j=0;j<Arrays.length;j++){					//遍历		
			if(older==Arrays[j].value){						//判断与隐藏域里接收的值是否相等
				Arrays[j].selected=true;					//相等的话就赋true，使其回写选中
				break;
			}
		}
		
	}
	//处理排序下拉框
	function checkorder(){
		var aa=document.getElementById("orderby");		
		var Array=aa.options;//数组
		var old=document.getElementById("hid").value;
		for(var i=0;i<Array.length;i++){
			if(old==Array[i].value){
				Array[i].selected=true;
				break;
			}
		}
	}
	
	checkcon();		//调用，调用就表示触发
	checkorder();	//调用，调用就表示触发
</script> 
<!-- ------在body标签里写的javaScritp，里面的方法调用一下就可被执行------ -->

</body>
</html>
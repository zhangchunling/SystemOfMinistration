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
<title>编辑模块信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.js"></script><!-- 导异步要用的jquery包 -->
<!-- 导步实现联动的脚本 -->
<script type="text/javascript">
	//一加载驱动该事件
	function getBasicer(){
			$.ajax({
				url : "cakeJaxaservlet.action",	//引号里是要访问的servlet配置名
				data : "parentId=0",			//要传的参
				dataType : "text",				//返回数据的格式是字符串，还有一种是json处理，【也可以去掉不写】
							
				success : function(data) {		//成功返回数据调用的方法，里面的data有servlet返回的流，是字符串
				
					var basicer=$('#proName');	//得到项目下拉框的对象
					var temp1=data.substr(0,data.length-1).split(";");	//把返回的数据去掉最后一个分号然后再以分号截取成二维字符串数组
					for(var i=0;i<temp1.length;i++){
						var temp2=temp1[i].split(",");					//再以逗号截取成只有id与名字的一维数组
						var id=temp2[0];
						var value=temp2[1];
						var opt=new Option(value,id);					//第1个是文本内容，第二个是value的值
						basicer.append(opt);							//向select下拉框里赋option选项，用的是append()追加方法
					}
				},
			});
	}
	
	function getNeeder(id){//通过传来上一级的id去查询
		$.ajax(
			{
				url : "cakeJaxaservlet.action",
				data:"parentId="+id,
				dataType : "text",
				success:function(data){
					var needer=$('#needName');	//获取下拉框对象
					needer.empty();				//清空之前下拉框的值
					if(data!=null&&data!=""){
						var Array=data.substr(0,data.length-1).split(";");
						for(var i=0;i<Array.length;i++){
							var Array2=Array[i].split(",");
							var value=Array2[0];
							var text=Array2[1];
							var opt=new Option(text,value);
							needer.append(opt);
						}
					}
					
				}
			}
		);
	}
</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif' onload="getBasicer();">

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>编辑模块信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑模块&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">选择项目：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="hidden" id="projectName" name="projectName" value="${projectId }" />
		<select id="proName" name="proName" onchange="getNeeder(this.value);"> </select> <!-- 事件是为了给后面赋值 -->
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">选择需求：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input type="hidden" id="needId" name="needId" value="${caker.cid }" />
	<select id="needName" name="needName" >	</select></td><!-- 由联动时赋值 -->
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">模块名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input type="text" value="${caker.cakeName }"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input type="hidden" id="priority" name="proirity" value="${caker.priority }" /><!-- 隐藏域存回写值 -->	
	<select id="prioritySelect" name="prioritySelect">		
	<option value=1>高</option><option value=2>中</option><option value=3>低</option><option value=4>暂缓</option>
	</select></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">简单描述：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea rows=10 cols=130>${caker.simpleStatement }</textarea></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">详细描述：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea rows=15 cols=130>${caker.detail }</textarea></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130>${caker.comment }</textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="project-model.html" class="coolbg">保存</a>
	<a href="cakeServlet.action" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  <script type="text/javascript">
  //优先级
  	function priority(){
  		var send=document.getElementById("priority").value;
  		var now=document.getElementById("prioritySelect");
  		var Array=now.options;
  		for(var i=0;i<Array.length;i++){  		
  			if(Array[i].value==send){
  				Array[i].selected=true;
  				break;
  			}
  		}
  	}
  	priority();//调用就走该方法
  
   	//项目名称
  	function projectName(){
  		var send=document.getElementById("projectName").value;
  		var now=document.getElementById("proName");
  		var Array=now.options;
  		alert("000000000");
  		for(var i=0;i<Array.length ;i++){
  		alert("1");
  			if(Array[i].value==send){
  				Array[i].selected=true;
  				alert("222222");
  				break;
  			}
  		}
  	}
  	projectName();
  	
  	//需求名称
  	function need(){
  		var send=document.getElementById("needId").value;
  		var now=document.getElementById("needName");
  		var Array=now.options;
  		for(var i=0;i<Array.length;i++){
  			if(Array[i].value==send){
  				Array[i].selected=true;
  				break;
  			}
  		}
  	}
  	need();
  	 
  	
  </script>

</body>
</html>
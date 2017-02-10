//校验标题  内容不为空以及发信息的jsp页面的实现方法
function submitForm(){
	var title=document.getElementById("title");
	if(title==null||title.value==null||title.value==""){
		alert("标题不能为空！！！");
		title.focus();
		return false;
	}
	
	
	var content=document.getElementById("content");
	if(content==null||content.value==null||content.value==""){
		alert("内容不能为空！！！");
		title.focus();
		return false;
	}
	document.getElementById("form2").submit();
	alert('发送成功！');
		}	


//判断标题字数超出范围的触发事件
function checktitle(){	
	var title=document.getElementById("title").value;
	if(title.length>10){
		var str=title.substring(0,10);
		document.getElementById("title").value=str;
		alert("标题不能超过10个字符！");
		title.focus();
		return false;
	}	
}

//判断内容字数超出范围的触发事件
function checkcontent(){	
	var content=document.getElementById("content").value;
	if(content.length>100){
		var str=content.substring(0,100);
		document.getElementById("content").value=str;
		alert("内容不能超过100个字符！");
		title.focus();
		return false;
	}	
}

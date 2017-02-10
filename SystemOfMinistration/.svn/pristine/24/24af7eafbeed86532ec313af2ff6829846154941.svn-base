
/* 处理复选框 */
function subForm2(){
	var boxArray=document.getElementsByName("id");//得到复选框数组
	var str="";
	for(var i=0;i<boxArray.length;i++){
		if(boxArray[i].checked){
			str=str+boxArray[i].value+","//拼接字符串
		}
	}
	document.getElementById("hiddel").value=str.substring(0,str.length-1);//去掉最后的逗号，并赋给赋给隐藏域
	if(confirm("您确定要删除吗")){
		document.getElementById("form2").submit();
	}
	
}

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
//提交form3
function subForm3(){
	document.getElementById("form3").submit();
}




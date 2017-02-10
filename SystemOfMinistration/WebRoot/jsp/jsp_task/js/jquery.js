//得到第一级XXXX管理系统
		function getProjectName(id){
			$.ajax({
				url : "jqueryProjectServlet", 	//要访问的servlet
				type: "post",					//访问的方式
				data: "pid="+id,
				dataType: "text",				//json
				beforeSend: function(data) {	//调用servlet前执行的方法
				}, 
				success : function(data) {		//成功返回数据调用的方法
					var project=$('#pid');		//得到省下拉框的对象
					//处理数据
					//把返回的数据去掉最后一个分号然后再以分号截取
					var temp1=data.substr(0,data.length-1).split(";");
					for(var i=0;i<temp1.length;i++){
						var temp2=temp1[i].split(",");//再以逗号截取
						var pid=temp2[0];
						var pname=temp2[1];
						var opt=new Option(pname,pid);
						project.append(opt);//向select下拉框里赋option选项用的是append()追加方法
					}
				}, 
			});
		}
		
		//根据第一级项目名称，得到第二级XXXX需求分析
		function getNeed(id){
		
			$.ajax({
				url : "jqueryNeed.Servlet",//要访问的servlet
				data : "pid="+id,
				success : function(data) {//成功返回数据调用的方法
					var project=$('#nid');//得到省下拉框的对象
					project.empty();//清空下拉框之前的option选项
					//给下拉框初始化一个请选择的项
					var op=new Option("请选择",'');
					project.append(op);
					//处理数据
					//把返回的数据去掉最后一个分号然后再以分号截取
					if(data!=null&&data!=""){//如果返回的没有数据则不用处理返回的信息
						var temp1=data.substr(0,data.length-1).split(";");
						for(var i=0;i<temp1.length;i++){
							var temp2=temp1[i].split(",");//再以逗号截取
							var pid=temp2[0];
							var pname=temp2[1];
							var opt=new Option(pname,pid);
							project.append(opt);//向select下拉框里赋option选项用的是append()追加方法
						}
					}
				},
			});
		}
		
		/*//根据第二级XXXX需求分析，得到账户管理模块
		function getMod(id){
			
			$.ajax({
				url : "jqueryCaker.Servlet",//要访问的servlet
				data : "pid="+id,
				success : function(data) {//成功返回数据调用的方法
					var project=$('#mod');//得到省下拉框的对象
					project.empty();//清空下拉框之前的option选项
					//给下拉框初始化一个请选择的项
					var op=new Option("请选择",'');
					project.append(op);
					//处理数据
					//把返回的数据去掉最后一个分号然后再以分号截取
					if(data!=null&&data!=""){//如果返回的没有数据则不用处理返回的信息
						var temp1=data.substr(0,data.length-1).split(";");
						for(var i=0;i<temp1.length;i++){
							var temp2=temp1[i].split(",");//再以逗号截取
							var pid=temp2[0];
							var pname=temp2[1];
							var opt=new Option(pname,pid);
							project.append(opt);//向select下拉框里赋option选项用的是append()追加方法
						}
					}
				},
			});
		}
		
		//根据第三级账户管理模块，得到添加账户
		function getAccount(id){
			
			$.ajax({
				url : "functioner.Servlet",//要访问的servlet
				data : "pid="+id,
				success : function(data) {//成功返回数据调用的方法
					var project=$('#account');//得到省下拉框的对象
					project.empty();//清空下拉框之前的option选项
					//给下拉框初始化一个请选择的项
					var op=new Option("请选择",'');
					project.append(op);
					//处理数据
					//把返回的数据去掉最后一个分号然后再以分号截取
					if(data!=null&&data!=""){//如果返回的没有数据则不用处理返回的信息
						var temp1=data.substr(0,data.length-1).split(";");
						for(var i=0;i<temp1.length;i++){
							var temp2=temp1[i].split(",");//再以逗号截取
							var pid=temp2[0];
							var pname=temp2[1];
							var opt=new Option(pname,pid);
							project.append(opt);//向select下拉框里赋option选项用的是append()追加方法
						}
					}
				},
			});
		}
		
		//根据执行者，获得option的value
		function getExecutor(id){
			
			$.ajax({
				url : "",//要访问的servlet
				data : "eid="+id,
				success : function(data) {//成功返回数据调用的方法
					var executor=$('#executor');//得到省下拉框的对象
					executor.empty();//清空下拉框之前的option选项
					//给下拉框初始化一个请选择的项
					var op=new Option("请选择",'');
					executor.append(op);
					//处理数据
					//把返回的数据去掉最后一个分号然后再以分号截取
					if(data!=null&&data!=""){//如果返回的没有数据则不用处理返回的信息
						var temp1=data.substr(0,data.length-1).split(";");
						for(var i=0;i<temp1.length;i++){
							var temp2=temp1[i].split(",");//再以逗号截取
							var pid=temp2[0];
							var pname=temp2[1];
							var opt=new Option(pname,pid);
							executor.append(opt);//向select下拉框里赋option选项用的是append()追加方法
						}
					}
				},
			});
		}*/
		
		
/*----------------------得到执行者下拉框----------------------------------*/
		/*function getExecutor(tid){
			$.ajax({
				url : "jqueryStatusServlet", 	//要访问的servlet
				type: "post",					//访问的方式
				data: "tid="+tid,
				dataType: "text",				//json
				beforeSend: function(data) {	//调用servlet前执行的方法
				}, 
				success : function(data) {		//成功返回数据调用的方法
					var project=$('#executor');		//得到状态下拉框的对象
					//处理数据
					//把返回的数据去掉最后一个分号然后再以分号截取
					var temp1=data.substr(0,data.length-1).split(";");
					for(var i=0;i<temp1.length;i++){
						var temp2=temp1[i].split(",");//再以逗号截取
						var tid=temp2[0];
						var tname=temp2[1];
						var opt=new Option(tname,tid);
						project.append(opt);//向select下拉框里赋option选项用的是append()追加方法
					}
				}, 
			});
		}		*/
		
		//根据执行者，获得option的value
		function getExecutor(id){
			
			$.ajax({
				url : "jqueryStatusServlet",//要访问的servlet
				data : "tid="+id,
				success : function(data) {//成功返回数据调用的方法
				var executor=$('#executor');//得到省下拉框的对象
				executor.empty();//清空下拉框之前的option选项
				//给下拉框初始化一个请选择的项
				var op=new Option("请选择",'');
				executor.append(op);
				//处理数据
				//把返回的数据去掉最后一个分号然后再以分号截取
				if(data!=null&&data!=""){//如果返回的没有数据则不用处理返回的信息
					var temp1=data.substr(0,data.length-1).split(";");
					for(var i=0;i<temp1.length;i++){
						var temp2=temp1[i].split(",");//再以逗号截取
						var tid=temp2[0];
						var tname=temp2[1];
						var opt=new Option(tname,tid);
						executor.append(opt);//向select下拉框里赋option选项用的是append()追加方法
					}
				}
			},
		});
	}
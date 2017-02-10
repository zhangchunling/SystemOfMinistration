package com.zrgk.task.model;


/**
 * @function: JavaBean任务相关信息——function_sheet.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class Function_sheet {
	
	private int fid;			//参考位置第四级id，功能表id——function_sheet
	private String functionName;//功能表的名称	
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
}
package com.zrgk.task.model;

/**
 * @function: JavaBean任务相关信息——Basic_Info.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class Basic_Info {
	
	private int pid;			//参考位置第一级id，基本表id——basic_Info
	private String projectName;//基本表中的客户公司名称
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}	
}
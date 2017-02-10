package com.zrgk.task.model;

/**
 * @function: JavaBean任务相关信息——need_sheet.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class Need_sheet {
	
	private int pid;			//参考位置第二级id，需求表id——need_sheet
	private String ptitle;		//需求表的标题
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
}
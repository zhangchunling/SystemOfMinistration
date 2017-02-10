package com.zrgk.task.model;

/**
 * @function: JavaBean任务相关信息——caker_sheet.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class Caker_sheet {
	
	private int cid;			//参考位置第三级id，模块表id——caker_sheet
	private String cakeName;	//模块表的名称
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCakeName() {
		return cakeName;
	}
	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}
}
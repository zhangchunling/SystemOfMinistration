package com.zrgk.project.model;

import com.zrgk.project.util.Page;

/**
 * 
 * @function: 需求信息的javabean
 * @author: 张春玲
 * @time: 2015-6-8
 *
 */

public class Needer extends Page{
	private int pid;				//序号
	private int project_id;			//项目主键
	private String createTime;		//添加时间
	private String updateTime;		//更新时间
	private	String ptitle;  		//标题
	private String simpleStatement;	//简单描述
	private String detail;			//详细描述	
	private String comment;			//备注
	private String addPeople;		//创建人
	private String updatePeople;	//更新人	
	private String proName;			//存项目名称
	private int order;				//存排序条件
	
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getSimpleStatement() {
		return simpleStatement;
	}
	public void setSimpleStatement(String simpleStatement) {
		this.simpleStatement = simpleStatement;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUpdatePeople() {
		return updatePeople;
	}
	public void setUpdatePeople(String updatePeople) {
		this.updatePeople = updatePeople;
	}
	public String getAddPeople() {
		return addPeople;
	}
	public void setAddPeople(String addPeople) {
		this.addPeople = addPeople;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	
	
}

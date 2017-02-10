package com.zrgk.project.model;

import com.zrgk.project.util.Page;

/**
 * 
 * @function: 模块信息的javabean
 * @author: 张春玲
 * @time: 2015-6-8
 *
 */
public class Caker extends Page{
	private int cid;				//序号
	private int need_id;			//需求主键
	private int priority;			//优先级
	private String cakeName;		//模块名称
	private String createTime;		//添加时间
	private String updateTime;		//更新时间
	private String simpleStatement;	//简单描述
	private String detail;			//详细描述	
	private String comment;			//备注
	private String updatePeople;	//创建人
	private String addPeople;		//创建人
	private String proName;			//项目名称
	private String needName;		//需求名称
	private int order;				//排序条件
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getNeed_id() {
		return need_id;
	}
	public void setNeed_id(int need_id) {
		this.need_id = need_id;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getCakeName() {
		return cakeName;
	}
	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
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
	public String getNeedName() {
		return needName;
	}
	public void setNeedName(String needName) {
		this.needName = needName;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
}

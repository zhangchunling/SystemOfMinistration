package com.zrgk.project.model;
import com.zrgk.project.util.Page;

/**
 * 
 * @function: 基本信息的javabean
 * @author: 张春玲
 * @time: 2015-6-4
 *
 */
public class Basicer extends Page{
	//注意：注意下面私有化属性的顺序，这会直接影响到导出Excel时显示数据的顺序
	private int pid;				//序号
	private String projectName;		//项目名称
	private String customerName;	//客户公司名称
	private	String personInCharge;  //客户方责人
	private String manager;			//项目经理
	private int persons;			//开发人数
	private String relstartTime;	//立项时间（项目真正开始时间）
	private String updateTime;		//最新更新时间
	private String completeTime;	//计划完成时间	
	private int state;				//状态
	private int level;				//级别	
	private double cost;			//预计成本 
	private String startTime;		//开始时间
	private String updatePeople;	//修改人
	private String addPeople;		//创建人
	private String addTime;			//创建时间
	private int order;				//排序条件
	private String comment;			//备注
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPersons() {
		return persons;
	}
	public void setPersons(int persons) {
		this.persons = persons;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPersonInCharge() {
		return personInCharge;
	}
	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getRelstartTime() {
		return relstartTime;
	}
	public void setRelstartTime(String relstartTime) {
		this.relstartTime = relstartTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
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
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	

}

package com.zrgk.task.model;

import java.io.Serializable;

import com.zrgk.task.util.Page;

/**
 * @function: JavaBean任务相关信息——Task.java
 * @author: 刘淼
 * @time: 2015-6-4
 * */
public class Task extends Page implements Serializable{
	
	//私有属性
	private int tid;				//id		Id				int		11		0	0	-1	0	0	0		0																				-1	0
	private String referenceSite;	//参考位置		referenceSite	varchar	10		0	-1	0	0	0	0		0	参考位置第一项：XXXX管理系统,XXXX需求分析,XXXX模块,XXXX功能	utf8	utf8_general_ci		0	0
	private String planOption;		//任务标题		planOption		varchar	100		0	-1	0	0	0	0		0	任务标题											utf8	utf8_general_ci		0	0
	private int executor;			//执行者		executor		int		11		0	-1	0	0	0	0		0	执行者与人员名要一致																		0	0
	private int status;				//状态		status			int		11		0	-1	0	0	0	0		0	状态,1:未开始，2:进行中，3:结束														0	0
	private int grade;				//等级		grade			int		11		0	-1	0	0	0	0		0	等级,0:暂缓,1:低,2:中,3:高														-1	0
	private String beginTime;		//开始时间		beginTime		varchar	20		0	-1	0	0	0	0		0	开始时间											utf8	utf8_general_ci		0	0
	private String endTime;			//结束时间		endTime			varchar	20		0	-1	0	0	0	0		0	结束时间											utf8	utf8_general_ci		0	0
	private String detailExplain;	//详细说明		detailExplain	varchar	3000	0	-1	0	0	0	0		0	详细说明											utf8	utf8_general_ci		0	0				

//	Task相关字段的set()与get()方法
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getReferenceSite() {
		return referenceSite;
	}
	public void setReferenceSite(String referenceSite) {
		this.referenceSite = referenceSite;
	}
	public String getPlanOption() {
		return planOption;
	}
	public void setPlanOption(String planOption) {
		this.planOption = planOption;
	}
	public int getExecutor() {
		return executor;
	}
	public void setExecutor(int executor) {
		this.executor = executor;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getDetailExplain() {
		return detailExplain;
	}
	public void setDetailExplain(String detailExplain) {
		this.detailExplain = detailExplain;
	}
}
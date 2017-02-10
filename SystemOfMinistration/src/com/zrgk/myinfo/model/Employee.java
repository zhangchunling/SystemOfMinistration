package com.zrgk.myinfo.model;

import java.io.Serializable;

/**
 * 员工相关信息的javaBean
 * @author samson 
 * 2015-06-03
 */
// 做成流的形式
public class Employee implements Serializable {
	// 给javabean生成一个识别码
	private static final long serialVersionUID = 7503607108286895846L;
	private int eid;// Employee里的主键
	private String position;// Employee里的人员职位
	private int sex;// Employee里的人员性别
	private int age;// Employee里的人员年龄
	private String tel;// Employee里的人员电话
	private String entryTime;// Employee里的人员入职时间
	private String cardNum;// Employee里的人员身份证号码
	private String state;// Employee里的人员状态
	private String remark;// Employee里的备注
	private String password;// Employee里的密码
	private String name;// Employee里的人员名字
	private String username;// Employee里的用户名
	
	
	//生成get()  set()  方法
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

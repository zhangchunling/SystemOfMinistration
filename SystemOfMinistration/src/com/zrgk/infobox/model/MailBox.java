package com.zrgk.infobox.model;

import java.io.Serializable;

/**
 * javabean的 封装类
 * @author 樊丙富
 *2015-06-04
 */
public class MailBox extends Page implements Serializable{
	private  int id;//序号
	private  String title;//标题
	private  String content;//内容
	private  int adressee;//收件人
	private  int adresser;//发件人
	private  String time;//时间
	private  int delete1;//操作
	private  int isread;//是否读取的消息
	private  String slave;//附件
	

	private String userName;//用户名
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//get  set  方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAdressee() {
		return adressee;
	}
	public void setAdressee(int adressee) {
		this.adressee = adressee;
	}
	public int getAdresser() {
		return adresser;
	}
	public void setAdresser(int adresser) {
		this.adresser = adresser;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getDelete1() {
		return delete1;
	}
	public void setDelete1(int delete1) {
		this.delete1 = delete1;
	}
	public int getIsread() {
		return isread;
	}
	public void setIsread(int isread) {
		this.isread = isread;
	}
	public String getSlave() {
		return slave;
	}
	public void setSlave(String slave) {
		this.slave = slave;
	}
	
	
	
}
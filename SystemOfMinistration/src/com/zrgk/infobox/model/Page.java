package com.zrgk.infobox.model;

import java.io.Serializable;

/**
 * 分页的的JavaBean
 * @author 樊丙富
 * 2015-06-9
 */
public class Page implements Serializable{//序列化
	private static final long serialVersionUID = 9003509508733099639L;
	private int currentPage=1;//当前页 要显示的是第几页
	private int pageSize=5;//每页显示多少条 初始显示的是5条
	private int totalSize;//总条数
	private int totalPage;//总页数
	
	
	//获得get  set方法
	public int getTotalPage() {
		//在这里可以直接根据pageSize与totalSize计算总页数
		return totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}

package com.zrgk.task.util;

import java.io.Serializable;

/**
 * 
 * @function: 分页的javabean
 * @author: 刘淼
 * @time: 2015-6-13
 *
 */
public class Page implements Serializable {

	private static final long serialVersionUID = -3826962173085053200L;

	private int currentPage = 1; //当前页 要显示的是第几页，默认第1页

	private int pageSize = 6;	//每页显示多少条 初始显示的是5条

	private int totalSize;		//总的数据条数

	private int totalPage;		//总页数
	
	

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

package com.zrgk.utils;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = -3826962173085053200L;

	private int currentPage = 1;

	private int pageSize = 6;

	private int totalSize;

	private int totalPage;
	
	

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

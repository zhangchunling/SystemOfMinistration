package com.zrgk.project.util;

import java.io.Serializable;

/**
 * 
 * @function: 分页的javabean
 * @author: 张春玲
 * @time: 2015-6-9
 *
 */
public class Page implements Serializable{
	private static final long serialVersionUID = 9003509508733099639L;//序列化，使其有唯一的传输通道，传的数据更安全准确
	private int currentPage=1;	//当前页 要显示的是第几页，默认第1页
	private int pageSize=5;		//每页显示多少条 初始显示的是5条
	private int totalSize;		//总的数据条数
	private int totalPage;		//总页数
	
	
	public int getTotalPage() {
		//在这里可以直接根据pageSize与totalSize计算总页数
		return totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
		//	int num=((int)(totalSize-1))/pageSize+1;	//用分宿舍法：知道总人数，及每间能住多少人，求需要多少间？
		//	return num;
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
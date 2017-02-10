package com.zrgk.task.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zrgk.task.dao.CakerDaoInter;
import com.zrgk.task.model.Caker_sheet;
import com.zrgk.utils.JdbcUtil;

/**
 * @function: 任务管理dao层实现类——CakerDaoImpl.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class CakerDaoImpl extends JdbcUtil implements CakerDaoInter{
	
	public List<Caker_sheet> queryAllCaker(Caker_sheet caker) {		

		List<Caker_sheet> list=new ArrayList<Caker_sheet>();	//新建集合对象存放查回的所有数据
		List<Object> olist=new ArrayList<Object>();	//存问号值
		StringBuffer sql=new StringBuffer("select * from caker_sheet where 1=1 ");//可变sql
		//拼接sql语句		
		 if(caker!=null&&caker.getCakeName()!=null&&!"".equals(caker.getCakeName().trim())){
			 sql.append(" and cakeName like ?");		 //拼接根据项目名来模糊查询的sql
			 olist.add("%"+caker.getCakeName()+"%");//向参数集合放值 
		 }	
		 
		//将查回的所有数据放进结果集
		ResultSet rs=this.queryByPst(olist, sql.toString());
		 if(rs!=null){
				try {
						while(rs.next()){
							Caker_sheet c=new Caker_sheet();
							c.setCid(rs.getInt("cid"));
							c.setCakeName(rs.getString("cakeName"));
						}
				}catch(Exception e){
						e.printStackTrace();
						this.closeAll();
					}
		}
		return list;
	}
}
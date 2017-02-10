package com.zrgk.task.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zrgk.task.dao.NeedDaoInter;
import com.zrgk.task.model.Need_sheet;
import com.zrgk.utils.JdbcUtil;

/**
 * @function: 任务管理dao层实现类——NeedDaoImpl.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class NeedDaoImpl extends JdbcUtil implements NeedDaoInter{
	
	public List<Need_sheet> queryAllNeed(Need_sheet need) {
		
		
		List<Need_sheet> list=new ArrayList<Need_sheet>();	//新建集合对象存放查回的所有数据
		List<Object> olist=new ArrayList<Object>();	//存问号值
		StringBuffer sql=new StringBuffer("select * from need_sheet where 1=1 ");//可变sql
		//拼接sql语句
		 if(need!=null&&need.getPtitle()!=null&&!"".equals(need.getPtitle().trim())){
			 sql.append(" and ptitle like ?");		 //拼接根据项目名来模糊查询的sql
			 olist.add("%"+need.getPtitle()+"%");//向参数集合放值 
		 }	
		 
		//将查回的所有数据放进结果集
		ResultSet rs=this.queryByPst(olist, sql.toString());
		 if(rs!=null){
				try {
						while(rs.next()){
							Need_sheet n=new Need_sheet();
							n.setPid(rs.getInt("pid"));
							n.setPtitle(rs.getString("ptitle"));
						}
				}catch(Exception e){
						e.printStackTrace();
						this.closeAll();
					}
		 	}
		 	return list;
		}
	}
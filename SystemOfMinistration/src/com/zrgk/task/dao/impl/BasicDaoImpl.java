package com.zrgk.task.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zrgk.task.dao.BasicDaoInter;
import com.zrgk.task.model.Basic_Info;
import com.zrgk.utils.JdbcUtil;

/**
 * @function: 任务管理dao层实现类——BasicDaoImpl.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class BasicDaoImpl extends JdbcUtil implements BasicDaoInter{
	
	public List<Basic_Info> queryAllBasic(Basic_Info basic) {

		List<Basic_Info> list=new ArrayList<Basic_Info>();	//新建集合对象存放查回的所有数据
		List<Object> olist=new ArrayList<Object>();			//存问号值
		StringBuffer sql=new StringBuffer("select * from basic_info where 1=1 ");//可变sql
		//拼接sql语句
		 if(basic!=null&&basic.getProjectName()!=null&&!"".equals(basic.getProjectName().trim())){
			 sql.append(" and projectName like ?");		 //拼接根据项目名来模糊查询的sql
			 olist.add("%"+basic.getProjectName()+"%");//向参数集合放值 
		 }		 
		 
		//将查回的所有数据放进结果集
		ResultSet rs=this.queryByPst(olist, sql.toString());
		 if(rs!=null){
				try {
						while(rs.next()){
							Basic_Info b=new Basic_Info();
							b.setPid(rs.getInt("pid"));
							b.setProjectName(rs.getString("customerName"));
						}
				}catch(Exception e){
						e.printStackTrace();
						this.closeAll();
					}
		}
		return list;
	}
}
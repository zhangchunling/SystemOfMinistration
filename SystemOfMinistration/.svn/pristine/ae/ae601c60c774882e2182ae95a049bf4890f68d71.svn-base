package com.zrgk.task.dao.impl;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.zrgk.utils.JdbcUtil;
import com.zrgk.task.dao.FunctionDaoInter;
import com.zrgk.task.model.Function_sheet;

/**
 * @function: 任务管理dao层实现类——FunctionDaoImpl.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class FunctionDaoImpl extends JdbcUtil implements FunctionDaoInter{
	
	public List<Function_sheet> queryAllFunction(Function_sheet function) {		

		List<Function_sheet> list=new ArrayList<Function_sheet>();	//新建集合对象存放查回的所有数据
		List<Object> olist=new ArrayList<Object>();				   //存问号值
		StringBuffer sql=new StringBuffer("select * from function_sheet where 1=1 ");//可变sql
		//拼接sql语句		 
		 if(function!=null&&function.getFunctionName()!=null&&!"".equals(function.getFunctionName().trim())){
			 sql.append(" and functionName like ?");		 //拼接根据项目名来模糊查询的sql
			 olist.add("%"+function.getFunctionName()+"%"); //向参数集合放值 
		 }	
		 
		//将查回的所有数据放进结果集
		ResultSet rs=this.queryByPst(olist, sql.toString());
		 if(rs!=null){
				try {
						while(rs.next()){
							Function_sheet f=new Function_sheet();
							f.setFid(rs.getInt("fid"));
							f.setFunctionName(rs.getString("functionName"));
						}
				}catch(Exception e){
						e.printStackTrace();
						this.closeAll();
					}
		}
		return list;
	}
}
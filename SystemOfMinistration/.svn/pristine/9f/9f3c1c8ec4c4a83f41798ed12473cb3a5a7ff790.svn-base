package com.zrgk.clientinfo.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zrgk.clientinfo.dao.UsersDaoInter;
import com.zrgk.clientinfo.model.Customers;
import com.zrgk.utils.JdbcUtil;


/**
 * 客户信息dao层实现 类
 * @author Simone
 * 2015-06-07
 */
public class UsersDaoImpl extends JdbcUtil implements UsersDaoInter  {

	
	//添加

	public void insertUser(Customers user) {
		String sql="insert into customer (companyName,customerName,companyAddress,customerTel,companyTel,companyIntroduction,remark,addTime) value(?,?,?,?,?,?,?,?)";
		//封闭参数
		List<Object> params=new ArrayList<Object>();
	
		params.add(user.getCompanyName());
		params.add(user.getCustomerName());
		params.add(user.getCompanyAddress());
		params.add(user.getCustomerTel());
		params.add(user.getCompanyTel());
		params.add(user.getCompanyIntroduction());
		params.add(user.getRemark());
		params.add(user.getAddTime());
		
		this.doPst(params, sql);//调用插入数据库的执行方法
	}


	//查询数据库的方法)
	public List<Customers> queryUsers(Customers user) {
		List<Customers> list=new ArrayList<Customers>();
		List<Object> olist=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer(" select cid,customerName,companyName,addTime,customerTel,companyAddress,companyTel," +
				"companyIntroduction,remark from customer where 1=1 ");//定义
		//查询 用户名不能为空   拼接字符串操作
				if (user != null && user.getCompanyName() != null && !"".equals(user.getCompanyName().trim())) {// 拼接companyName值
					sql.append(" and companyName like ?");
					olist.add("%" + user.getCompanyName() + "%");
				}
				if (user != null && user.getCustomerName() != null && !"".equals(user.getCustomerName().trim())) {// 拼接customerName值
					sql.append(" and customerName like ?");
					olist.add("%" + user.getCustomerName() + "%");
				}
		
		
		//排序
		if (user!=null&&user.getAddTime()!=null&&!"".equals(user.getAddTime().trim())&&"1".equals(user.getAddTime())) {
			sql.append(" order by addTime desc ");//拼接根据时间来排序
		}
		
		
		//分页
		int num=0;
		if(user!=null){
			num=(user.getCurrentPage()-1)*user.getPageSize(); 
			sql.append(" limit "+ num +"," +user.getPageSize());
		}
	
		
		 //调用查询数据库的方法
		 ResultSet rs=this.queryByPst(olist,sql.toString());		
		try{
			 if(rs!=null){
				 while(rs.next()){
					 Customers u=new Customers();
					 u.setCid(rs.getInt("cid"));
					 u.setCustomerName(rs.getString("customerName"));
					 u.setCompanyName(rs.getString("companyName"));
					 u.setAddTime(rs.getString("addTime"));
					 u.setCustomerTel(rs.getString("customerTel"));
					 u.setCompanyAddress(rs.getString("companyAddress"));
					 u.setCompanyTel(rs.getString("companyTel"));
					 u.setCompanyIntroduction(rs.getString("companyIntroduction"));
					 u.setRemark(rs.getString("remark"));
					 
					 list.add(u);
				 }
			 }
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }finally{
			 this.closeAll();//关闭连接
		 }
		return list;
	}

	
	//查询数据库总条数的方法
	public int totalSize(Customers user) {
		int i=0;
		List<Customers> list=new ArrayList<Customers>();
		List<Object> olist=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer(" select count(*) from customer where 1=1 ");//定义
		//查询 用户名不能为空   拼接字符串操作
				if (user != null && user.getCompanyName() != null && !"".equals(user.getCompanyName().trim())) {// 拼接companyName值
					sql.append(" and companyName like ?");
					olist.add("%" + user.getCompanyName() + "%");
				}
				if (user != null && user.getCustomerName() != null && !"".equals(user.getCustomerName().trim())) {// 拼接customerName值
					sql.append(" and customerName like ?");
					olist.add("%" + user.getCustomerName() + "%");
				}
		
		 
		//调用查询数据库的方法
		 ResultSet rs=this.queryByPst(olist,sql.toString());		
		try{
			 if(rs!=null){
				 while(rs.next()){
					 i=rs.getInt(1);
					
				 }
			 }
		}catch(Exception ex){
		}finally{
			this.closeAll();//关闭连接
		}
		return i;
	}
	
	public Customers queryUsersByCid(int cid) {
		Customers u=new Customers();
		String sql="select * from customer where cid=?";
		List<Object> param=new ArrayList<Object>();
		param.add(cid);
		 //调用查询数据库的方法
		 ResultSet rs=this.queryByPst(param,sql);		
		try{
			 if(rs!=null){
				 while(rs.next()){
					 u.setCid(rs.getInt("cid"));
					 u.setCustomerName(rs.getString("customerName"));
					 u.setCompanyName(rs.getString("companyName"));
					 u.setAddTime(rs.getString("addTime"));
					 u.setCustomerTel(rs.getString("customerTel"));
					 u.setCompanyAddress(rs.getString("companyAddress"));
					 u.setCompanyTel(rs.getString("companyTel"));
					 u.setCompanyIntroduction(rs.getString("companyIntroduction"));
					 u.setRemark(rs.getString("remark"));
					 
				 }
			 }
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }finally{
			 this.closeAll();//关闭连接
		 }
		return u;
	}

	
	//编辑

	public void updateUser(Customers user) {
		String sql="update customer set companyName=?,customerName=?,companyAddress=?,customerTel=?,companyTel=?,companyIntroduction=?,remark=? where cid=?";
		List<Object> param=new ArrayList<Object>();
		param.add(user.getCompanyName());
		param.add(user.getCustomerName());
		param.add(user.getCompanyAddress());
		param.add(user.getCustomerTel());
		param.add(user.getCompanyTel());
		param.add(user.getCompanyIntroduction());
		param.add(user.getRemark());
		param.add(user.getCid());
		this.doPst(param, sql);

	}


 	//根据主键的删除方法
	public void deleteUser(int cid) {
		String sql="delete from customer where cid=?";
		List<Object> olist=new ArrayList<Object>();//组装参数的集合
		olist.add(cid);
		this.doPst(olist,sql);// 调用删除数据库的方法
	}


	

	
	//查询
	public List<Customers> queryCustomers(Customers cus) {
		List<Customers> list=new ArrayList<Customers>();
		
		String sql="select * from customer";
		
		 ResultSet rs=this.queryByPst(null,sql.toString());		
			try{
				 if(rs!=null){
					 while(rs.next()){
						 Customers u=new Customers();
						 u.setCid(rs.getInt("cid"));
						 u.setCustomerName(rs.getString("customerName"));
						 u.setCompanyName(rs.getString("companyName"));
						 u.setCustomerTel(rs.getString("customerTel"));
						 u.setCompanyAddress(rs.getString("companyAddress"));
						 u.setCompanyTel(rs.getString("companyTel"));
						 u.setCompanyIntroduction(rs.getString("companyIntroduction"));
						 u.setRemark(rs.getString("remark"));
						 u.setAddTime(rs.getString("addTime"));
						 list.add(u);
					 }
				 }
			 }catch(Exception ex){
				 ex.printStackTrace();
			 }finally{
				 this.closeAll();//关闭连接
			 }
		
		return list;
	}


	

}

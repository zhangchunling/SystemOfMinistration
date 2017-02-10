package com.zrgk.myinfo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.zrgk.myinfo.dao.LoginDaoInter;
import com.zrgk.myinfo.model.Employee;
import com.zrgk.purview.model.Menu;
import com.zrgk.utils.JdbcUtil;
/**
 * 
 * @function: dao层增删改查的实现
 * @author: samson
 * @time: 2015-6-12
 *
 */
public class LoginDaoImpl extends JdbcUtil implements LoginDaoInter {

	public void options(String sql) {
		this.doPst(null, sql);		
	}
	

	public ResultSet query(String sql) {
		ResultSet rs=this.queryByPst(null, sql);
		this.closeAll();
		return rs;
	}


	public Employee login(Employee employee) {
		Employee emp=null;
		String sql="select * from employee where username=? and password=?";
		List<Object> params=new ArrayList<Object>();
		params.add(employee.getUsername());
		params.add(employee.getPassword());
		//调用查询数据库的方法
		ResultSet rs=this.queryByPst(params, sql);
		
		try {
			if(rs!=null){
					while(rs.next()){
						emp=new Employee();
						emp.setEid(rs.getInt("eid"));
						emp.setName(rs.getString("name"));
						emp.setPosition(rs.getString("position"));
						emp.setSex(rs.getInt("sex"));
						emp.setAge(rs.getInt("age"));
						emp.setTel(rs.getString("tel"));
						emp.setEntryTime(rs.getString("entryTime"));
						emp.setCardNum(rs.getString("cardNum"));
						emp.setState(rs.getString("state"));
						emp.setRemark(rs.getString("remark"));
						emp.setUsername(rs.getString("username"));
						emp.setPassword(rs.getString("password"));
					}
			}
		} catch (SQLException e) {			
					e.printStackTrace();
				 }finally{
					this.closeAll(); 
				 }
		return emp;
	}


	public List<Menu> listMenuByEid(int eid) {
		 List<Menu> list=new ArrayList<Menu>();
				 
		String sql="select m.* from menu m ,eid_rid er,role_menu rm where m.mid=rm.m_id and rm.r_id=er.r_id and er.e_id="+eid;
		System.out.println(sql);
		//调用查询数据库的方法
		ResultSet rs=this.queryByPst(null, sql);
		
		try {
			if(rs!=null){
					while(rs.next()){
						Menu m=new Menu();
						m.setMid(rs.getInt("mid"));
						m.setMenuName(rs.getString("menuName"));
						m.setMenuPath(rs.getString("menuPath"));
						m.setParentId(rs.getInt("parentId"));
						list.add(m);
					}
			}
		} catch (SQLException e) {			
					e.printStackTrace();
				 }finally{
					this.closeAll(); 
				 }
		return list;
	}

	

}

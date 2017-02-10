package com.zrgk.myinfo.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zrgk.myinfo.dao.ProDaoInter;
import com.zrgk.myinfo.model.Employee;
import com.zrgk.utils.JdbcUtil;
/**
 * 
 * @function: dao层增删改查的实现
 * @author: samson
 * @time: 2015-6-12
 *
 */
public class ProDaoImpl extends JdbcUtil implements ProDaoInter {

	public void options(String sql) {
		this.doPst(null, sql);		
	}
	

	public ResultSet query(String sql) {
		ResultSet rs=this.queryByPst(null, sql);
		this.closeAll();
		return rs;
	}

	//查询人员信息
	public List<Employee> queryEmployees(Employee employee) {
		//声明一个list用来装数据库里查询出来的数据
		List<Employee> list=new ArrayList<Employee>();
		List<Object> olist=new ArrayList<Object>();//组装参数的集合
		StringBuffer sql=new StringBuffer("select eid,name,position,sex,age,tel,entryTime,cardNum,state,remark from employee where 1=1");
		if(employee!=null&&employee.getUsername()!=null&&!"".equals(employee.getUsername().trim())){
			//根据用户名来模糊查询的SQL
			sql.append(" and username like ?");
			olist.add("%"+employee.getUsername()+"%");//项参数集合里放值
		}
		//调用查询数据库的方法
		ResultSet rs=this.queryByPst(olist,sql.toString());
		try {
			if(rs!=null){
			while (rs.next()) {
				Employee emp=new Employee();
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
				list.add(emp);
			}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			this.closeAll();//关闭链接
		}
		return list;
	}

}

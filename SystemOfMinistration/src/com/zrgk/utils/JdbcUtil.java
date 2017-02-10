package com.zrgk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
/**
 * 
 * @function: 封装增删改查
 * @author: 张春玲
 * @time: 2015-6-3
 *
 */
public class JdbcUtil {
	private static String DRIVER_CLASS;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	//静态块，初始化连接
	static{
		try {
			ResourceBundle rb = ResourceBundle.getBundle("com.zrgk.config.dbConfig");
				DRIVER_CLASS=rb.getString("className");
				URL=rb.getString("url");
				USERNAME=rb.getString("userName");
				PASSWORD=rb.getString("passWord");
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//建立全局变量
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	//建立连接方法
	public Connection getConnection(){
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//封闭增删改，绑定问号
	public boolean doPst(List<Object> list,String sql){		
		conn=this.getConnection();
		boolean flag=true;
		
		try {			
			ps=conn.prepareStatement(sql);			
			if(list!=null){
				for (int i = 0; i <list.size() ; i++) {
					ps.setObject(i+1,list.get(i));
				}	
				
			}	
			
			ps.execute();
			
		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;//表示是否执行成功
	}
	
	//封闭查询
	public ResultSet queryByPst(List<Object> params,String sql){
		
		this.doPst(params,sql);//调用绑定问号的方法
		
		try {
			rs=ps.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//封装关闭资源
	public void closeAll(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

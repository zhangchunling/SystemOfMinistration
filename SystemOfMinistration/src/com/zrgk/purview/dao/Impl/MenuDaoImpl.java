package com.zrgk.purview.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrgk.purview.dao.MenuDaoInter;
import com.zrgk.purview.model.Menu;
import com.zrgk.utils.JdbcUtil;

/**
 * 
 * employee实现接口的类;
 * 
 * @author wfh;
 * 
 *         2015-06-04;
 */

public class MenuDaoImpl extends JdbcUtil implements MenuDaoInter {

	public List<Menu> QueryAll(Menu menu) {

		List<Menu> list = new ArrayList<Menu>();

		List<Object> olist = new ArrayList<Object>();

		StringBuffer sql = new StringBuffer(
				"select  m.mid,m.menuNum,m.menuName,(select m1.menuName from menu m1 where m1.mid=m.parentId ) parentId,m.menuPath,m.remark,m.state  from menu m where 1=1 ");

		if (menu != null && menu.getMenuName() != null
				&& !"".equals(menu.getMenuName().trim())) {
			sql.append(" and menuName like ? ");
			olist.add("%" + menu.getMenuName() + "%");
		}

		int num = 1;

		num = (menu.getCurrentPage() - 1) * menu.getPageSize();

		sql.append(" limit " + num + "," + menu.getPageSize());
		ResultSet rs = this.queryByPst(olist, sql.toString());

		try {
			if (rs != null) {
				while (rs.next()) {

					Menu e = new Menu();

					e.setMid(rs.getInt("mid"));
					e.setMenuNum(rs.getString("menuNum"));
					e.setMenuName(rs.getString("menuName"));
					if(rs.getString("parentId")==null||"".equals(rs.getString("parentId"))){
						e.setParentName("顶级菜单");
					}else{
						e.setParentName(rs.getString("parentId"));
					}
					e.setMenuPath(rs.getString("menuPath"));
					e.setRemark(rs.getString("remark"));
					e.setState(rs.getInt("state"));

					list.add(e);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			this.closeAll();
		}

		return list;
	}

	public void CancelUpdateMenu(Menu menu) {

		String sql = "update menu set state=2 where mid = ? ";

		List<Object> params = new ArrayList<Object>();

		params.add(menu.getMid());

		this.doPst(params, sql);

		this.closeAll();

	}

	public void deleteMenu(Menu menu) {

		String sql = " delete from menu where mid = ?";

		List<Object> params = new ArrayList<Object>();

		params.add(menu.getMid());

		this.doPst(params, sql);

		this.closeAll();
	}

	public void insertMenu(Menu menu) {

		String sql = "insert into menu value(null,?,?,?,?,?,?)";

		List<Object> params = new ArrayList<Object>();

		params.add(menu.getMenuNum());
		params.add(menu.getMenuName());
		params.add(menu.getParentId());
		params.add(menu.getMenuPath());
		params.add(menu.getRemark());
		params.add(menu.getState());

		this.doPst(params, sql);

		this.closeAll();
	}

	public List<Menu> QueryByMid(Menu menu) {

		List<Menu> list=new ArrayList<Menu>();
		
		String sql = "select * from menu where mid=?";

		List<Object> params = new ArrayList<Object>();

		params.add(menu.getMid());
		ResultSet rs = this.queryByPst(params, sql);

		Menu m = new Menu();

		try {

			if (rs != null) {

				while (rs.next()) {

					m.setMid(rs.getInt("mid"));
					m.setMenuNum(rs.getString("menuNum"));
					m.setMenuName(rs.getString("menuName"));
					m.setParentId(rs.getInt("parentId"));
					m.setMenuPath(rs.getString("menuPath"));
					m.setRemark(rs.getString("remark"));
					m.setState(rs.getInt("state"));

					list.add(m);
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {

			this.closeAll();
		}
		return list;

	}

	public void UpdateMenu(Menu menu) {
		String sql = "update  menu  set menuNum=?, menuName=?, parentId=?, menuPath=?, remark=?  where mid=? ";

		List<Object> params = new ArrayList<Object>();

		params.add(menu.getMenuNum());
		params.add(menu.getMenuName());
		params.add(menu.getParentId());
		params.add(menu.getMenuPath());
		params.add(menu.getRemark());
		params.add(menu.getMid());

		this.doPst(params, sql);
		this.closeAll();

	}

	public int totalSize(Menu menu) {
		int i = 0;

		List<Object> olist = new ArrayList<Object>();

		StringBuffer sql = new StringBuffer(
				"select count(*) from menu where 1=1 ");

		if (menu != null && menu.getMenuName() != null
				&& !"".equals(menu.getMenuName().trim())) {
			sql.append(" and menuName like ? ");
			olist.add("%" + menu.getMenuName() + "%");
		}

		ResultSet rs = this.queryByPst(olist, sql.toString());

		try {
			if (rs != null) {
				while (rs.next()) {

					i = rs.getInt(1);
				 
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			this.closeAll();
		}

		return i;

	}

	public List<Menu> addQueryAll(Menu menu) {
		String sql="select m.mid,m.menuNum,m.menuName,(select m1.menuName from menu m1 where m1.mid=m.parentId ) parentName,m.parentId,m.menuPath,m.remark,m.state from menu m  ";
		List<Menu> list = new ArrayList<Menu>();
		
		ResultSet rs=this.queryByPst(null, sql);
		
		try {
			if (rs != null) {

				while (rs.next()) {

					Menu m = new Menu();
					m.setMid(rs.getInt("mid"));
					m.setMenuNum(rs.getString("menuNum"));
					m.setMenuName(rs.getString("menuName"));
					
					if(rs.getString("parentName")==null||"".equals(rs.getString("parentName"))){
						m.setParentName("顶级菜单");
					}else{
						m.setParentName(rs.getString("parentName"));
					}
					m.setParentId(rs.getInt("parentId"));
					m.setMenuPath(rs.getString("menuPath"));
					m.setRemark(rs.getString("remark"));
					m.setState(rs.getInt("state"));

					
					list.add(m);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			this.closeAll();
		}

		  
		return list;
	}

}

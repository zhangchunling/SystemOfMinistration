package com.zrgk.purview.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrgk.purview.dao.RoleDaoInter;
import com.zrgk.purview.model.Menu;
import com.zrgk.purview.model.RidAndMid;
import com.zrgk.purview.model.Role;
import com.zrgk.utils.JdbcUtil;

/**
 * 
 * employee实现接口的类;
 * 
 * @author wfh;
 * 
 *         2015-06-04;
 */

public class RoleDaoImpl extends JdbcUtil implements RoleDaoInter {

	public List<Role> QueryAll(Role role) {

		List<Role> list = new ArrayList<Role>();

		List<Object> olist = new ArrayList<Object>();

		StringBuffer sql = new StringBuffer(
				"select rid, roleNum, roleName, state, menus, remark  from role where 1=1 ");

		if (role != null && role.getRoleName() != null
				&& !"".equals(role.getRoleName().trim())) {
			sql.append(" and roleName like ? ");
			olist.add("%" + role.getRoleName() + "%");
		}

		int num = 1;

		num = (role.getCurrentPage() - 1) * role.getPageSize();

		sql.append(" limit " + num + "," + role.getPageSize());
		ResultSet rs = this.queryByPst(olist, sql.toString());

		try {
			if (rs != null) {
				while (rs.next()) {

					Role e = new Role();

					e.setRid(rs.getInt("rid"));
					e.setRoleNum(rs.getString("roleNum"));
					e.setRoleName(rs.getString("roleName"));
					e.setState(rs.getInt("state"));
					e.setMenus(rs.getString("menus"));
					e.setRemark(rs.getString("remark"));
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

	public void deleteRole(Role role) {

		String sql = " delete from role where rid = ?";

		List<Object> params = new ArrayList<Object>();

		params.add(role.getRid());

		this.doPst(params, sql);

		this.closeAll();

	}

	public int QueryByMenus(Role role) {
		int rid = 0;

		StringBuffer sql = new StringBuffer(
				"select rid from role where Menus=?");

		List<Object> params = new ArrayList<Object>();

		params.add(role.getMenus());
		ResultSet rs = this.queryByPst(params, sql.toString());

		try {

			if (rs != null) {

				while (rs.next()) {

					rid = rs.getInt("rid");

				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {

			this.closeAll();
		}
		return rid;

	}

	public Role QueryByRid(Role role) {
		StringBuffer sql = new StringBuffer("select * from role where rid=?");

		List<Object> params = new ArrayList<Object>();

		params.add(role.getRid());
		ResultSet rs = this.queryByPst(params, sql.toString());
		Role role1 = new Role();
		try {

			if (rs != null) {

				while (rs.next()) {

					role1.setRid(rs.getInt("rid"));
					role1.setRoleNum(rs.getString("roleNum"));
					role1.setRoleName(rs.getString("roleName"));
					role1.setState(rs.getInt("state"));
					role1.setMenus(rs.getString("menus"));
					role1.setRemark(rs.getString("remark"));

				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {

			this.closeAll();
		}
		return role1;

	}

	public void insertRole(Role role) {

		String sql = "insert into role value(null,?,?,?,?,?)";

		List<Object> params = new ArrayList<Object>();

		params.add(role.getRoleNum());
		params.add(role.getRoleName());
		params.add(role.getState());
		params.add(role.getMenus());
		params.add(role.getRemark());

		this.doPst(params, sql);
		this.closeAll();

	}

	public void CancelUpdateRole(Role role) {

		String sql = "update role set state=2 where rid = ? ";

		List<Object> params = new ArrayList<Object>();

		params.add(role.getRid());

		this.doPst(params, sql);

		this.closeAll();

	}

	public void UpdateRole(Role role) {
		StringBuffer sql = new StringBuffer(
				"update  role  set roleNum=?, roleName=?, state=?, menus=?, remark=?  where rid=? ");

		List<Object> params = new ArrayList<Object>();

		params.add(role.getRoleNum());
		params.add(role.getRoleName());
		params.add(role.getState());
		params.add(role.getMenus());
		params.add(role.getRemark());
		params.add(role.getRid());

		this.doPst(params, sql.toString());

		this.closeAll();

	}

	public int totalSize(Role role) {
		int i = 0;

		List<Object> olist = new ArrayList<Object>();

		StringBuffer sql = new StringBuffer(
				"select count(*) from role where 1=1 ");

		if (role != null && role.getRoleName() != null
				&& !"".equals(role.getRoleName().trim())) {
			sql.append(" and roleName like ? ");
			olist.add("%" + role.getRoleName() + "%");
		}

		ResultSet rs = this.queryByPst(olist, sql.toString());

		try {
			if (rs != null) {
				while (rs.next()) {
					i = rs.getInt(1);
					System.out.println(rs.getInt(1));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			this.closeAll();
		}

		return i;
	}

	public void addRidAndMid(RidAndMid rm) {

		String sql = "insert into  role_menu (r_id, m_id) value(?,?) ";

		List<Object> params = new ArrayList<Object>();

		params.add(rm.getR_id());

		params.add(rm.getM_id());

		this.doPst(params, sql);

		this.closeAll();
	}

	public void deleteByRidAndMid(RidAndMid rm) {

		String sql = "delete from role_menu where r_id="+rm.getR_id();

		List<Object> params = new ArrayList<Object>();


		this.doPst(null, sql);

		this.closeAll();

	}

	public List<Role> QueryAllEmployee(Role role) {
		List<Role> list = new ArrayList<Role>();

	 

		String sql="select *  from role ";
				 

	 
		ResultSet rs = this.queryByPst(null, sql );

		try {
			if (rs != null) {
				while (rs.next()) {

					Role e = new Role();

					e.setRid(rs.getInt("rid"));
					e.setRoleNum(rs.getString("roleNum"));
					e.setRoleName(rs.getString("roleName"));
					e.setState(rs.getInt("state"));
					e.setMenus(rs.getString("menus"));
					e.setRemark(rs.getString("remark"));
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

}

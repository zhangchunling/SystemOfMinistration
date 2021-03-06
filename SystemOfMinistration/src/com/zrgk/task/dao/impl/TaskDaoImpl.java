package com.zrgk.task.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrgk.task.dao.TaskDaoInter;
import com.zrgk.task.model.Employee;
import com.zrgk.task.model.Task;
import com.zrgk.utils.JdbcUtil;

/**
 * @function: 任务管理dao层实现类——TaskDaoImpl.java
 * @author: 刘淼
 * @time: 2015-6-4
 * */
public class TaskDaoImpl extends JdbcUtil implements TaskDaoInter {

	// 添加任务
	public void insertTask(Task task) {

		// 封闭参数
	 
		// 建立预编译SQL语句对象，使用映射语句对应各个字段
		String sql = "insert into tab_task(referenceSite,planOption,executor,status,beginTime,endTime,grade,detailExplain) value(?,?,?,?,?,?,?,?)";

		List<Object> par = new ArrayList<Object>();
		par.add(task.getReferenceSite()); // 参考位置
		par.add(task.getPlanOption()); // 任务标题
		par.add(task.getExecutor()); // 执行者
		par.add(task.getStatus()); // 状态
		par.add(task.getBeginTime()); // 开始时间
		par.add(task.getExecutor()); // 结束时间
		par.add(task.getGrade()); // 等级
		par.add(task.getDetailExplain());// 详细说明

		// 调用插入数据库的执行方法doPst(List<Object>params,String sql)
		this.doPst(par, sql);
		this.closeAll();

	}

	// 查询所有任务
	public List<Task> queryAllTasks(Task task) {

		// 遍历任务对象List
		List<Task> list = new ArrayList<Task>();
		// 组装参数的集合
		List<Object> olist = new ArrayList<Object>();

		// 字符流读取sql语句
		StringBuffer sql = new StringBuffer("select * from tab_task where 1=1");
		// 判断任务标题

		// 判断任务标题
		if (task != null && task.getPlanOption() != null
				&& "".equals(task.getPlanOption().trim())) {
			sql.append(" and planOption like ?"); // 拼接根据项目名来模糊查询的sql
			olist.add("%" + task.getPlanOption() + "%");// 向参数集合放值
		}
		// 判断执行者
		if (task != null && task.getExecutor() != 0) {
			sql.append(" or executor like ?"); // 拼接根据项目名来模糊查询的sql
			olist.add("%" + task.getExecutor() + "%"); // 向参数集合放值
		}
		// 状态的条件查询
		if (task != null && task.getStatus() != 0) {
			sql.append(" or status like ?"); // 拼接根据项目名来模糊查询的sql
			olist.add("%" + task.getStatus() + "%"); // 向参数集合放值
		}
		// 拼接sql---排序
		if (task != null && task.getBeginTime() != null) {

			if (task.getBeginTime().equals("1")) {
				sql.append(" order by beginTime desc ");// 拼接根据开始时间排序的sql(默认升序，可降序排)
			}

			if (task.getBeginTime().equals("2")) {
				sql.append(" order by endTime desc ");// 拼接根据开始时间排序的sql(默认升序，可降序排)
			}
		}

		System.out.println(sql.toString());

		// 判断任务标题
		// 拼接sql---分页查询
		if (task != null) {
			int number = 1; // 从第几条数据开始，默认是0
			number = (task.getCurrentPage() - 1) * task.getPageSize();// 页数在变化时，求出从第几条开始取
			sql.append(" limit " + number + "," + task.getPageSize());// 拼接有取数据sql语句（如：limit
																		// 0,5）
		}
		// 调用查询数据库的方法
		ResultSet rs = this.queryByPst(olist, sql.toString());
		try {
			if (rs != null) {
				while (rs.next()) {
					Task t = new Task();
					// 调用组装JavaBean值的方法——javaBeanTask(Task task)
					t.setTid(rs.getInt("tid")); // id
					t.setReferenceSite(rs.getString("referenceSite")); // 参考位置
					t.setPlanOption(rs.getString("planOption")); // 任务标题
					t.setExecutor(rs.getInt("executor")); // 执行者
					t.setStatus(rs.getInt("status")); // 状态
					t.setGrade(rs.getInt("grade")); // 等级
					t.setBeginTime(rs.getString("beginTime")); // 开始时间
					t.setEndTime(rs.getString("endTime")); // 结束时间
					t.setDetailExplain(rs.getString("detailExplain"));
					list.add(t); // 将任务中的获取的字段,添加到list中
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();// 关闭所有连接
		}
		return list; // 返回list数组
	}

	// 查询初参考位置的任务信息
	public List<Task> queryTasks(Task task) {

		// 遍历任务对象List
		List<Task> list = new ArrayList<Task>();
		// 组装参数的集合
		List<Object> olist = new ArrayList<Object>();

		// 字符流读取sql语句
		StringBuffer sql = new StringBuffer(
				"select tid,planOption,executor,status,beginTime,endTime,grade,detailExplain from tab_task where 1=1");
		// 判断任务标题
		if (task != null && task.getPlanOption() != null
				&& "".equals(task.getPlanOption().trim())) {
			sql.append(" and planOption like ?"); // 拼接根据项目名来模糊查询的sql
			olist.add("%" + task.getPlanOption() + "%");// 向参数集合放值
		}
		// 判断执行者
		if (task != null && task.getExecutor() != 0) {
			sql.append(" or executor like ?"); // 拼接根据项目名来模糊查询的sql
			olist.add("%" + task.getExecutor() + "%"); // 向参数集合放值
		}
		// 状态的条件查询
		if (task != null && task.getStatus() != 0) {
			sql.append(" or status like ?"); // 拼接根据项目名来模糊查询的sql
			olist.add("%" + task.getStatus() + "%"); // 向参数集合放值
		}
		// 拼接sql---排序
		if (task != null && task.getBeginTime() != null) {

			if (task.getBeginTime().equals("1")) {
				sql.append(" order by beginTime desc ");// 拼接根据开始时间排序的sql(默认升序，可降序排)
			}

			if (task.getBeginTime().equals("2")) {
				sql.append(" order by endTime desc ");// 拼接根据开始时间排序的sql(默认升序，可降序排)
			}
		}

		System.out.println(sql.toString());

		// 判断任务标题
		// 拼接sql---分页查询
		if (task != null) {
			int number = 1; // 从第几条数据开始，默认是0
			number = (task.getCurrentPage() - 1) * task.getPageSize();// 页数在变化时，求出从第几条开始取
			sql.append(" limit " + number + "," + task.getPageSize());// 拼接有取数据sql语句（如：limit
																		// 0,5）
		}

		// 调用查询数据库的方法
		ResultSet rs = this.queryByPst(olist, sql.toString());
		try {
			if (rs != null) {
				while (rs.next()) {
					Task t = new Task();
					// 调用组装JavaBean值的方法——javaBeanTask(Task task)
					t.setTid(rs.getInt("tid")); // id
					t.setPlanOption(rs.getString("planOption")); // 任务标题
					t.setExecutor(rs.getInt("executor")); // 执行者
					t.setStatus(rs.getInt("status")); // 状态
					t.setBeginTime(rs.getString("beginTime")); // 开始时间
					t.setEndTime(rs.getString("endTime")); // 结束时间
					t.setGrade(rs.getInt("grade")); // 等级
					t.setDetailExplain(rs.getString("detailExplain"));
					list.add(t); // 将任务中的获取的字段,添加到list中
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();// 关闭所有连接
		}
		return list; // 返回list数组
	}

	// 更新任务信息
	public void updateTask(Task task) {

		// 遍历数组对象
		List<Object> param = new ArrayList<Object>();
		// sql语句
		String sql = "update tab_task set referenceSite=?,planOption=?,executor=?,status=?,grade=?,beginTime=?,endTime=?,detailExplain=? where tid=?";

		// 绑定问号值，并赋值，调用TaskDaoImpl中的JavaBeanVoidTask()方法
		param.add(task.getReferenceSite()); // 参考位置
		param.add(task.getPlanOption()); // 任务标题
		param.add(task.getExecutor()); // 执行者
		param.add(task.getStatus()); // 状态
		param.add(task.getGrade()); // 等级
		param.add(task.getBeginTime()); // 开始时间
		param.add(task.getEndTime()); // 结束时间
		param.add(task.getDetailExplain());// 详细说明
		param.add(task.getTid());
		
		
		// 调用插入数据库的执行方法doPst(List<Object>params,String sql)
		this.doPst(param, sql);
		
		this.closeAll();
	}

	// 按id查询任务信息
	public List<Task> queryByIdTask(int tid) {

		List<Task> list = new ArrayList<Task>();
		// 字符缓冲
		StringBuffer sql = new StringBuffer(
				"select * from tab_task where tid=?");
		// 遍历数组对象
		List<Object> params = new ArrayList<Object>();
		// 获取id
		params.add(tid);
		ResultSet rs = this.queryByPst(params, sql.toString());

		try {
			if (rs != null) {
				while (rs.next()) {
					Task t = new Task();

					t.setTid(rs.getInt("tid")); // id
					t.setReferenceSite(rs.getString("referenceSite")); // 参考位置
					t.setPlanOption(rs.getString("planOption")); // 任务标题
					t.setExecutor(rs.getInt("executor")); // 执行者
					t.setStatus(rs.getInt("status")); // 状态
					t.setBeginTime(rs.getString("beginTime")); // 开始时间
					t.setEndTime(rs.getString("endTime")); // 结束时间
					t.setGrade(rs.getInt("grade")); // 等级
					t.setDetailExplain(rs.getString("detailExplain"));// 详细说明

					list.add(t); // 将任务中的获取的字段,添加到list中
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.closeAll();// 关闭所有连接
		}

		return list;
	}

	public Task queryExecutorTask(int executor) {

		Task task = new Task();
		// 遍历数组对象
		List<Object> params = new ArrayList<Object>();
		// 组装参数的集合
		List<Object> olist = new ArrayList<Object>();
		// 字符流读取sql语句
		StringBuffer sql = new StringBuffer(
				"select tid,referenceSite,planOption,executor,status,beginTime,endTime,grade,detailExplain from tab_task where executor=?");

		// 判断执行者
		if (task != null && task.getExecutor() != 0) {
			sql.append(" and executor like ?"); // 拼接根据项目名来模糊查询的sql
			olist.add("%" + task.getExecutor() + "%"); // 向参数集合放值
		}
		return task;
	}

	// 查询——按查询任务标题查询
	public Task queryplanOptionTask(String planOption) {

		Task task = new Task();
		// 组装参数的集合
		List<Object> olist = new ArrayList<Object>();
		// 字符流读取sql语句
		StringBuffer sql = new StringBuffer(
				"select tid,referenceSite,planOption,executor,status,beginTime,endTime,grade,detailExplain from tab_task where planOption=?");

		// 判断任务标题是否为空
		if (task != null && task.getPlanOption() != null
				&& "".equals(task.getPlanOption().trim())) {
			// 追加对任务标题字段的模糊查询
			sql.append(" and planOption like ?");
			// 添加到参数集合中，并获取Task中的任务标题字段信息
			olist.add("%" + task.getPlanOption() + "%");
		}
		System.out.println(sql.toString());
		return task;
	}

	// 删除任务——按id删除任务
	public void deleteTask(int tid) {
		// sql语句
		String sql = "delete from tab_Task where tid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(tid);
		this.doPst(params, sql);
	}

	// 组装JavaBean的值
	public void javaBeanTask(Task task) {
		// 遍历任务对象List
		List<Task> list = new ArrayList<Task>();
		// 组装参数的集合
		List<Object> olist = new ArrayList<Object>();
		// 字符流读取sql语句
		StringBuffer sql = new StringBuffer(
				"select id,referenceSite,planOption,executor,status,beginTime,endTime,grade,detailExplain from tab_task where 1=1");
		ResultSet rs = this.queryByPst(olist, sql.toString());
		Task t = new Task();
		try {
			t.setTid(rs.getInt("tid")); // id
			t.setReferenceSite(rs.getString("referenceSinte")); // 参考位置
			t.setPlanOption(rs.getString("planOption")); // 任务标题
			t.setExecutor(rs.getInt("executor")); // 执行者
			t.setStatus(rs.getInt("status")); // 状态
			t.setBeginTime(rs.getString("beginTime")); // 开始时间
			t.setEndTime(rs.getString("endTime")); // 结束时间
			t.setGrade(rs.getInt("grade")); // 等级
			t.setDetailExplain(rs.getString("detailExplain"));// 详细说明
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// JavaBeanVoidTask()
	public void javaBeanVoidTask() {
		Task task = new Task();
		List<Object> param = new ArrayList<Object>();
		param.add(task.getReferenceSite()); // 参考位置
		param.add(task.getPlanOption()); // 任务标题
		param.add(task.getExecutor()); // 执行者
		param.add(task.getStatus()); // 状态
		param.add(task.getBeginTime()); // 开始时间
		param.add(task.getEndTime()); // 结束时间
		param.add(task.getGrade()); // 等级
		param.add(task.getDetailExplain()); // 详细说明
	}

	// javaBean()
	public void javaBean() {
		Task task = new Task();
		// 遍历对象params，并将获取的字段添加入次数组中
		List<Object> params = new ArrayList<Object>();
		params.add(task.getReferenceSite()); // 参考位置
		params.add(task.getPlanOption()); // 任务标题
		params.add(task.getExecutor()); // 执行者
		params.add(task.getStatus()); // 状态
		params.add(task.getBeginTime()); // 开始时间
		params.add(task.getExecutor()); // 结束时间
		params.add(task.getGrade()); // 等级
		params.add(task.getDetailExplain());// 详细说明
	}

	// 查询总的数据条数
	public int totalSize(Task task) {

		int i = 0;
		List<Object> olist = new ArrayList<Object>(); // 组装参数的集合

		// 注：下面的sql语句是用于查有多少条数据，查询的结果就一行一列：总条数值
		StringBuffer sql = new StringBuffer(
				"select count(*) from tab_task where 1=1");// 查询数据条数的sql语句,count计算出有多少条

		ResultSet rs = this.queryByPst(olist, sql.toString());// sql语句是用聚合函数count计算出有多少列，返回的是count计算出的值的列表（只一行一列）
		try {
			if (rs != null) {
				while (rs.next()) {
					i = rs.getInt(1); // 取出rs的第一列（也只有一列）的总条数值
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return i;// 返回数据总条数
	}

	public void updateStartTask(Task task) {

		String sql = "update tab_task set status=2 where tid = "
				+ task.getTid();

		this.doPst(null, sql);

		this.closeAll();

	}

	public void updateEndTask(Task task) {
		String sql = "update tab_task set status=3 where tid = "
				+ task.getTid();

		this.doPst(null, sql);

		this.closeAll();
	}

	public void deleteTask(Task task) {
		String sql = "delete  from  tab_task  where tid = " + task.getTid();

		this.doPst(null, sql);

		this.closeAll();
	}

	public List<Employee> queryAllEmployee() {

		String sql = "select  * from employee";

		ResultSet rs = this.queryByPst(null, sql);
		List<Employee> list = new ArrayList<Employee>();

		if (rs != null) {

			try {
				while (rs.next()) {

					Employee em = new Employee();

					em.setName(rs.getString("name"));
					em.setEid(rs.getInt("eid"));
					list.add(em);

				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {

				this.closeAll();

			}

		}

		return list;
	}
}
package com.zrgk.task.dao;
import java.util.List;

import com.zrgk.task.model.Employee;
import com.zrgk.task.model.Task;
/**
 * @function: 任务管理dao层的接口类——TaskDaoInter.java
 * @author: 刘淼
 * @time: 2015-6-4
 * */
public interface TaskDaoInter {
	
		void insertTask(Task task);						       //新增任务的方法
		List<Task> queryAllTasks(Task task);		   		  //查询所以任务信息
		List<Task> queryTasks(Task task);		   		  	 //查询除参考位置的任务信息
		List<Task> queryByIdTask(int tid);				 		//按id查询任务信息
		Task queryExecutorTask(int executor);		       //查询执行者
		Task queryplanOptionTask(String planOption); 	  //查询任务标题
		void deleteTask(int tid);						 //删除任务的方法
		void updateTask(Task task);						//修改任务信息
		int totalSize(Task task);					   //总条数
		void updateStartTask(Task task);
		void updateEndTask(Task task);
		void deleteTask(Task task);
		
		List<Employee> queryAllEmployee();
		
		
		
		
}
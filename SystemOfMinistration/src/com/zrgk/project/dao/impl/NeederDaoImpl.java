package com.zrgk.project.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zrgk.project.dao.NeedDaoInter;
import com.zrgk.project.model.Basicer;
import com.zrgk.project.model.Needer;
import com.zrgk.utils.JdbcUtil;

/**
 * 
 * @function: dao层，增删改查实现类
 * @author: 张春玲
 * @time: 2015-6-8
 * 
 */
public class NeederDaoImpl extends JdbcUtil implements NeedDaoInter {

	/**插入方法*/
	public boolean insertNeeder(Needer needer) {
		boolean flag = true;
		String sql = "insert into need_sheet(ptitle,project_id,createTime,updateTime,simpleStatement,detail," +
				"comment,updatePeople,addPeople) value(?,?,?,?,?,?,?,?,?)";
		//按表顺序组装绑定问号的值
		List<Object> olist = new ArrayList<Object>();
		olist.add(needer.getPtitle());
		olist.add(needer.getProject_id());
		olist.add(needer.getCreateTime());
		olist.add(needer.getUpdateTime());
		olist.add(needer.getSimpleStatement());	
		olist.add(needer.getDetail());
		olist.add(needer.getComment());
		olist.add(needer.getUpdatePeople());
		olist.add(needer.getAddPeople());
			
		this.doPst(olist, sql); //执行插入
		this.closeAll();		//关闭资源
		return flag;			//返回插入是否成功
	}

	/**删除*/
	public void deleteNeeder(int id) {
		String sql="delete from need_sheet where pid=?";
		List<Object> olist=new ArrayList<Object>();
		olist.add(id);
		this.doPst(olist, sql);

	}

	/**更新数据方法*/
	public boolean updateNeeder(Needer ba) {
		String sql="update need_sheet set ptitle=?,updateTime=?,simpleStatement=?," +
				"detail=?,comment=?,updatePeople=? where pid=?";
		//赋绑定问号的值					 project_id=?,createTime=?,
		List<Object> list=new ArrayList<Object>();		
		list.add(ba.getPtitle());
		//list.add(ba.getProject_id());
		//list.add(ba.getCreateTime());
		list.add(ba.getUpdateTime());
		list.add(ba.getSimpleStatement());
		list.add(ba.getDetail());
		list.add(ba.getComment());		
		list.add(ba.getUpdatePeople());	
		list.add(ba.getPid());
		//调用JDBC方法
		boolean flag=this.doPst(list, sql);
		return flag;
	}

	
	/**查询所有信息的方法*/
	public List<Needer> queryAllNeeder(Needer needer) {
		//新建集合对象存放查回的所有数据
		List<Needer> list=new ArrayList<Needer>();
		List<Object> olist=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("" +
				"select n.pid,n.ptitle,n.project_id, n.createTime,n.updateTime,n.simpleStatement,n.detail,n.comment," +
				"n.updatePeople,n.addPeople," +
				"b.pid,b.projectName " +
				"from basic_info b,need_sheet n where b.pid= n.project_id and 1=1 ");
		
		//通过项目名称查数据
		if(needer!=null&&!"".equals(needer.getProName())&&needer.getProName()!=null){
			sql.append(" and projectName like ? ");		//拼接根据项目名来模糊查询的sql
			olist.add("%"+needer.getProName()+"%");		//向参数集合放值 
		}
				
		//拼接模糊查询
		if(needer!=null&&needer.getPtitle()!=null&&!"".equals(needer.getPtitle().trim())){
			 sql.append(" and ptitle like ?");		//拼接根据项目名来模糊查询的sql
			 olist.add("%"+needer.getPtitle()+"%");	//向参数集合放值 
		}		
		
		 //拼接排序
		 if(needer!=null&&needer.getOrder()==1){
			 sql.append(" order by createTime ");
			 System.out.println("");
		 }
		 if(needer!=null&&needer.getOrder()==2){
			 sql.append(" order by updateTime ");
		 }
		 
		 //拼接分页查询的sql语句
		 if(needer!=null){
			 int num=0;												//从第几条数据开始，默认是0
			 num=(needer.getCurrentPage()-1)*needer.getPageSize();	//页数在变化时，求从第几条开始取
			 sql.append(" limit "+num+","+needer.getPageSize());	//拼接有取数据sql语句（如：limit 0,5）
		 }
		
		//将查回的所有数据放进结果集
		ResultSet rs=this.queryByPst(olist, sql.toString());
		//封装查回的数据
		if(rs!=null){
			try {
				while(rs.next()){
					Needer need=new Needer();
					need.setPid(rs.getInt("pid"));
					need.setPtitle(rs.getString("ptitle"));
					need.setProject_id(rs.getInt("project_id"));
					need.setCreateTime(rs.getString("createTime"));
					need.setUpdateTime(rs.getString("updateTime"));
					need.setSimpleStatement(rs.getString("simpleStatement"));
					need.setDetail(rs.getString("detail"));
					need.setComment(rs.getString("comment"));
					need.setUpdatePeople(rs.getString("updatePeople"));					
					need.setAddPeople(rs.getString("addPeople"));	
					need.setProName(rs.getString("projectName"));
					list.add(need);					
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		this.closeAll();	//关闭资源
		return list;		//返回信息集合
	}

	/**根据自己的Id查询的方法*/
	public Needer queryNeederById(int pid) {
		String sql="select * from need_sheet where pid="+pid;
		Needer need=new Needer();
		ResultSet rs=this.queryByPst(null, sql);
		
		if(rs!=null){
			try {
				//将查回的信息封装到javaBean里
				while(rs.next()){		
					need.setPid(rs.getInt("pid"));
					need.setPtitle(rs.getString("ptitle"));
					need.setProject_id(rs.getInt("project_id"));
					need.setCreateTime(rs.getString("createTime"));
					need.setUpdateTime(rs.getString("updateTime"));
					need.setSimpleStatement(rs.getString("simpleStatement"));
					need.setDetail(rs.getString("detail"));
					need.setComment(rs.getString("comment"));
					need.setUpdatePeople(rs.getString("updatePeople"));					
					need.setAddPeople(rs.getString("addPeople"));									
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return need;
	}

	/**查询总的数据条数	*/
	/*【查询数据总条数的方法里的sql语句要一致，如判断条件一致：sql.append(" and ptitle like ?");这句代码与
	 * sql.append(" and n.ptitle like ?");就不是一致的判断】
	 */	
	public int totalSize(Needer needer) {
		int i=0;
		List<Object> olist=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("" +
				"select count(*) " +
				"from basic_info b,need_sheet n where b.pid= n.project_id and 1=1 ");
		
		//通过项目名称查数据
		if(needer!=null&&!"".equals(needer.getProName())&&needer.getProName()!=null){
			sql.append(" and projectName like ? ");		//拼接根据项目名来模糊查询的sql
			olist.add("%"+needer.getProName()+"%");		//向参数集合放值 
		}
				
		//拼接模糊查询
		if(needer!=null&&needer.getPtitle()!=null&&!"".equals(needer.getPtitle().trim())){
			 sql.append(" and ptitle like ?");		//拼接根据项目名来模糊查询的sql
			 olist.add("%"+needer.getPtitle()+"%");	//向参数集合放值 
		}		
		 	 
		 //调用查询数据库的方法，并将拼接后的sql传去
		 ResultSet rs=this.queryByPst(olist, sql.toString());//sql语句是用聚合函数count计算出有多少列，返回的是count计算出的值的列表（只一行一列）
		 try{
			 if(rs!=null){
				 while(rs.next()){
					 i=rs.getInt(1);//取出rs的第一列（也只有一列）的总条数值
				 }
			 }
		
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 this.closeAll();
		 }
		 
		return i;//返回数据总条数
	}

	/**通过project_id查数据：模块管理里导步联动用*/
	public List<Needer> queryByPojectId(int id) {
		String sql="select n.pid,n.ptitle,n.project_id, n.createTime,n.updateTime,n.simpleStatement,n.detail,n.comment," +
				"n.updatePeople,n.addPeople," +
				"b.pid,b.projectName " +
				"from basic_info b,need_sheet n where b.pid= n.project_id and 1=1 and project_id="+id ;
		ResultSet rs=this.queryByPst(null, sql);
		List<Needer> list=new ArrayList<Needer>();
		if(rs!=null){
			try {
				while(rs.next()){
					Needer need=new Needer();
					need.setPid(rs.getInt("pid"));
					need.setPtitle(rs.getString("ptitle"));
					need.setProject_id(rs.getInt("project_id"));
					need.setCreateTime(rs.getString("createTime"));
					need.setUpdateTime(rs.getString("updateTime"));
					need.setSimpleStatement(rs.getString("simpleStatement"));
					need.setDetail(rs.getString("detail"));
					need.setComment(rs.getString("comment"));
					need.setUpdatePeople(rs.getString("updatePeople"));					
					need.setAddPeople(rs.getString("addPeople"));	
					need.setProName(rs.getString("projectName"));
					list.add(need);	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
}

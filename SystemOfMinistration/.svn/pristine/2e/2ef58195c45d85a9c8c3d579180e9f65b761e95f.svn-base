package com.zrgk.project.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zrgk.project.dao.CakeDaoInter;
import com.zrgk.project.model.Basicer;
import com.zrgk.project.model.Caker;
import com.zrgk.project.model.Needer;
import com.zrgk.utils.JdbcUtil;

/**
 * 
 * @function: dao层，增删改查实现类
 * @author: 张春玲
 * @time: 2015-6-8
 * 
 */
public class CakerDaoImpl extends JdbcUtil implements CakeDaoInter {

	// 插入方法
	public boolean insertCaker(Caker caker) {
		boolean flag = true;
		String sql = "insert into cake_sheet(cakeName,need_id,priority,createTime,updateTime,simpleStatement,detail," +
				"comment,updatePeople,addPeople) value(?,?,?,?,?,?,?,?,?,?)";
		//按表顺序组装绑定问号的值
		List<Object> olist = new ArrayList<Object>();
		olist.add(caker.getCakeName());
		olist.add(caker.getNeed_id());
		olist.add(caker.getPriority());
		olist.add(caker.getCreateTime());
		olist.add(caker.getUpdateTime());
		olist.add(caker.getSimpleStatement());	
		olist.add(caker.getDetail());
		olist.add(caker.getComment());
		olist.add(caker.getUpdatePeople());
		olist.add(caker.getAddPeople());
			
		this.doPst(olist, sql); //执行插入
		return flag;			//返回插入是否成功
	}

	/**删除方法*/
	public void deleteCaker(int id) {
		String sql="delete from cake_sheet where cid=? ";
		List<Object> olist=new ArrayList<Object>();
		olist.add(id);
		this.doPst(olist, sql);
	}

	/**更新数据方法*/
	public boolean updateCaker(Caker ba) {
		String sql="cake need_sheet set cakeName=?,need_id=?,priority=?,createTime=?,updateTime=?,simpleStatement=?," +
				"detail=?,comment=?,updatePeople=?,addPeople=? where cid=?";
				//赋绑定问号的值 
		List<Object> list=new ArrayList<Object>();		
		list.add(ba.getCakeName());
		list.add(ba.getNeed_id());
		list.add(ba.getPriority());
		list.add(ba.getCreateTime());
		list.add(ba.getUpdateTime());
		list.add(ba.getSimpleStatement());
		list.add(ba.getDetail());
		list.add(ba.getComment());		
		list.add(ba.getUpdatePeople());
		list.add(ba.getAddPeople());	
		list.add(ba.getCid());
		//调用JDBC方法
		boolean flag=this.doPst(list, sql);
		return flag;
	}

	
	/**查询所有信息的方法*/
	public List<Caker> queryAllCaker(Caker caker) {
		//新建集合对象存放查回的所有数据
		List<Caker> list=new ArrayList<Caker>();
		List<Object> olist=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("select c.cid, c.cakeName, c.need_id, c.priority, c.createTime, c.updateTime," +
				" c.simpleStatement, c.detail, c.comment, c.updatePeople, c.addPeople, n.ptitle, b.projectName " +
				"from need_sheet n,cake_sheet c , basic_info b where c.need_id=n.pid and n.project_id=b.pid");
		//拼接按项目名称查数据
		if(caker!=null&&!"".equals(caker.getProName())&&caker.getProName()!=null){
			sql.append(" and projectName like ? ");		//拼接根据项目名来模糊查询的sql
			olist.add("%"+caker.getProName()+"%");		//向参数集合放值 
		}
				
		//拼接模糊查询
		if(caker!=null&&caker.getNeedName()!=null&&!"".equals(caker.getNeedName().trim())){
			 sql.append(" and ptitle like ?");			//拼接根据项目名来模糊查询的sql
			 olist.add("%"+caker.getNeedName()+"%");	//向参数集合放值 
		}		
		//拼接按模块名称查询
		if(caker!=null&&caker.getCakeName()!=null&&"".equals(caker.getCakeName())){
			sql.append(" and cakeName like ?  ");
			olist.add("%"+caker.getCakeName()+"%");
		}
		
		 //拼接排序
		 if(caker!=null&&caker.getOrder()==1){
			 sql.append(" order by createTime ");
			 System.out.println("");
		 }
		 if(caker!=null&&caker.getOrder()==2){
			 sql.append(" order by updateTime ");
		 }
		 
		 //拼接分页查询的sql语句
		 if(caker!=null){
			 int num=0;												//从第几条数据开始，默认是0
			 num=(caker.getCurrentPage()-1)*caker.getPageSize();	//页数在变化时，求从第几条开始取
			 sql.append(" limit "+num+","+caker.getPageSize());		//拼接有取数据sql语句（如：limit 0,5）
		 }

		ResultSet rs=this.queryByPst(olist, sql.toString());		//将查回的所有数据放进结果集
		//封装查回的数据
		if(rs!=null){
			try {
				while(rs.next()){
					Caker bas=new Caker();
					bas.setCid(rs.getInt("cid"));
					bas.setCakeName(rs.getString("cakeName"));
					bas.setNeed_id(rs.getInt("need_id"));
					bas.setPriority(rs.getInt("priority"));
					bas.setCreateTime(rs.getString("createTime"));
					bas.setUpdateTime(rs.getString("updateTime"));
					bas.setSimpleStatement(rs.getString("simpleStatement"));
					bas.setDetail(rs.getString("detail"));
					bas.setComment(rs.getString("comment"));
					bas.setUpdatePeople(rs.getString("updatePeople"));					
					bas.setAddPeople(rs.getString("addPeople"));	
					bas.setProName(rs.getString("projectName"));
					bas.setNeedName(rs.getString("ptitle"));
					list.add(bas);					
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.closeAll();	//关闭资源
		return list;		//返回信息集合
	}

	/**根据Id查询的方法*/
	public Caker queryCakerById(int id) {
		String sql="select * from cake_sheet where cid="+id;
		Caker caker=new Caker();
		ResultSet rs=this.queryByPst(null, sql);
		
		if(rs!=null){
			try {
				//将查回的信息封装到javaBean里
				while(rs.next()){		
					caker.setCid(rs.getInt("Cid"));
					caker.setCakeName(rs.getString("cakeName"));
					caker.setNeed_id(rs.getInt("need_id"));
					caker.setPriority(rs.getInt("priority"));
					caker.setCreateTime(rs.getString("createTime"));
					caker.setUpdateTime(rs.getString("updateTime"));
					caker.setSimpleStatement(rs.getString("simpleStatement"));
					caker.setDetail(rs.getString("detail"));
					caker.setComment(rs.getString("comment"));
					caker.setUpdatePeople(rs.getString("updatePeople"));					
					caker.setAddPeople(rs.getString("addPeople"));									
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return caker;
	}

	/**查询总的数据条数	*/
	/*【查询数据总条数的方法里的sql语句要一致，如判断条件一致：sql.append(" and ptitle like ?");这句代码与
	 * sql.append(" and n.ptitle like ?");就不是一致的判断】
	 */	
	public int totalSize(Caker caker) {
		int i=0;
		List<Object> olist=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("" +
				"select count(*) " +
				"from  need_sheet n,cake_sheet c , basic_info b where c.need_id=n.pid and n.project_id=b.pid  ");
	
		//拼接按项目名称查数据
		if(caker!=null&&!"".equals(caker.getProName())&&caker.getProName()!=null){
			sql.append(" and projectName like ? ");		//拼接根据项目名来模糊查询的sql
			olist.add("%"+caker.getProName()+"%");		//向参数集合放值 
		}
				
		//拼接模糊查询
		if(caker!=null&&caker.getNeedName()!=null&&!"".equals(caker.getNeedName().trim())){
			 sql.append(" and ptitle like ?");			//拼接根据项目名来模糊查询的sql
			 olist.add("%"+caker.getNeedName()+"%");	//向参数集合放值 
		}		
		//拼接按模块名称查询
		if(caker!=null&&caker.getCakeName()!=null&&"".equals(caker.getCakeName())){
			sql.append(" and cakeName like ?  ");
			olist.add("%"+caker.getCakeName()+"%");
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

}

package com.zrgk.infobox.dao;

import java.util.List;


import com.zrgk.infobox.model.MailBox;


/**dao包的接口类
 * @author 樊丙富
 *2015-06-04
 */
public interface MailBoxDaoInter {//工程里有导出excel  就不用序列化了
	void insertMailBox(MailBox mailbox);//新增用户信息的方法
	
	List<MailBox>queryMailBox(MailBox mailbox);//查询用户信息
	
	void deleteMailBox(int id);//删除用户信息的方法
	
	MailBox queryMailBoxByid(int id);//根据用户表主键 查询用户信息 传参
	void updateMailBox(MailBox mailbox);//修改用户信息
	
	
	int totalSize(MailBox mailbox);//总条数（分页用到的）
}

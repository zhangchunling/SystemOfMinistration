package com.zrgk.infobox.service.impl;

import java.util.List;

import com.zrgk.infobox.dao.MailBoxDaoInter;
import com.zrgk.infobox.dao.impl.MailBoxDaoImpl;
import com.zrgk.infobox.model.MailBox;
import com.zrgk.infobox.service.MailBoxServiceInter;

/**
 * mailbox的service层的实现类
 * @author 樊丙富
 *2015-06-03
 */
//implements实现mailBoxinter接口后在mailBox继承jdbcUtil类
public class MailBoxServiceImpl implements MailBoxServiceInter {
	MailBoxDaoInter mailboxdao=new MailBoxDaoImpl();
	public void insertMailBox(MailBox mailbox) {//增加的方法
		// 利用mdd5加密  获得原密码
//		String  md5passwrod=MD5.createPassword(mailbox.getPassword());//原始密码
//		mailbox.getPassword(md5passwrod);//加密后的密码
		mailboxdao.insertMailBox(mailbox);//调用dao的方法
	}

	//查找所有方法
	public List<MailBox> queryMailBox(MailBox mailbox) {
		return mailboxdao.queryMailBox(mailbox);//返回
	}

	public void deleteMailBox(int id) {//删除方法
		mailboxdao.deleteMailBox(id);//返回
		
	}

	public MailBox queryMailBoxByid(int id) {//根据主键查询		
		return mailboxdao.queryMailBoxByid(id);//返回
	}

	
	public void updateMailBox(MailBox mailbox) {//修改方法
		mailboxdao.updateMailBox(mailbox);
		
	}

	public int totalSize(MailBox mailbox) {//分页长度
		
		return mailboxdao.totalSize(mailbox);
	}

}

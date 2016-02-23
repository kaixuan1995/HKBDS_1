package cn.kejiameitian.service;

import java.util.List;


import cn.kejiameitian.Exception.ErrorException;
import cn.kejiameitian.dao.baseDao;
import cn.kejiameitian.dao.impl.baseDaoImpl;
import cn.kejiameitian.po.Message;
import cn.kejiameitian.po.Page;

public class MessageService {
	private static MessageService instance = null;
	private boolean flag;
	private List<Message> messageList=null;
	private Message message=null;
    private int id;
	// 牺牲内存，采用单例模式达到数据安全,配合synocnase进行同步。但是比较消耗内存
	public static MessageService getInstance() {
		if (instance == null) {
			instance = new MessageService();
		}
		return instance;
	}
	
	//查询留言
	public List<Message> searchMessage(){
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			messageList = BaseDaoImpl.findMessageEntity();
			return messageList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再输入一次公告！");
		}
	}
	
	//对留言按照标题进行模糊查询
	public List<Message> findMessageEntity(String querymessage){
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			messageList = BaseDaoImpl.findMessageEntity(querymessage);
			return messageList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再查询！");
		}
	}
	//添加留言
	public boolean addMessage(Message message){
		this.message = message;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.Add(message);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再输入一次公告！");
		}
		
	}
	
	//删除留言
	public boolean deleteMessage(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.deleteMessage(id);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请重新删除！");
		}
	}
	
	/*
	 * 留言分页
	 */
	public Page getPageData(String pageNum, String url) {
		baseDao BaseDaoImpl = new baseDaoImpl();
		int totalRecord = BaseDaoImpl.getTotalRecord();
		Page page = null; 
		if(pageNum==null){
			//代表用户想看第一页的数据
			page = new Page(totalRecord,1,3);  //算出了总页数，以及用户想看的页从数据库哪个地方开始取
			
		}else{
			//代表用户想看指定的页
			page = new Page(totalRecord,Integer.parseInt(pageNum),3); 
			
		}
		
		List<Message> list = BaseDaoImpl.getPageData(page.getStartIndex(), page.getPageSize());
		
		page.setList(list);
		page.setUrl(url);
		return page;
	}
}

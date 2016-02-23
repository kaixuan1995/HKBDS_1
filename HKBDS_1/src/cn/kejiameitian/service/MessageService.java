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
	// �����ڴ棬���õ���ģʽ�ﵽ���ݰ�ȫ,���synocnase����ͬ�������ǱȽ������ڴ�
	public static MessageService getInstance() {
		if (instance == null) {
			instance = new MessageService();
		}
		return instance;
	}
	
	//��ѯ����
	public List<Message> searchMessage(){
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			messageList = BaseDaoImpl.findMessageEntity();
			return messageList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ������������һ�ι��棡");
		}
	}
	
	//�����԰��ձ������ģ����ѯ
	public List<Message> findMessageEntity(String querymessage){
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			messageList = BaseDaoImpl.findMessageEntity(querymessage);
			return messageList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ�������ٲ�ѯ��");
		}
	}
	//�������
	public boolean addMessage(Message message){
		this.message = message;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.Add(message);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ������������һ�ι��棡");
		}
		
	}
	
	//ɾ������
	public boolean deleteMessage(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.deleteMessage(id);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ����������ɾ����");
		}
	}
	
	/*
	 * ���Է�ҳ
	 */
	public Page getPageData(String pageNum, String url) {
		baseDao BaseDaoImpl = new baseDaoImpl();
		int totalRecord = BaseDaoImpl.getTotalRecord();
		Page page = null; 
		if(pageNum==null){
			//�����û��뿴��һҳ������
			page = new Page(totalRecord,1,3);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			
		}else{
			//�����û��뿴ָ����ҳ
			page = new Page(totalRecord,Integer.parseInt(pageNum),3); 
			
		}
		
		List<Message> list = BaseDaoImpl.getPageData(page.getStartIndex(), page.getPageSize());
		
		page.setList(list);
		page.setUrl(url);
		return page;
	}
}

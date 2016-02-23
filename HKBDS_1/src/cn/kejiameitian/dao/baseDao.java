package cn.kejiameitian.dao;

import java.util.List;

import cn.kejiameitian.po.Admin;
import cn.kejiameitian.po.Message;
import cn.kejiameitian.po.Notice;
import cn.kejiameitian.po.Product;

public interface baseDao {
	   
//	���
	public boolean Add(Message message);  //�������
	public boolean Add(Notice notice);   //��������
	public boolean Add(Product product);  //��Ӳ�Ʒ
//	ɾ��
	public boolean deleteNotice(int id);  //ɾ������
	public boolean deleteMessage(int id);  //ɾ������
	public boolean deleteProduct(int id);  //ɾ����Ʒ
//	�޸�
	public boolean Update(Notice notice);  //�޸Ĺ���
	public boolean Update(Product product);  //�޸Ĳ�Ʒ
//	��ѯ
	public Admin findEntity(Admin admin);  //��ѯ����Ա��Ϣ 
	
	public List<Notice> findEntity();   //��ѯ����   ����
	public Notice findEntity(int id); //��ѯָ��id�Ĺ���
	public List<Notice> findNoticeEntity(String querynotice);  //ģ����ѯ���� ������Ϣ
	
	public List<Product> findProductEntity();  //�鿴ȫ����   ��Ʒ
	public Product findProductEntity(int id);  //��ѯָ�����Ͳ�Ʒ��Ϣ
	public List<Product> findProductEntity(String category);  //��ѯָ�����Ͳ�Ʒ��Ϣ
	
	public List<Message> findMessageEntity();   //��ѯ����   ����
	public Message findMessageEntity(int id);  //��ѯָ��id���� 
	public List<Message> findMessageEntity(String querymessage);//�����԰��ձ������ģ����ѯ
	
//���Է�ҳ
	public List<Message> getPageData(int startIndex, int pageSize);
	public int getTotalRecord();
	
//��Ʒ��ҳ
	public List<Product> getProductPageData(int startIndex, int pageSize,String category);
	public int getProductTotalRecord(String category);
}

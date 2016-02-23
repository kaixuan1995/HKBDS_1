package cn.kejiameitian.dao;

import java.util.List;

import cn.kejiameitian.po.Admin;
import cn.kejiameitian.po.Message;
import cn.kejiameitian.po.Notice;
import cn.kejiameitian.po.Product;

public interface baseDao {
	   
//	添加
	public boolean Add(Message message);  //添加留言
	public boolean Add(Notice notice);   //发布公告
	public boolean Add(Product product);  //添加产品
//	删除
	public boolean deleteNotice(int id);  //删除公告
	public boolean deleteMessage(int id);  //删除留言
	public boolean deleteProduct(int id);  //删除产品
//	修改
	public boolean Update(Notice notice);  //修改公告
	public boolean Update(Product product);  //修改产品
//	查询
	public Admin findEntity(Admin admin);  //查询管理员信息 
	
	public List<Notice> findEntity();   //查询所有   公告
	public Notice findEntity(int id); //查询指定id的公告
	public List<Notice> findNoticeEntity(String querynotice);  //模糊查询标题 公告信息
	
	public List<Product> findProductEntity();  //查看全部的   产品
	public Product findProductEntity(int id);  //查询指定类型产品信息
	public List<Product> findProductEntity(String category);  //查询指定类型产品信息
	
	public List<Message> findMessageEntity();   //查询所有   留言
	public Message findMessageEntity(int id);  //查询指定id留言 
	public List<Message> findMessageEntity(String querymessage);//对留言按照标题进行模糊查询
	
//留言分页
	public List<Message> getPageData(int startIndex, int pageSize);
	public int getTotalRecord();
	
//产品分页
	public List<Product> getProductPageData(int startIndex, int pageSize,String category);
	public int getProductTotalRecord(String category);
}

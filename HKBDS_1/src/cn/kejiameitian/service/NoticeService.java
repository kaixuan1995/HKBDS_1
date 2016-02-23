package cn.kejiameitian.service;

import java.util.List;

import cn.kejiameitian.Exception.ErrorException;
import cn.kejiameitian.dao.baseDao;
import cn.kejiameitian.dao.impl.baseDaoImpl;
import cn.kejiameitian.po.Notice;

public class NoticeService {
	private static NoticeService instance = null;
	private boolean flag;
	private List<Notice> noticeList=null;
	private List<Notice> noticetitleList=null;
	private Notice notice=null;
    private int id;
    private String querynotice;
	// 牺牲内存，采用单例模式达到数据安全,配合synocnase进行同步。但是比较消耗内存
	public static NoticeService getInstance() {
		if (instance == null) {
			instance = new NoticeService();
		}
		return instance;
	}
	
	/*
	 * 增加公告
	 */
	public boolean addNotice(Notice notice){
		this.notice = notice;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.Add(notice);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再输入一次公告！");
		}
		
	}
	/*
	 * 查询所有公告
	 */
	public List<Notice> searchNotice(){
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			noticeList = BaseDaoImpl.findEntity();
			return noticeList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再输入一次公告！");
		}
	}
	
	/*
	 * 查询指定id公告
	 */
	public Notice searchNotice(int id){
		this.id=id;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			notice = BaseDaoImpl.findEntity(id);
			return notice;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再输入一次公告！");
		}
	}

	/*
	 * 对公告标题进行模糊查询
	 */
	public List<Notice> searchNotice(String querynotice){
		this.querynotice=querynotice;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			noticetitleList = BaseDaoImpl.findNoticeEntity(querynotice);
			return noticetitleList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再次查询！");
		}
	}
	
	/*
	 * 删除指定id的公告
	 */
	public boolean deleteNotice(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.deleteNotice(id);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请重新删除！");
		}
	}
	
/*
 * 	修改公告
 */
	public boolean updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		this.notice = notice;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.Update(notice);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再输入一次公告！");
		}
	}
	
}

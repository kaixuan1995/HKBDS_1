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
	// �����ڴ棬���õ���ģʽ�ﵽ���ݰ�ȫ,���synocnase����ͬ�������ǱȽ������ڴ�
	public static NoticeService getInstance() {
		if (instance == null) {
			instance = new NoticeService();
		}
		return instance;
	}
	
	/*
	 * ���ӹ���
	 */
	public boolean addNotice(Notice notice){
		this.notice = notice;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.Add(notice);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ������������һ�ι��棡");
		}
		
	}
	/*
	 * ��ѯ���й���
	 */
	public List<Notice> searchNotice(){
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			noticeList = BaseDaoImpl.findEntity();
			return noticeList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ������������һ�ι��棡");
		}
	}
	
	/*
	 * ��ѯָ��id����
	 */
	public Notice searchNotice(int id){
		this.id=id;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			notice = BaseDaoImpl.findEntity(id);
			return notice;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ������������һ�ι��棡");
		}
	}

	/*
	 * �Թ���������ģ����ѯ
	 */
	public List<Notice> searchNotice(String querynotice){
		this.querynotice=querynotice;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			noticetitleList = BaseDaoImpl.findNoticeEntity(querynotice);
			return noticetitleList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ�������ٴβ�ѯ��");
		}
	}
	
	/*
	 * ɾ��ָ��id�Ĺ���
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
			throw new ErrorException("ϵͳ����������ɾ����");
		}
	}
	
/*
 * 	�޸Ĺ���
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
			throw new ErrorException("ϵͳ������������һ�ι��棡");
		}
	}
	
}

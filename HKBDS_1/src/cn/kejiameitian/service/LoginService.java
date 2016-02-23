package cn.kejiameitian.service;

import cn.kejiameitian.Exception.ErrorException;
import cn.kejiameitian.dao.baseDao;
import cn.kejiameitian.dao.impl.baseDaoImpl;
import cn.kejiameitian.po.Admin;

public class LoginService {
	private static LoginService instance = null;
	private Admin admin;

	// �����ڴ棬���õ���ģʽ�ﵽ���ݰ�ȫ,���synocnase����ͬ�������ǱȽ������ڴ�
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}

	public Admin SearchUser(Admin admin) {
		// TODO Auto-generated method stub
		Admin user1 = null;
		this.admin = admin;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			user1 = BaseDaoImpl.findEntity(admin);
			return user1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("�û������������");
		}
	}
}

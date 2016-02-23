package cn.kejiameitian.service;

import java.util.List;

import cn.kejiameitian.Exception.ErrorException;
import cn.kejiameitian.dao.baseDao;
import cn.kejiameitian.dao.impl.baseDaoImpl;
import cn.kejiameitian.po.Message;
import cn.kejiameitian.po.Notice;
import cn.kejiameitian.po.Page;
import cn.kejiameitian.po.Product;

public class ProductService {
	private static ProductService instance = null;
	// �����ڴ棬���õ���ģʽ�ﵽ���ݰ�ȫ,���synocnase����ͬ�������ǱȽ������ڴ�
	private Product product = null;
    private boolean flag;
    private List<Product> productList=null;
	private int id;
	private String category;
	public static ProductService getInstance() {
		if (instance == null) {
			instance = new ProductService();
		}
		return instance;
	}

	/*
	 * ��Ӳ�Ʒ
	 */
	public boolean addproduct(Product product) {
		this.product = product;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.Add(product);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ������������һ�Σ�");
		}

	}

	/*
	 * ��ѯ���в�Ʒ
	 */
	public List<Product> searchProduct(){
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			productList = BaseDaoImpl.findProductEntity();
			return productList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ������������һ�Σ�");
		}
	}
	
	/*
	 * ����id��ѯ��Ʒ
	 */
	public Product searchProduct(int id){
		this.id=id;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			product = BaseDaoImpl.findProductEntity(id);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ������������һ�ι��棡");
		}
	}
	
	/*
	 *  �������Ͳ�ѯ��Ʒ
	 */
	public List<Product> searchProduct(String category){
		this.category=category;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			productList = BaseDaoImpl.findProductEntity(category);
			return productList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ������������һ�ι��棡");
		}
	}
	
	/*
	 * �޸Ĳ�Ʒ
	 */
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		this.product = product;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.Update(product);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ������������һ�Σ�");
		}
	}
	
	/*
	 * ����idɾ����Ʒ
	 */
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.deleteProduct(id);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("ϵͳ����������ɾ����");
		}
	}
	
	/*
	 * ��Ʒ��ҳ
	 */
	public Page getProductPageData(String pageNum, String url ,String category) {
		baseDao BaseDaoImpl = new baseDaoImpl();
		int totalRecord = BaseDaoImpl.getProductTotalRecord(category);
		Page page = null; 
		if(pageNum==null){
			//�����û��뿴��һҳ������
			page = new Page(totalRecord,1,6);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			
		}else{
			//�����û��뿴ָ����ҳ
			page = new Page(totalRecord,Integer.parseInt(pageNum),6); 
			
		}
		
		List<Product> list = BaseDaoImpl.getProductPageData(page.getStartIndex(), page.getPageSize(),category);
		
		page.setList(list);
		page.setUrl(url);
		return page;
	}
}

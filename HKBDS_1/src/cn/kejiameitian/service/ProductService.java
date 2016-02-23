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
	// 牺牲内存，采用单例模式达到数据安全,配合synocnase进行同步。但是比较消耗内存
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
	 * 添加产品
	 */
	public boolean addproduct(Product product) {
		this.product = product;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			flag = BaseDaoImpl.Add(product);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再输入一次！");
		}

	}

	/*
	 * 查询所有产品
	 */
	public List<Product> searchProduct(){
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			productList = BaseDaoImpl.findProductEntity();
			return productList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再输入一次！");
		}
	}
	
	/*
	 * 根据id查询产品
	 */
	public Product searchProduct(int id){
		this.id=id;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			product = BaseDaoImpl.findProductEntity(id);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再输入一次公告！");
		}
	}
	
	/*
	 *  按照类型查询产品
	 */
	public List<Product> searchProduct(String category){
		this.category=category;
		baseDao BaseDaoImpl = new baseDaoImpl();
		try {
			productList = BaseDaoImpl.findProductEntity(category);
			return productList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorException("系统出错，请再输入一次公告！");
		}
	}
	
	/*
	 * 修改产品
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
			throw new ErrorException("系统出错，请再输入一次！");
		}
	}
	
	/*
	 * 根据id删除产品
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
			throw new ErrorException("系统出错，请重新删除！");
		}
	}
	
	/*
	 * 产品分页
	 */
	public Page getProductPageData(String pageNum, String url ,String category) {
		baseDao BaseDaoImpl = new baseDaoImpl();
		int totalRecord = BaseDaoImpl.getProductTotalRecord(category);
		Page page = null; 
		if(pageNum==null){
			//代表用户想看第一页的数据
			page = new Page(totalRecord,1,6);  //算出了总页数，以及用户想看的页从数据库哪个地方开始取
			
		}else{
			//代表用户想看指定的页
			page = new Page(totalRecord,Integer.parseInt(pageNum),6); 
			
		}
		
		List<Product> list = BaseDaoImpl.getProductPageData(page.getStartIndex(), page.getPageSize(),category);
		
		page.setList(list);
		page.setUrl(url);
		return page;
	}
}

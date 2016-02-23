package cn.kejiameitian.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;

import cn.kejiameitian.Exception.ErrorException;
import cn.kejiameitian.po.Page;
import cn.kejiameitian.po.Product;
import cn.kejiameitian.service.NoticeService;
import cn.kejiameitian.service.ProductService;
import cn.kejiameitian.util.TransCoding;
import cn.kejiameitian.util.UploadUtil;

public class ProductServlet extends HttpServlet {
	private String operate = null;

	private int judgeServlet(String operate) {
		this.operate = operate;
		if (operate.equalsIgnoreCase("manageProduct")) {
			return 1;
		}
		if (operate.equalsIgnoreCase("manageProduct1")) {
			return 2;
		}
		if (operate.equalsIgnoreCase("manageProduct3")) {
			return 3;
		}
		if (operate.equalsIgnoreCase("manageProduct4")) {
			return 4;
		}
		if (operate.equalsIgnoreCase("manageProduct5")) {
			return 5;
		}
		return 0;

	}
	
	/**
	 * Constructor of the object.
	 */
	public ProductServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String path = request.getSession().getServletContext()
				.getRealPath("/")
				+ "ProductImages\\";// �̶��ļ��ϴ�·��Ϊpath������һ����ʱ���ļ�����
		operate = request.getParameter("operate");
		StringBuilder exceptionInfo = new StringBuilder();
		// ��Ʒ��������
		if (operate.equalsIgnoreCase("relaseProduct")) {
			UploadUtil fut = new UploadUtil(request, 3 * 1024 * 1024, path);// �����ϴ��ļ��Ĵ�СΪ3MB
			Product product = new Product();
			String date = new Date().toString();
			product.setP_date(date);
			product.setP_category(TransCoding.transcoding(fut
					.getParameter("p_category")));
			product.setP_content(TransCoding.transcoding(fut
					.getParameter("p_content")));
			
			List<String> all = new ArrayList<String>();
			Map<String, FileItem> map = fut.getUploadFiles();
			Iterator<Entry<String, FileItem>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, FileItem> m = it.next();
				all.add(m.getKey());
			}
			File url = new File(all.get(0));
			String p_name = url.getName();
			product.setP_image(p_name);
			
			product.setP_name(TransCoding.transcoding(fut
					.getParameter("p_name")));
			product.setP_price(fut.getParameter("p_price"));
			ProductService productService = ProductService.getInstance();
			try {
				boolean flag = productService.addproduct(product);
				if (flag == true) {
					exceptionInfo.append("��Ʒ�����ɹ���");
				} else {
					exceptionInfo.append("��Ʒ����ʧ�ܣ������·�����");
				}
			} catch (ErrorException e) {
				// TODO: handle exception
				exceptionInfo.append(e.getMessage());
			} 
			request.setAttribute("exceptionInfo", exceptionInfo);
			request.getRequestDispatcher("backstage_file/back/Products.jsp")
					.forward(request, response);
		}
		// ��Ʒ��ƽ̨��ʾ
		if (operate.contains("manageProduct")) {
			ProductService productService = ProductService.getInstance();
			List<Product> productlist = productService.searchProduct();
			if (this.judgeServlet(operate) == 1) {
				if (productlist == null) {
					exceptionInfo.append("��������");
					request.getRequestDispatcher("backstage_file/index.jsp")
							.forward(request, response);
				} else {
					request.setAttribute("productlist", productlist);
					request.getRequestDispatcher(
							"backstage_file/back/ManageProduct.jsp").forward(
							request, response);
				}
			}

			if (this.judgeServlet(operate) == 2) {
				String category = request.getParameter("category");
				List<Product> categorylist = productService.searchProduct(category);
				if (categorylist != null) {
					request.setAttribute("productlist", categorylist);
					request.getRequestDispatcher(
							"backstage_file/back/ManageProduct.jsp").forward(
							request, response);
				} else {
					exceptionInfo.append("��ѯʧ�ܣ������ԣ�");
					request.setAttribute("exceptionInfo", exceptionInfo);
					request.getRequestDispatcher(
							"ProductServlet?operate=manageProduct").forward(
							request, response);
				}
			}
			
			if (this.judgeServlet(operate) == 3) {
				int id = Integer.parseInt(request.getParameter("id"));
			 	Product flag = productService.searchProduct(id);
				if (flag != null) {
					request.setAttribute("flag", flag);
					request.getRequestDispatcher(
							"backstage_file/back/UpdateProducts.jsp").forward(
							request, response);
				} else {
					exceptionInfo.append("�޸�ʧ�ܣ��������޸ģ�");
					request.setAttribute("exceptionInfo", exceptionInfo);
					request.getRequestDispatcher(
							"ProductServlet?operate=manageProduct").forward(
							request, response);
				}
			}
			
			if (this.judgeServlet(operate) == 4) {
				if (productlist == null) {
					exceptionInfo.append("��������");
					request.getRequestDispatcher("index.jsp")
							.forward(request, response);
				} else {
					String category = request.getParameter("category");
					category = new String(category.getBytes("ISO-8859-1"), "UTF-8");   //����ת�룬������Ϊservlet�е�Ĭ�ϱ���ΪISO-8859-1����ת�������ִ����Ĳ�������
					HttpSession session  = request.getSession();
					Page page = productService.getProductPageData(request.getParameter("pagenum"), request.getContextPath()+"/ProductServlet",category);
					session.setAttribute("category", category);
					session.setAttribute("page", page);
					
					request.getRequestDispatcher("view/product.jsp").forward(request, response);
					
					/*HttpSession session  = request.getSession();
					session.setAttribute("productlist", productlist);
					request.getRequestDispatcher(
							"view/product.jsp").forward(
							request, response);*/
				}
			}
		}
//		ɾ����Ʒ
		if (operate.equalsIgnoreCase("deleteProduct")) {
			int id = Integer.parseInt(request.getParameter("id"));
			ProductService productService = ProductService.getInstance();
			try {
				boolean flag = productService.deleteProduct(id);
				if (flag == true) {
					exceptionInfo.append("ɾ���ɹ���");
				} else {
					exceptionInfo.append("ɾ��ʧ�ܣ������ɾ����");
				}
			} catch (ErrorException e) {
				// TODO: handle exception
				exceptionInfo.append(e.getMessage());
			}
			request.setAttribute("exceptionInfo", exceptionInfo);
			request.getRequestDispatcher("NoticeServlet?operate=manageNotice")
					.forward(request, response);
		}
		
		// ��Ʒ�޸�
			if (operate.equalsIgnoreCase("updateProduct")) {
				UploadUtil fut = new UploadUtil(request, 3 * 1024 * 1024, path);// �����ϴ��ļ��Ĵ�СΪ3MB
				Product product = new Product();
				String date = new Date().toString();
				product.setP_date(date);
				product.setP_category(TransCoding.transcoding(fut
						.getParameter("p_category")));
				product.setP_content(TransCoding.transcoding(fut
						.getParameter("p_content")));
				
				List<String> all = new ArrayList<String>();
				Map<String, FileItem> map = fut.getUploadFiles();
				Iterator<Entry<String, FileItem>> it = map.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, FileItem> m = it.next();
					all.add(m.getKey());
				}
				File url = new File(all.get(0));    //ע���ϴ���ͼ����Ϊ��
				String p_name = url.getName();
				product.setP_image(p_name);
				
				product.setP_name(TransCoding.transcoding(fut
						.getParameter("p_name")));
				product.setP_price(fut.getParameter("p_price"));
				int id = Integer.parseInt(request.getParameter("id"));
				product.setP_id(id);
System.out.println("��Ʒid" + id);
				ProductService productService = ProductService.getInstance();
				try {
					boolean flag = productService.updateProduct(product);
					if (flag == true) {
						exceptionInfo.append("��Ʒ�޸ĳɹ���");
					} else {
						exceptionInfo.append("��Ʒ�޸�ʧ�ܣ������·�����");
					}
				} catch (ErrorException e) {
					exceptionInfo.append(e.getMessage());
				}
				request.setAttribute("exceptionInfo", exceptionInfo);
				request.getRequestDispatcher("ProductServlet?operate=manageProduct")
						.forward(request, response);
			}
	}

	
			
	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

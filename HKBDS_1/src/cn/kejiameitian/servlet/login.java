package cn.kejiameitian.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.kejiameitian.po.Admin;
import cn.kejiameitian.service.LoginService;

public class login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public login() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 StringBuilder exceptionInfo = new StringBuilder();
		 HttpSession session = request.getSession(false);
		 Admin admin = new Admin();
		 admin.setAdmin(request.getParameter("admin"));
		 admin.setPasword(request.getParameter("pasword"));
		 LoginService loginSerice=LoginService.getInstance();
		 Admin flag=loginSerice.SearchUser(admin);
		 if(flag!=null){
             session.setAttribute("username", flag);
			 request.getRequestDispatcher("backstage_file/index.jsp")
				.forward(request, response);
		 }else{
			 exceptionInfo.append("用户名或密码错误！");
			 request.setAttribute("exceptionInfo", exceptionInfo);
			 request.getRequestDispatcher("view/signin.jsp")
				.forward(request, response);
		 }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

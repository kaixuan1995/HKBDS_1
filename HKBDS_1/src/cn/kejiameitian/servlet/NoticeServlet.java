package cn.kejiameitian.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.kejiameitian.Exception.ErrorException;
import cn.kejiameitian.po.Notice;
import cn.kejiameitian.service.NoticeService;

public class NoticeServlet extends HttpServlet {
	private String operate = null;

	/**
	 * Constructor of the object.
	 */
	public NoticeServlet() {
		super();
	}

	private int judgeServlet(String operate) {
		this.operate = operate;
		if (operate.equalsIgnoreCase("manageNotice")) {
			return 1;
		}
		if (operate.equalsIgnoreCase("manageNotice1")) {
			return 2;
		}
		if (operate.equalsIgnoreCase("manageNotice3")) {
			return 3;
		}
		if (operate.equalsIgnoreCase("manageNotice4")) {
			return 4;
		}
		if (operate.equalsIgnoreCase("manageNotice5")) {
			return 5;
		}
		return 0;

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
		operate = request.getParameter("operate");
		StringBuilder exceptionInfo = new StringBuilder();
		// ���淢������
		if (operate.equalsIgnoreCase("relaseNotice")) {
			Notice notice = new Notice();
			String date = new Date().toString();
			notice.setN_date(date);
			notice.setN_item(request.getParameter("n_item"));
			notice.setNotice(request.getParameter("notice"));
			NoticeService noticeService = NoticeService.getInstance();
			try {
				boolean flag = noticeService.addNotice(notice);
				if (flag == true) {
					exceptionInfo.append("���淢���ɹ���");
				} else {
					exceptionInfo.append("���淢��ʧ�ܣ������·�����");
				}
			} catch (ErrorException e) {
				// TODO: handle exception
				exceptionInfo.append(e.getMessage());
			}
			request.setAttribute("exceptionInfo", exceptionInfo);
			request.getRequestDispatcher("backstage_file/back/RealseNotice.jsp")
					.forward(request, response);
		}
		// ������ʾ
		if (operate.contains("manageNotice")) {
			NoticeService noticeService = NoticeService.getInstance();
			List<Notice> noticelist = noticeService.searchNotice();
			if (this.judgeServlet(operate) == 1) {
				request.setAttribute("noticelist", noticelist);
				request.getRequestDispatcher(
						"backstage_file/back/ManageNotice.jsp").forward(
						request, response);
			}
			if (this.judgeServlet(operate) == 2) {
                HttpSession session  = request.getSession();
				session.setAttribute("noticelist", noticelist);  //һ��Ҫ�����ϱ��浽session�У�����ǰ̨ȡ����
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			}
			if (this.judgeServlet(operate) == 3) {
				int id = Integer.parseInt(request.getParameter("id"));
			 	Notice flag = noticeService.searchNotice(id);
				if (flag != null) {
					request.setAttribute("flag", flag);
					request.getRequestDispatcher(
							"backstage_file/back/UpdateNotice.jsp").forward(
							request, response);
				} else {
					exceptionInfo.append("�޸�ʧ�ܣ��������޸ģ�");
					request.setAttribute("exceptionInfo", exceptionInfo);
					request.getRequestDispatcher(
							"NoticeServlet?operate=manageNotice").forward(
							request, response);
				}
			}
			if (this.judgeServlet(operate) == 4) {
				String querynotice = request.getParameter("querynotice");
				List<Notice> titlenoticelist = noticeService.searchNotice(querynotice);
				if (titlenoticelist != null) {
					request.setAttribute("noticelist", titlenoticelist);
					request.getRequestDispatcher(
							"backstage_file/back/ManageNotice.jsp").forward(
							request, response);
				} else {
					exceptionInfo.append("��ѯʧ�ܣ������ԣ�");
					request.setAttribute("exceptionInfo", exceptionInfo);
					request.getRequestDispatcher(
							"NoticeServlet?operate=manageNotice").forward(
							request, response);
				}
			}
		}
		// ����ɾ������
		if (operate.equalsIgnoreCase("deleteNotice")) {
			int id = Integer.parseInt(request.getParameter("id"));
			NoticeService noticeService = NoticeService.getInstance();
			try {
				boolean flag = noticeService.deleteNotice(id);
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
		// �����޸�
		if (operate.equalsIgnoreCase("updateNotice")) {
			Notice notice = new Notice();
			String date = new Date().toString();
			notice.setN_date(date);
			notice.setN_item(request.getParameter("n_item"));
			notice.setNotice(request.getParameter("notice"));
			int id = Integer.parseInt(request.getParameter("id"));
			notice.setId(id);
System.out.println("�������" + id);
			NoticeService noticeService = NoticeService.getInstance();
			try {
				boolean flag = noticeService.updateNotice(notice);
				if (flag == true) {
					exceptionInfo.append("�����޸ĳɹ���");
				} else {
					exceptionInfo.append("�����޸�ʧ�ܣ������·�����");
				}
			} catch (ErrorException e) {
				exceptionInfo.append(e.getMessage());
			}
			request.setAttribute("exceptionInfo", exceptionInfo);
			request.getRequestDispatcher("NoticeServlet?operate=manageNotice")
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

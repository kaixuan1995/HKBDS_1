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
import cn.kejiameitian.po.Message;
import cn.kejiameitian.po.Notice;
import cn.kejiameitian.po.Page;
import cn.kejiameitian.service.MessageService;

public class MessageServlet extends HttpServlet {

	private String operate = null;
	
	private int judgeServlet(String operate) {
		this.operate = operate;
		if (operate.equalsIgnoreCase("manageMessage")) {   //显示全部留言
			return 1;
		}
		if (operate.equalsIgnoreCase("manageMessage1")) { //显示分页留言
			return 2;
		}
		if (operate.equalsIgnoreCase("manageMessage3")) {   //显示条件查询出的留言
			return 3;
		}
		if (operate.equalsIgnoreCase("manageMessage4")) {
			return 4;
		}
		if (operate.equalsIgnoreCase("manageMessage5")) {
			return 5;
		}
		return 0;

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    operate = request.getParameter("operate");
		StringBuilder exceptionInfo = new StringBuilder();
		// 留言发布操作
		if (operate.equalsIgnoreCase("relaseMessage")) {
			Message message = new Message();
			String date = new Date().toString();
			message.setM_date(date);
			message.setM_name(request.getParameter("username"));
			message.setM_item(request.getParameter("title"));
			message.setM_emil(request.getParameter("email"));
			message.setM_address(request.getParameter("address"));
			message.setM_message(request.getParameter("message"));
			MessageService messageService = MessageService.getInstance();
			try {
				boolean flag = messageService.addMessage(message);
				if (flag == true) {
					exceptionInfo.append("留言发布成功！");
				} else {
					exceptionInfo.append("留言发布失败，请重新发布！");
				}
			} catch (ErrorException e) {
				// TODO: handle exception
				exceptionInfo.append(e.getMessage());
			}
			request.setAttribute("exceptionInfo", exceptionInfo);
			request.getRequestDispatcher("view/contact.jsp")
					.forward(request, response);
			return;
		}
		
//		//留言显示操作
//		if (operate.contains("manageMessage")) {
//			MessageService messageService = MessageService.getInstance();
//			List<Message> messagelist = messageService.searchMessage();
//			if (this.judgeServlet(operate) == 1) {
//				request.setAttribute("messagelist", messagelist);
//				request.getRequestDispatcher(
//						"backstage_file/back/ManageMessage.jsp").forward(
//						request, response);
//			}
//			if (this.judgeServlet(operate) == 2) {
//				HttpSession session  = request.getSession();
//				session.setAttribute("messagelist", messagelist);
//				request.getRequestDispatcher("view/contact.jsp").forward(request,
//						response);
//			}
//		}
		
		
		//留言分页显示操作
		if (operate.contains("manageMessage")) {
			MessageService messageService = MessageService.getInstance();
			/*Page page = messageService.getPageData(request.getParameter("pagenum"), request.getContextPath()+"/MessageServlet");
			request.setAttribute("page", page);
			request.getRequestDispatcher("view/contact.jsp").forward(request, response);
			return;*/
			
			List<Message> messagelist = messageService.searchMessage();
			if (this.judgeServlet(operate) == 1) {
				request.setAttribute("messagelist", messagelist);
				request.getRequestDispatcher(
						"backstage_file/back/ManageMessage.jsp").forward(
								request, response);
				
			}
			if (this.judgeServlet(operate) == 2) {
				HttpSession session  = request.getSession();
				Page page = messageService.getPageData(request.getParameter("pagenum"), request.getContextPath()+"/MessageServlet");
				session.setAttribute("page", page);
				
				request.getRequestDispatcher("view/contact.jsp").forward(request, response);
				
			}
			if (this.judgeServlet(operate) == 3) {
				String querymessage = request.getParameter("querymessage");
				List<Message> titlemessagelist = messageService.findMessageEntity(querymessage);
				if (titlemessagelist != null) {
					request.setAttribute("messagelist", titlemessagelist);
					request.getRequestDispatcher(
							"backstage_file/back/ManageMessage.jsp").forward(
							request, response);
				} else {
					exceptionInfo.append("查询失败，请重试！");
					request.setAttribute("exceptionInfo", exceptionInfo);
					request.getRequestDispatcher(
							"MessageServlet?operate=manageMessage").forward(
							request, response);
				}
			}
			
		}
		
		//删除留言操作
		if (operate.equalsIgnoreCase("deleteMessage")) {
			int id = Integer.parseInt(request.getParameter("id"));
			MessageService messageService = MessageService.getInstance();
			try {
				boolean flag = messageService.deleteMessage(id);
				if (flag == true) {
					exceptionInfo.append("删除成功！");
				} else {
					exceptionInfo.append("删除失败，请重新删除！");
				}
			} catch (ErrorException e) {
				// TODO: handle exception
				exceptionInfo.append(e.getMessage());
			}
			request.setAttribute("exceptionInfo", exceptionInfo);
			request.getRequestDispatcher("MessageServlet?operate=manageMessage")
					.forward(request, response);
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}

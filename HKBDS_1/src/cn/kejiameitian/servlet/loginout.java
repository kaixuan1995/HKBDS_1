package cn.kejiameitian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginout extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          HttpSession session = request.getSession();
  		  StringBuilder exceptionInfo = new StringBuilder();
          session.removeAttribute("username");
          exceptionInfo.append("×¢Ïú³É¹¦£¡");
			request.setAttribute("exceptionInfo", exceptionInfo);
		  RequestDispatcher dispatcher = request
					.getRequestDispatcher("index1.jsp");
		  dispatcher.forward(request, response);

	}

}

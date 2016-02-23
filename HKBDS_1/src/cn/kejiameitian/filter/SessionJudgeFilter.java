package cn.kejiameitian.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionJudgeFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rep;
		StringBuilder exceptionInfo = new StringBuilder();
		HttpSession session = request.getSession(false);
		String createUrl = request.getRequestURI();
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("back/SignalforWord.jsp");// �����������û�е�½��Ҫת������ҳ��
		if (createUrl.contains("backstage_file")) {
			if (session == null || session
					.getAttribute("username") == null) {
				exceptionInfo.append("����û�е��룬���ȵ��룡");
				request.setAttribute("exceptionInfo", exceptionInfo);
				dispatcher.forward(request, response);
				return;
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}

package it.polito.ai.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polito.ai.businesslogic.LoginService;

@WebServlet("/login/do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginService loginService = (LoginService) request.getSession().getAttribute("loginService");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:" + username + " password:" + password + " loginService:" + loginService);
		// TODO use for continue navigation (url param)
		String nextPage = (String) request.getSession().getAttribute("nextPage");
		System.out.println("nextPage:" + nextPage);
		if (loginService != null && loginService.login(username, password)) {
			// success (go to homepage for now)
			if (nextPage != null) {
				request.getSession().setAttribute("nextPage", null);
				response.sendRedirect(nextPage);
			} else {
				response.sendRedirect(request.getContextPath());
			}
		} else {
			// fail (go again to login page)
			// TODO should display error message
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}

	}

}

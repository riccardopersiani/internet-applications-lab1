package it.polito.ai.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polito.ai.businesslogic.LoginService;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		LoginService loginService = (LoginService) request.getSession().getAttribute("loginService");
	
		if (loginService != null) {
			loginService.logout();
			// invalidate the session, so that the the session gets destroyed
			// and the JSESSIONID cookie is not more valid
			request.getSession().invalidate();
			// success (go to homepage for now)
			response.sendRedirect(request.getContextPath());
		} else {
			// fail (go again to login page)
			// TODO should display error message
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}

}

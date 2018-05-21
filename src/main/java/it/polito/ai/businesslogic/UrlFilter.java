package it.polito.ai.businesslogic;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/private/*")
public class UrlFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter running");
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			HttpSession session = httpRequest.getSession();
			LoginService loginService = (LoginService) session.getAttribute("loginService");
			if (loginService != null && loginService.isLoggedIn()) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			} else {
				System.out.println("blocked request for " + httpRequest.getRequestURI());
				// distinguish request method
				if (httpRequest.getMethod().toUpperCase().equals("GET")) {
					// for GET requests, simply save the blocked URL in the
					// session
					session.setAttribute("nextPage", httpRequest.getRequestURI());
				} else {
					// for POST requests, get the Referer page and save in the
					// session
					session.setAttribute("nextPage", httpRequest.getHeader("Referer"));
				}
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package com.hp.onlinexam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "rightsfilter", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "excludeURL", value = "/static") })
public class RightsFilter implements Filter {
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Object o = req.getSession().getAttribute("user");
		String currentURL = req.getRequestURI();
		String targetURL = currentURL.substring(currentURL.indexOf("/", 1), currentURL.length());
		if (o == null && !targetURL.equals("/login.jsp")) {
			if (!targetURL.equals("/loginServlet") && !currentURL.contains("static")) {
				resp.sendRedirect(req.getContextPath() + "/login.jsp");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}
}
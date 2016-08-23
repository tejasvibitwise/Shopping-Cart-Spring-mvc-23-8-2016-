package com.bitwise.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpSession session = rq.getSession(false);
		
		if (rq.getRequestURI().equals("/Shopping_Cart/login")) {
			chain.doFilter(rq, response);
			
		} 
		else if (rq.getRequestURI().equals("/Shopping_Cart/success")) {
			chain.doFilter(rq, response);
		}

		else if (rq.getRequestURI().equals("/Shopping_Cart/logout")) {
			chain.doFilter(rq, response);
		}

		else if (session != null && session.getAttribute("user") != null) {
			chain.doFilter(rq, response);
		}

		else {
			
			out.print("<center><font color='red'>Please login first</font></center>");
			rq.getRequestDispatcher("/login").include(rq, response);
		}
		out.close();
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package com.jeon.board.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String servletPath = request.getServletPath();
		
		System.out.println("contextPath : " + contextPath);
		
		if(chkExcludeMappingPath(servletPath) == true) {
			System.out.println("This " + servletPath + " path don't need to login.");
			return true;
		}else {
			if(session.getAttribute("boardSessionId") != null) {
				System.out.println("You have login already.");
				return true;
			}else {
				System.out.println("You need login !!!");
				response.sendRedirect(contextPath + "/login/form.do");
				return false;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private boolean chkExcludeMappingPath(String servletPath) {
		HashSet<String> excludeMappingPath = getExcludeMappingPath();
		Iterator<String> iterator = excludeMappingPath.iterator();
		
		//System.out.println("servletPath : " + servletPath);
		while(iterator.hasNext()) {
			String excludePath = iterator.next();
			//System.out.println("excludePath : " + excludePath);
			if(servletPath.indexOf(excludePath) > -1) {
				return true;
			}
		}
		return false;
	}
	
	private HashSet<String> getExcludeMappingPath() {
		return setExcludeMappingPath();
	}
	
	private HashSet<String> setExcludeMappingPath() {
		HashSet<String> excludeMappingPath = new HashSet<String>();
		excludeMappingPath.add("/login");
		excludeMappingPath.add("/main");
		excludeMappingPath.add("/boards");
		excludeMappingPath.add("/board/detail.do");
		
		return excludeMappingPath;
	}

}

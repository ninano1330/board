package com.jeon.board.config;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		HttpSession session = request.getSession();
//		String contextPath = request.getContextPath();
//		String requestURI = request.getRequestURI();
//		String servletPath = request.getServletPath();
//		String serverName = request.getServerName();
//		StringBuffer requestURL = request.getRequestURL();
//		String referer = request.getHeader("Referer");
//		
//		if(chkExcludeMappingPath(servletPath) == true) {
//			return true;
//		}else {
//			if(session.getAttribute("boardSessionId") != null) {
//				return true;
//			}else {
//				PrintWriter printWriter = response.getWriter();
//				
//				//printWriter.print("<script>window.open('/board/login/form.do');location.href='"+referer+"';</script>");
//				printWriter.print("<script>window.open('/board/login/form.do');location.href='"+referer+"';</script>");
//
//				printWriter.flush();
//				printWriter.close();
//				
//				return false;
//			}
//		}
//	}
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String servletPath = request.getServletPath();
		String serverName = request.getServerName();
		StringBuffer requestURL = request.getRequestURL();
		String referer = request.getHeader("Referer");
		
		if(session.getAttribute("boardSessionId") != null) {
			return true;
		}else {
			PrintWriter printWriter = response.getWriter();
			
			//printWriter.print("<script>window.open('/board/login/form.do');location.href='"+referer+"';</script>");
			printWriter.print("<script>window.open('/board/login');location.href='"+referer+"';</script>");

			printWriter.flush();
			printWriter.close();
			
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {	
	}
	
//	private boolean chkExcludeMappingPath(String servletPath) {
//		HashSet<String> excludeMappingPath = getExcludeMappingPath();
//		Iterator<String> iterator = excludeMappingPath.iterator();
//		
//		//System.out.println("servletPath : " + servletPath);
//		while(iterator.hasNext()) {
//			String excludePath = iterator.next();
//			//System.out.println("excludePath : " + excludePath);
//			
//			//if(servletPath.indexOf(excludePath) > -1) {
//			if(excludePath.indexOf(servletPath) > -1) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	private HashSet<String> getExcludeMappingPath() {
//		return setExcludeMappingPath();
//	}
//	
//	private HashSet<String> setExcludeMappingPath() {
//		HashSet<String> excludeMappingPath = new HashSet<String>();
//		excludeMappingPath.add("/login");
//		excludeMappingPath.add("/main");
//		excludeMappingPath.add("/boards");
//		excludeMappingPath.add("/board/detail.do");
//		excludeMappingPath.add("/board/detail.do");
//		
//		return excludeMappingPath;
//	}

}

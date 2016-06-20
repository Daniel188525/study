package com.siebre.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	protected final Log log = LogFactory.getLog(getClass());
	
	protected static final String loginUrl = "index.jsp";
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		if (request.getServletPath().startsWith(loginUrl)) {
			return true;
		}
		
		//3������û��Ѿ���¼ ����    
	    if(request.getSession().getAttribute("username") != null) {  
	        //���õ�ʵ�ַ�ʽ��ʹ��cookie  
	        return true;  
	    }
		
	    //4���Ƿ����� ����Щ������Ҫ��¼����ܷ���  
	    //�ض��򵽵�¼ҳ��  
	    response.sendRedirect(request.getContextPath() + loginUrl);
		return false;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}

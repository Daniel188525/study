package com.siebre.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AllHandlerInterceptor implements HandlerInterceptor {

	protected final Log log = LogFactory.getLog(getClass());
	
	private NamedThreadLocal<Long>  startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");
	
	/**
	 * return fasleʱ--�����������������������������
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		long beginTime = System.currentTimeMillis();//1����ʼʱ��  
        startTimeThreadLocal.set(beginTime);//�̰߳󶨱�����������ֻ�е�ǰ������߳̿ɼ���
		log.debug("AllHandlerInterceptor-preHandle......hanlerName is " + handler.getClass().getName());
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.debug("AllHandlerInterceptor-postHandle......hanlerName is " + handler.getClass().getName());
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long endTime = System.currentTimeMillis();//2������ʱ��  
        long beginTime = startTimeThreadLocal.get();//�õ��̰߳󶨵ľֲ���������ʼʱ�䣩  
        long consumeTime = endTime - beginTime;//3�����ĵ�ʱ��  
        if(consumeTime > 500) {//�˴���Ϊ����ʱ�䳬��500���������Ϊ������  
            //TODO ��¼����־�ļ�  
        	log.debug(String.format("%s consume %d millis", request.getRequestURI(), consumeTime));  
        }
		log.debug("AllHandlerInterceptor-afterCompletion......hanlerName is " + handler.getClass().getName());
	}

}

package com.siebre.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class AllRequestInterceptor implements WebRequestInterceptor {

	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * ������ʵvoid,ͨ��������Դ��׼������
	 */
	public void preHandle(WebRequest request) throws Exception {
		log.debug("AllRequestInterceptor-preHandle......");
	}

	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		log.debug("AllRequestInterceptor-postHandle......");
	}

	/**
	 * ��Դ���ͷŲ���
	 */
	public void afterCompletion(WebRequest request, Exception ex)
			throws Exception {
		log.debug("AllRequestInterceptor-afterCompletion......");
	}

}

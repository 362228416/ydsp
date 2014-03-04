package com.ydsp.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * SpringContext 辅助类
 * @author john
 * @version 1.0 2013-10-15 下午1:27:02
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

	static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		SpringContextUtils.context = context;
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	} 

}


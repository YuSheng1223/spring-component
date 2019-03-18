package com.ly.integration.Test;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import com.ly.integration.producer.SendMessageService;

public class Test {
	public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		ApplicationContext ioc = new ClassPathXmlApplicationContext("application-activemq.xml");
		
		SendMessageService service = ioc.getBean(SendMessageService.class);
		
		service.recordLogs();
	}
}

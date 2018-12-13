package com.yusheng.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusheng.timer.TimerTask;

public class TestMethod {
	
	
	public static void main(String[] args) {
		
		ApplicationContext  ac = new ClassPathXmlApplicationContext("classpath:/*.xml");

		
		
	}
}

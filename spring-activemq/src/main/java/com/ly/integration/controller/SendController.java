package com.ly.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ly.integration.producer.SendMessageService;

@Controller
public class SendController {
	
	@Autowired
	SendMessageService sendMessageService;
	
	
	@RequestMapping(value = "/sendMessage",method=RequestMethod.GET)
	public void sendMessage() {
		sendMessageService.recordLogs();
	}
	
}

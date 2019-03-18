package com.ly.integration.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
@Service
public class SendMessageServiceImpl implements SendMessageService{
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	ActiveMQQueue queueDestination;

	public void recordLogs() {
		
		jmsTemplate.send(queueDestination, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				System.out.println("生产者发送消息-----------------------");
				return session.createTextMessage("--------海上月是天上月-------");
			}
			
		});
	}
	
	
	
	
}

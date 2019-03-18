package com.ly.induction.consumer;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/***
 * 队列模式消费者
 * 
 * @author XuSheng
 *
 */
public class ActiveMQQueueConsumer {

	public static void main(String[] args) throws JMSException, IOException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.209.128:61616");

		Connection connection = connectionFactory.createConnection();

		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Queue queue = session.createQueue("messageQueue");

		MessageConsumer consumer = session.createConsumer(queue);

		consumer.setMessageListener(new MessageListener() {

			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println(textMessage.getText());
					System.out.println("--------------ActiveMQ消费者通过队列模式接收到消息了-----------");
				} catch (JMSException e) {
					
					e.printStackTrace();
				}

			}

		});
		
		System.in.read();
		
		consumer.close();
		
		session.close();
		
		connection.close();
		
		
	}

}

package com.ly.induction.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;



/***
 * ActiveMQ 生产者
 * @author XuSheng
 *
 */
public class ActiveMQQueueProducer {
	
	public static void main(String[] args) throws JMSException {
		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;
		
		try {		
			//连接工厂
			ConnectionFactory  connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.209.128:61616");
			//获取连接
			connection = connectionFactory.createConnection();
			//开启连接
			connection.start();
			//建立会话,第一个参数是否开启事务,为true时,最后需要session.conmit()的提交
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//创建队列
			Queue queue = session.createQueue("messageQueue");
			//创建一个消息生产者
			producer = session.createProducer(queue);
			//创建一个消息对象
			TextMessage message = session.createTextMessage("---------ActiveMQ生产者通过队列模式产生消息了------------");
			//发送消息
			producer.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------发生异常-----------");
		}finally {
			try {
				//关闭各种连接
				producer.close();
				
				session.close();
				
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("--------各个连接关闭完成-----------");
			}

		}
		

	}
}

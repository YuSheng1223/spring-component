package com.ly.integration.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/***
 * 消费者监听类
 * @author XuSheng
 *
 *基于java的多实现特性  完成可以用service逻辑层去实现MessageListener 接口
 */
public class MyMessageListener implements MessageListener{
	
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage)message;
		try {
			/*******************切入service逻辑*********************/
			String text = textMessage.getText();
			System.out.print("消费者接收到消息:-----------------------》"+text);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}

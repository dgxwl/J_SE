package jms;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息服务中间件
 * 发布订阅模式 - 消息消费者示例
 *
 */
public class TopicConsumer {
	public static void main(String[] args) {
		try {
			//创建连接工厂
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			//获取连接
			Connection connection = connectionFactory.createConnection();
			//启动连接
			connection.start();
			/*
			 * Session createSession(boolean arg0, int arg1)
			 * 获取session会话对象
			 * 参数1: 是否启动事务
			 * 参数2: 消息确认模式, AUTO_ACKNOWLEDGE自动确认
			 */
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//根据名称获取主题对象
			Topic topic = session.createTopic("learn_topic");
			//创建消息消费者者并指定订阅的主题
			MessageConsumer consumer = session.createConsumer(topic);
			//监听消息并实现消息获取后的处理逻辑
			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					try {
						TextMessage textMessage = (TextMessage) message;
						String messageText = textMessage.getText();
						System.out.println("获取到的生产者消息: " + messageText);
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
			
			//阻塞程序以保持消费者在线,这样才能获取到消息
			System.in.read();
			
			//关闭资源
			consumer.close();
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

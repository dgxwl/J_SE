package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息服务中间件
 * 发布订阅模式 - 消息生产者示例
 */
public class TopicProducer {
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
			//创建主题对象并指定名称
			Topic topic = session.createTopic("learn_topic");
			//创建消息生产者并指定主题
			MessageProducer producer = session.createProducer(topic);
			//创建消息(以文本消息为例)
			TextMessage message = session.createTextMessage("傍晚过后,大雨停歇");
			//发送消息
			producer.send(message);
			System.out.println("消息发送完毕.");
			
			//关闭资源
			producer.close();
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}

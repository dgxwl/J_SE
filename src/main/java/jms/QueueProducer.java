package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息服务中间件
 * 点对点模式 - 消息生产者示例
 *
 */
public class QueueProducer {
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
			//创建队列对象并指定名称
			Queue queue = session.createQueue("learn_queue");
			//创建消息生产者并指定存放队列
			MessageProducer producer = session.createProducer(queue);
			//创建消息(以文本消息为例)
			TextMessage message = session.createTextMessage("回忆的角落里,你在微笑");
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

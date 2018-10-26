package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类 发送方需要开放POP3/SMTP服务
 * 引入依赖: 
		<dependency>
		    <groupId>com.sun.mail</groupId>
		    <artifactId>javax.mail</artifactId>
		    <version>1.6.2</version>
		</dependency>
 */
public class MailUtil {
	
	private MailUtil() {
	}

	public static void sendTextMail(String host, String senderUsername, String senderPassword, String senderEmail,
			String receiverEmail, String subject, String content) throws MessagingException {
		Properties prop = new Properties();
		prop.setProperty("mail.host", host);
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");

		//1.创建session
		Session session = Session.getInstance(prop);
		//开启Session的debug模式,可在控制台查看程序发送Email的运行状态
//		session.setDebug(true);
		//2.通过session得到transport对象
		Transport transport = session.getTransport();
		/*
		 * 3.使用邮箱的用户名和密码连上邮件服务器;
		 * 发送邮件时,发件人需要提交邮箱的用户名和密码给smtp服务器,
		 * 用户名和密码都通过验证之后才能够正常发送邮件给收件人.
		 */
		transport.connect(host, senderUsername, senderPassword);
		//4.创建邮件
		//创建邮件对象
		MimeMessage message = new MimeMessage(session);
		//发件邮箱
		message.setFrom(new InternetAddress(senderEmail));
		//收件邮箱
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
		//标题
		message.setSubject(subject);
		//正文
		message.setContent(content, "text/html;charset=UTF-8");
		// 5.发送邮件
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
}

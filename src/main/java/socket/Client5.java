package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 聊天室客户端
 * 
 * java.net.Socket
 * 
 * 本次改动，消息发送给服务端和从服务端读取消息应当
 * 放在不同的线程中完成操作。
 * 专门定义一个线程用来并发读取服务端发送过来的消息
 * 
 * @author JAVA
 *
 */
public class Client5 {
	//基于TCP协议通讯的API：Socket
	private Socket socket;
	
	/**
	 * 用来初始化客户端
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public Client5() throws UnknownHostException, IOException {
		System.out.println("正在连接服务端...");
		/*
		 * 实例化Socket时通常需要传入两个参数
		 * 参数1：字符串类型，表示服务端的地址
		 * 参数2：整数类型，表示服务端的服务端口
		 * 我们是通过IP地址找到服务端的计算机，通过
		 * 端口找到运行在服务端计算机上的服务端应用程序。
		 * 实例化Socket的过程就是发起连接的过程。若
		 * 服务端没有响应会抛出异常。
		 */
		socket = new Socket(
			"localhost",  //服务端的IP地址			176.148.2.249
			 8088);  //服务端的端口号
		System.out.println("已连接服务端!");
	}
	
	/**
	 * 客户端开始工作的方法
	 * @throws IOException 
	 */
	public void start() {
		//将ServerHandler启动
		Runnable handler = new ServerHandler();
		Thread t = new Thread(handler);
		t.start();
		
		
		/*
		 * 客户端向服务端发送数据
		 * 
		 * Socket提供方法：
		 * OutputStream getOutputStream()
		 * 该方法可以获取一个字节输出流，通过这个流
		 * 写出的数据会发送至远端计算机，这里相当于
		 * 发送给了服务端。
		 */
		try (Scanner scan = new Scanner(System.in);) {
			/*
			 * 如果只发送字符串数据，也可以使用字符流来完成.
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
			PrintWriter pw = new PrintWriter(osw, true);
			
			while (true) {
				String line = scan.nextLine();
				pw.println(line);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Client5 client = new Client5();
			client.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 该线程负责读取服务端发送过来的消息并输出到控制台
	 * @author JAVA
	 *
	 */
	private class ServerHandler implements Runnable {
		@Override
		public void run() {
			try {
				/*
				 * 通过Socket获取输入流，读取服务端
				 * 发送过来的数据
				 */
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while ((message = br.readLine()) != null) {
					System.out.println(message);
				}
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端
 * 
 * 本次改动为使多线程（若干ClientHandler）操作同一个
 * 集合(allOut)变为线程安全的。
 * @author JAVA
 *
 */
public class Server6 {
	/*
	 * 运行在服务端的java.net.ServerSocket
	 * 作用有两个：
	 * 1：向系统申请服务端口
	 * 	 客户端就是通过这个端口与服务端建立连接的
	 * 2：监听该服务端口，一旦客户端通过该端口请求连接
	 *  则会创建一个Socket与该客户端通讯。
	 */
	private ServerSocket server;
	/*
	 * 用于存放所有客户端的输出流
	 */
	private List<PrintWriter> allOut = new ArrayList<PrintWriter>();
	
	/**
	 * 构造方法，用来初始化服务端
	 * @throws IOException 
	 */
	public Server6() throws IOException {
		/*
		 * 初始化ServerSocket的同时指定服务端口
		 * 需要注意，申请的端口不能与操作系统中
		 * 其他运行的应用程序申请的端口一致，否则会
		 * 抛出端口被占用的异常
		 */
		System.out.println("正在初始化服务端...");
		server = new ServerSocket(8088);
		System.out.println("服务端初始化完毕!");
	}
	/**
	 * 服务端开始工作的方法
	 * @throws IOException 
	 */
	public void start() {
		/*
		 * 等待客户端的连接
		 * 
		 * ServerSocket提供了一个等待客户端连接的方法：
		 * Socket accept()
		 * 该方法是一个“阻塞方法”，调用该方法后，程序不再
		 * 向下继续执行代码，看起来像是“卡住了”。直到一个
		 * 客户端通过ServerSocket申请的服务端口请求连接后
		 * 这个方法才会执行完毕并返回一个Socket实例，通过
		 * 这个Socket可以与连接的客户端进行交互。
		 */
		try {
			while (true) {
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				/*
				 * 当一个客户端连接后启动一个线程来负责
				 * 与该客户端交互
				 */
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Server6 server = new Server6();
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 该线程负责与指定客户端交互
	 * @author JAVA
	 *
	 */
	private class ClientHandler implements Runnable {
		//当前线程通过这个Socket与该客户端交互
		private Socket socket;
		private String host;//客户端地址信息
		
		public ClientHandler(Socket socket) {
			this.socket = socket;
			//获取远端计算机地址信息
			InetAddress address = socket.getInetAddress();
			//获取远端计算机IP地址的字符串格式
			host = address.getHostAddress();
		}
		
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
				pw = new PrintWriter(osw, true);
				/*
				 * 将该输出流存入共享集合
				 */
				synchronized (allOut) {
					allOut.add(pw);
				}
				System.out.println("当前在线人数：" + allOut.size());
				
				String message = null;
				while ((message = br.readLine()) != null) {
					System.out.println(host + "说: " + message);
//					pw.println(message);
					/*
					 * 转发给所有客户端
					 */
					synchronized (allOut) {
						for (PrintWriter p : allOut) {
							p.println(host + "说: " + message);
						}
					}
				}
			} catch (Exception e) {
//				e.printStackTrace();
			} finally {
				//处理客户端断开连接后的操作
				System.out.println("一个客户端下线了!");
				//1.将该客户端的输出流从共享数组中删除
				//将pw从数组中删除
				synchronized (allOut) {
					allOut.remove(pw);
				}
				
				System.out.println("当前在线人数：" + allOut.size());
				
				try {
					/*
					 * 当客户端断开连接后，关闭socket
					 * 释放服务端资源
					 * Socket关闭后，通过Socket获取的输入流
					 * 与输出流就关闭了
					 */
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室服务端
 * @author JAVA
 *
 */
public class Server {
	/*
	 * 运行在服务端的java.net.ServerSocket
	 * 作用有两个：
	 * 1：向系统申请服务端口
	 * 	 客户端就是通过这个端口与服务端建立连接的
	 * 2：监听该服务端口，一旦客户端通过该端口请求连接
	 *  则会创建一个Socket与该客户端通讯。
	 */
	private ServerSocket server;
	/**
	 * 构造方法，用来初始化服务端
	 * @throws IOException 
	 */
	public Server() throws IOException {
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
			System.out.println("等待客户端连接...");
			Socket socket = server.accept();
			System.out.println("一个客户端连接了!");
			
			/*
			 * 读取客户端发送过来的数据
			 * Socket提供的方法：
			 * InputStream getInputStream()
			 * 该方法会获取一个字节输入流，通过这个流可以
			 * 读取到远端计算机发送改过来的数据
			 */
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
//		int d = in.read();
//		System.out.println(d); //1
//		int len = in.read();
//		byte[] data = new byte[len];
//		in.read(data);
//		String str = new String(data, "utf-8");
//		System.out.println("客户端说：" + str);
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
			PrintWriter ps = new PrintWriter(osw, true);
			
			Scanner scan = new Scanner(System.in);
			String message = null;
			while ((message = br.readLine()) != null) {
				System.out.println("客户端说：" + message);
				ps.println(scan.nextLine());
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

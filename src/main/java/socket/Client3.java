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
 * @author JAVA
 *
 */
public class Client3 {
	//基于TCP协议通讯的API：Socket
	private Socket socket;
	
	/**
	 * 用来初始化客户端
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public Client3() throws UnknownHostException, IOException {
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
		Scanner scan = new Scanner(System.in);
		/*
		 * 客户端向服务端发送数据
		 * 
		 * Socket提供方法：
		 * OutputStream getOutputStream()
		 * 该方法可以获取一个字节输出流，通过这个流
		 * 写出的数据会发送至远端计算机，这里相当于
		 * 发送给了服务端。
		 */
		try {
			
			
//		out.write(1);  //发送一个字节
			
//		String str = "你好!大家好！blablabalaba";
//		byte[] data = str.getBytes("utf-8");
//		out.write(data.length);
//		out.write(data);
			/*
			 * 如果只发送字符串数据，也可以使用字符流来完成.
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
			PrintWriter pw = new PrintWriter(osw, true);
			
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			String message = null;
			while (true) {
				String line = scan.nextLine();
				pw.println(line);
				message = br.readLine();
				System.out.println("服务端说：" + message);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			Client3 client = new Client3();
			client.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
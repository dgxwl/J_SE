package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Util {
	private Base64Util() {
	}

	/**
	 * 图片编码为base64;
	 * 例: 在html中, <img src="data:image/jpeg;base64,[base编码放这里]">,
	 * 可节省一次获取图片的请求, 但浏览器不会缓存此图片.
	 * @param imgFilePath 图片路径
	 * @return base64编码字符串
	 * @throws IOException 
	 */
	public static String imageToBase64(String imgFilePath) throws IOException {
		InputStream in = new FileInputStream(imgFilePath);
		return imageToBase64(in);
	}
	
	/**
	 * 图片编码为base64;
	 * 例: 在html中, <img src="data:image/jpeg;base64,[base编码放这里]">,
	 * 可节省一次获取图片的请求, 但浏览器不会缓存此图片.
	 * @param in 图片输入流
	 * @return base64编码字符串
	 * @throws IOException
	 */
	public static String imageToBase64(InputStream in) throws IOException {
		byte[] data = new byte[in.available()];
		in.read(data);
		Encoder encoder = Base64.getEncoder();
		if (data.length > 0) {
			// 编码
			return new String(encoder.encode(data));
		} else {
			throw new RuntimeException("没有图片数据");
		}
	}
	
	/**
	 * base64解码并保存图片到指定路径
	 * @param base64Str 编码字符串
	 * @param imgFilePath 图片保存路径
	 * @return 保存成功true, 或没有图片数据可保存false
	 * @throws IOException 
	 */
	public static void base64ToImage(String base64Str, String imgFilePath) throws IOException {
		// 对字节数组字符串进行Base64解码并生成图片
		if (base64Str == null || base64Str.isEmpty())
			throw new RuntimeException("没有图片数据");
		Decoder decoder = Base64.getDecoder();
		OutputStream out = new FileOutputStream(imgFilePath);
		// 解码
		byte[] b = decoder.decode(base64Str);
		out.write(b);
		out.flush();
		out.close();
	}
	
}

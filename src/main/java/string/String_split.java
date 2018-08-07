package string;

/**
 * 字符串支持正则表达式方法而二：
 * String[] split(String regex)
 * 将当前字符串按照满足正则表达式的部分进行拆分，将
 * 拆分后的所有部分放入一个字符串数组后返回
 * @author JAVA
 *
 */
public class String_split {

	public static void main(String[] args) {
		String str = "aaa123bbb456ccc789ddd";
		
		String[] data = str.split("[a-z]+");
		System.out.println(data.length);
		for (int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
		
		String line = "GET /index.html HTTP/1.1";
		data = line.split("\\s");
		for (int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
		/*
		 *图片重命名 
		 */
		String imageName = "abc.jpg";
		data = imageName.split("\\.");
		imageName = System.currentTimeMillis() + "." + data[data.length-1];
		System.out.println(imageName);
	}

}

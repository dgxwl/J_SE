package string;
/**
 * 字符串支持正则表达式方法三：
 * String replaceAll(String regex, String str)
 * 将当前字符串中满足正则表达式的部分替换为给定字符串
 * @author JAVA
 *
 */
public class String_replaceAll {

	public static void main(String[] args) {
		String str = "aaa123bbb456ccc789ddd";
		/*
		 * 将字符串中的数字部分替换为字符串"#NUMBER#"
		 */
		str = str.replaceAll("[0-9]+", "#NUMBER#");
		System.out.println(str);
		
		String line = "hello world think in java  !! !";
		line = line.replaceAll("\\s+", "");
		System.out.println(line);
	}

}

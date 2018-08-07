package string;

import java.util.Scanner;

/**
 * 字符串支持正则表达式的相关方法：
 * boolean match(String regex)
 * 使用给定的正则表达式验证当前字符串是否满足该格式要求
 * 满足则方法返回true
 * 需要注意，该正则表达式就算不定义边界符匹配(^$)也是做
 * 全匹配验证
 * @author JAVA
 *
 */
public class String_match {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入邮箱地址：");
		String mail = scan.next();
		/*
		 * email的正则表达式：
		 * \w+@\w+(\.[a-zA-Z]+)+
		 */
		String regex = "\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean match = mail.matches(regex);
		if (match) {
			System.out.println("是邮箱");
		}
		else {
			System.out.println("不是邮箱");
		}
		scan.close();
	}

}

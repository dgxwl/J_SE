package string;

import java.util.Scanner;

public class StringHomework {

	public static void main(String[] args) {
		String str = "HelloWorld";
		System.out.println(str.length());
		System.out.println(str.indexOf("o"));
		System.out.println(str.indexOf("o", 5));
		System.out.println(str.substring(str.indexOf('H'), str.indexOf('o')+1));
		System.out.println(str.substring(str.indexOf('W'), str.indexOf('d')+1));
		str = "  Hello   ";
		System.out.println(str.trim());
		str = "HelloWorld";
		System.out.println(str.charAt(5));
		System.out.println("是否是以\"h\"开头：" + str.startsWith("h") 
						+ '\n' + "是否是以\"ld\"结尾：" + str.endsWith("ld"));
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
		StringBuilder builder = new StringBuilder("大家好!");
		System.out.println(builder);
		builder.append("我是程序员!");
		System.out.println(builder);
		builder.insert(6, "优秀的");
		System.out.println(builder);
		builder.replace(6, 8, "牛牛");
		System.out.println(builder);
		builder.delete(0, 4);
		System.out.println(builder);
		
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		if (input.matches("\\d+")) {
			System.out.println("是整数，乘10后：" + Integer.parseInt(input)*10);
		} else if (input.matches("\\d+\\.\\d+")) {
			System.out.println("是小数，乘5后：" + Double.parseDouble(input)*5);
		}
		else {
			System.out.println("毋系数字!");
		}
		
		str = "123,456,789,012";
		String[] data = str.split(",");
		System.out.println(data.length);
		for (String s:data) {
			System.out.println(s);
		}
		
		str = "123abc456def789ghi";
		str = str.replaceAll("[a-z]+", "#char#");
		System.out.println(str);
	}

}

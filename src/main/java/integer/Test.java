package integer;

import java.util.Scanner;

/**
 * 程序启动后要求用户输入一个计算表达式：
 * 如：1+1
 * 然后程序计算结果输出：1+1=2
 * @author JAVA
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个计算表达式");
		String str = scan.next();
		//符号的位置
		int index = -1;
		if ((index = str.indexOf("+")) >= 0) {
			int a = Integer.parseInt(
					str.substring(0, index)
			);
			int b = Integer.parseInt(
					str.substring(index+1)
			);
			int sum = a + b;
			System.out.println(str + "=" + sum);
		}
		
//		String[] data = str.split("\\+");
//		int sum = 0;
//		for (int i = 0; i < data.length; i++) {
//			sum += Integer.parseInt(data[i]);
//		}
//		System.out.println(str + "=" + sum);
	}

}

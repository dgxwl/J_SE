package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 课堂练习
 * 程序启动后要求用户输入自己的生日,格式如:1995-05-31
 * 经过程序计算,输出:到今天为止,一共活了X天.
 * 您出生10000天的纪念日为:xxxx-xx-xx
 * @author JAVA
 *
 */
public class Test {
	public static void main(String[] args) {
		try (
				Scanner scan = new Scanner(System.in);
		){
			System.out.println("请输入您的生日:");
			String birthStr = scan.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = sdf.parse(birthStr);
			long time = System.currentTimeMillis() - birthday.getTime();
			System.out.println("到今天为止,一共活了" + time/1000/60/60/24 + "天.");
			
			long tenThousandDay = 10000L*24*60*60*1000;
			Date anniversary = new Date(birthday.getTime() + tenThousandDay);
			String anniversaryStr = sdf.format(anniversary);
			System.out.println("您出生10000天的纪念日为:" + anniversaryStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

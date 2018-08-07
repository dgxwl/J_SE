package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算商品促销日期
 * 促销日期为该商品过期日前两周的周三
 * 
 * 程序启动后要求用户输入生产日期,如:2017-11-25
 * 在要求用户输入一个保质期的天数,如:30
 * 经过程序计算输出该商品的促销日,格式同生产日期.
 * @author JAVA
 *
 */
public class Test2 {
	public static void main(String[] args) {
		try (
				Scanner scan = new Scanner(System.in);
		){
			Calendar calendar = Calendar.getInstance();
			
			System.out.println("请输入生产日期:");
			String produceDate = scan.nextLine();
			System.out.println("请输入保质期天数:");
			int qualityDay = scan.nextInt();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(produceDate);
			
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_YEAR, qualityDay);
			calendar.add(Calendar.DAY_OF_YEAR, -14);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			date = calendar.getTime();
			String promotionDay = sdf.format(date);
			System.out.println("该商品的促销日:" + promotionDay);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

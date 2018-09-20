package date;

import java.util.Calendar;

/**
 * Calendar提供了一个方法:
 * int get(int field)
 * 该方法可以获取给定的时间分量所对应的值.
 * 
 * 时间分量是用一个int值表示.这些值都被定义在Calendar的常量中.
 * 
 * @author JAVA
 *
 */
public class Calendar_get {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		//获取年
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = calendar.get(Calendar.MONTH)+1;
		System.out.println(month);
		
		/*
		 * 和"天"相关的时间分量有:
		 * DAY_OF_MONTH:月中的天
		 * DAY_OF_WEEK:周中的天
		 * DAY_OF_YEAR:年中的天
		 * DATE:月中的天,与DAY_OF_MONTH是一样的.
		 */
//		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day = calendar.get(Calendar.DATE);
		System.out.println(day);
		
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int m = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		System.out.println(year + "-" + month + "-" + day + " " + h + ":" + m + ":" + s);
		
		int doy = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("今天是今年的第" + doy + "天");
		
		//获取周几
		int dow = calendar.get(Calendar.DAY_OF_WEEK)-1;
		String[] data = {"日", "一", "二", "三", "四", "五", "六"};
		System.out.println("今天是周" + data[dow]);
		
		int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("当月共" + max + "天");
		
		max = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println("今年共" + max + "天");
	}
}

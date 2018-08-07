package date;

import java.util.Calendar;

/**
 * void set(int field, int value)
 * 设置指定时间分量所对应的值
 * @author JAVA
 *
 */
public class Calendar_set {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.YEAR, 2008);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_MONTH, 8);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.MINUTE, 8);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.SECOND, 8);
		System.out.println(calendar.getTime());
	}
}

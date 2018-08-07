package date;

import java.util.Calendar;

/**
 * void add(int field, int amount)
 * 对指定时间分量加上给定的值
 * 若给定的值为负数,则是减去给定的值
 * @author JAVA
 *
 */
public class Calendar_add {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		/*
		 * 查看3年2个月零28天以后是哪天?
		 */
		calendar.add(Calendar.YEAR, 3);
		System.out.println(calendar.getTime());
		
		calendar.add(Calendar.MONTH, 2);
		System.out.println(calendar.getTime());
		
		calendar.add(Calendar.DAY_OF_YEAR, 28);
		System.out.println(calendar.getTime());
		
		/*
		 * 查看那天的前两周一是哪天?
		 */
		calendar.add(Calendar.DAY_OF_YEAR, -14);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println(calendar.getTime());
	}
}

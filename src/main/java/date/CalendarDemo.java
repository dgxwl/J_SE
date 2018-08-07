package date;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar	日历
 * Calendar是用来操作时间的API,Date大部分操作时间的方法都被Calendar代替了.
 * Calendar本身是一个抽象类,定义了操作时间的相关方法,也定义了一个静态方法:
 * Calendar getInstance()
 * 该方法可以获取一个当前系统所在地区适用的实现类.
 * 
 * 大部分地区获取的都是java.util.GregorianCalendar,即阳历
 * 
 * @author JAVA
 *
 */
public class CalendarDemo {
	public static void main(String[] args) {
		/*
		 * 默认创建的Calendar表示当前系统时间.
		 */
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		
		/*
		 * Calendar提供了与Date互转的方法
		 * Date getTime()
		 * 返回一个Date对象,该对象表示的就是当前Calendar所表示的日期
		 * 
		 * void setTime(Date date)
		 * 使当前Calendar表示给定的Date对象所表示的日期
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
		//使Calendar表示给定的Date对象所表示的日期
		calendar.setTime(date);
	}
}

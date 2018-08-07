package date;

import java.util.Date;

/**
 * java.util.Date
 * Date的每一个实例用于表示一个确切的时间点.
 * 内部维护一个long值,该值时自1970年1月1日 0点0分0秒
 * 至当前Date所表示的时间之间所经过的毫秒值.
 * 由于Date在设计之初存在未国际化以及千年虫问题,所以
 * 大部分的方法在JDK1.1时就声明为过时的不再使用.
 * @author JAVA
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		/*
		 * 默认创建的Date表示当前系统时间
		 */
		Date date = new Date();
		System.out.println(date);
		/*
		 * 获取Date内部维护的毫秒
		 */
		long time = date.getTime();
		System.out.println(time);
		
		time += 1000 * 60 * 60 *24;
		/*
		 * 使当前Date表示给定的毫秒值所表示的时间
		 */
		date.setTime(time);
		System.out.println(date);
	}
}

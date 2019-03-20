package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * SimpleDateFormat类是多线程不安全的, 
 * @author Administrator
 *
 */
public class DateTimeFormatter_demo {
	public static void main(String[] args) {
		/* 多线程访问sdf, 会出现时间日期不对或者异常
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (int i = 0; i < 20; i++) {
			new Thread(() -> {
				try {
					System.out.println(sdf.parse("2019-03-20 12:56:34"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}).start();
		}*/
		
		/*
		 * 代替方法1: 使用ThreadLocal类并重写 initialValue() 可确保每个线程获取到的是单独的sdf对象
		 */
		ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>() {
			//重写initialValue()每次获取都返回一个新对象
			@Override
			protected SimpleDateFormat initialValue() {
				return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
		};
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				try {
					System.out.println(tl.get().parse("2019-03-20 12:56:34"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}).start();
		}
		
		System.out.println();
		
		/*
		 * 代替方法2: 使用JDK1.8的DateTimeFormatter代替sdf
		 */
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				System.out.println(dtf.parse("2019-03-20 12:56:34"));
			}).start();
		}
	}
}

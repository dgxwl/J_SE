package date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 可以将一个Date与字符串之间按照指定的日期格式进行相互转换.
 * @author JAVA
 *
 */
public class SimpleDateFormat_format {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		/*
		 * 2018-01-04 10:29:35
		 * yyyy-MM-dd HH:mm:ss
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
		/*
		 * String format(Date date)
		 * 将给定的Date所表示的时间按照当前SDF指定的日期格式转换为对应的字符串.
		 */
		String str = sdf.format(date);
		System.out.println(str);
		
		/*
		 * 如果格式化中的非时间字符是表示时间的字符(如y/M/m/d等, 需要加上单引号转义)
		 */
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
		String str2 = sdf2.format(date);
		System.out.println(str2);
	}
}

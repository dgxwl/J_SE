package date;

import java.util.Calendar;

/**
 * 求2000年至2018年的所有13号星期五
 * @author Administrator
 *
 */
public class Test3_fridayThe13th {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2000, Calendar.JANUARY, 13);

		while (cal.get(Calendar.YEAR) != 2019) {
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
				System.out.println(cal.getTime());
			}
			cal.add(Calendar.MONTH, 1);
		}
	}
}

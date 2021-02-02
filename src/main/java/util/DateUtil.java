package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private DateUtil() {
	}

	public static Date getStartOfDay(Date date) {
		return getStartOfDay(date, Calendar.getInstance());
	}

	public static Date getStartOfDay(Date date, Calendar cal) {
		if (date == null) {
			date = new Date();
		}
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getEndOfDay(Date date) {
		return getEndOfDay(date, Calendar.getInstance());
	}
	
	public static Date getEndOfDay(Date date, Calendar cal) {
		if (date == null) {
			date = new Date();
		}
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	public static Date add(Date date, int field, int amount) {
		return add(date, field, amount, Calendar.getInstance());
	}
	
	public static Date add(Date date, int field, int amount, Calendar cal) {
		if (date == null) {
			date = new Date();
		}
		cal.setTime(date);
		cal.add(field, amount);
		return cal.getTime();
	}

	public static Date addDays(Date date, int amount) {
		return addDays(date, amount, Calendar.getInstance());
	}
	
	public static Date addDays(Date date, int amount, Calendar cal) {
		if (date == null) {
			date = new Date();
		}
		cal.setTime(date);
		cal.add(Calendar.DATE, amount);
		return cal.getTime();
	}

	public static Date getStartOfDayAfterAdding(Date date, int amount) {
		return getStartOfDayAfterAdding(date, amount, Calendar.getInstance());
	}
	
	public static Date getStartOfDayAfterAdding(Date date, int amount, Calendar cal) {
		if (date == null) {
			date = new Date();
		}
		cal.setTime(date);
		cal.add(Calendar.DATE, amount);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getEndOfDayAfterAdding(Date date, int amount) {
		return getEndOfDayAfterAdding(date, amount, Calendar.getInstance());
	}
	
	public static Date getEndOfDayAfterAdding(Date date, int amount, Calendar cal) {
		if (date == null) {
			date = new Date();
		}
		cal.setTime(date);
		cal.add(Calendar.DATE, amount);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	public static Date getStartOfDayAfterAdding(Date date, int field, int amount) {
		return getStartOfDayAfterAdding(date, field, amount, Calendar.getInstance());
	}
	
	public static Date getStartOfDayAfterAdding(Date date, int field, int amount, Calendar cal) {
		if (date == null) {
			date = new Date();
		}
		cal.setTime(date);
		cal.add(field, amount);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getEndOfDayAfterAdding(Date date, int field, int amount) {
		return getEndOfDayAfterAdding(date, field, amount, Calendar.getInstance());
	}
	
	public static Date getEndOfDayAfterAdding(Date date, int field, int amount, Calendar cal) {
		if (date == null) {
			date = new Date();
		}
		cal.setTime(date);
		cal.add(field, amount);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	public static Date getStartOfMonth(Date date) {
		return getStartOfMonth(date, Calendar.getInstance());
	}
	
	public static Date getStartOfMonth(Date date, Calendar cal) {
		if (date == null) {
			date = new Date();
		}
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getEndOfMonth(Date date) {
		return getEndOfMonth(date, Calendar.getInstance());
	}
	
	public static Date getEndOfMonth(Date date, Calendar cal) {
		if (date == null) {
			date = new Date();
		}
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.getMaximum(Calendar.DATE));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	public static String getFormattedDate(Date date) {
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static String getFormattedDate(Date date, String format) {
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date parseDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(date);
	}

	public static Date parseDate(String date, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(date);
	}

	/**
	 * 求两个日期相差天数
	 * @param date1 第一个日期,小的
	 * @param date2 第二个日期,大的
	 * @return 相差天数
	 */
	public int differentDays(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
    }
	
}

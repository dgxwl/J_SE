package designpattern.structrual.adaptor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 新系统里的类
 * @author Administrator
 *
 */
public class Target {
	//新系统里getDate()不再返回Date对象, 而是返回String日期
	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}

package designpattern.adaptor;

import java.util.Date;

/**
 * 旧的系统里的需要被适配的类
 * @author Administrator
 *
 */
public class Adaptee {
	//旧方法: 向客户端提供一个Date对象
	public Date getDate() {
		return new Date();
	}
}

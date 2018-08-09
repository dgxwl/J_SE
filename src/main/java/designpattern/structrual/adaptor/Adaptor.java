package designpattern.structrual.adaptor;

import java.text.SimpleDateFormat;

/**
 * 适配器类: 继承新系统并复合旧系统, 达到新旧兼容
 */
public class Adaptor extends Target {
	Adaptee adaptee = new Adaptee();
	
	@Override
	public String getDate() {
		//编写适配逻辑, 将旧系统返回的类型转换为新系统的, 使新客户端能获取到对应类型数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(adaptee.getDate());
	}
}

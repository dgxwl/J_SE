package uuid;

import java.util.UUID;

/**
 * UUID: 通用唯一识别码(Universally Unique Identifier)
 * 生成全球唯一的标识, 由32位十六进制数组成;
 * UUID组成部分:
 * 1.当前日期和时间;
 * 2.时钟序列;
 * 3.全局唯一的IEEE机器识别号，如果有网卡，从网卡MAC地址获得，没有网卡以其他方式获得.
 * 常用于分布式系统, 也可运用于数据库的主键; 在数据库迁移时防止主键冲突.
 * @author Administrator
 *
 */
public class UUIDdemo {
	public static void main(String[] args) {
		//randomUUID(): 获取一个UUID对象的静态工厂方法
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());;
	}
}

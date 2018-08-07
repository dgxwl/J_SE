package designpattern.adaptor;

public class Client {
	public static void main(String[] args) {
		//新客户端通过适配器获取新系统的类型
		Adaptor adaptor = new Adaptor();
		//新客户端只接收String类型的date, 不能接收旧系统的date类型; 通过适配器实现了兼容
		String date = adaptor.getDate();
		System.out.println(date);
	}
}

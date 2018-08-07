package reflection;

public class Person {
	public void sayHello() {
		System.out.println("大家好!");
	}
	
	public void sayHi() {
		System.out.println("Hi!");
	}
	
	public void sayBye() {
		System.out.println("bye!");
	}
	
	private void say() {
		System.out.println("我是私有方法!");
	}
	
	public void sayHello(String name) {
		System.out.println("你好,"+name);
	}
	
	public void sayHello(String name, int age) {
		System.out.println("你好,"+name + ",您今年"+age+"岁");
	}
}

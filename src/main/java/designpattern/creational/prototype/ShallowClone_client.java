package designpattern.creational.prototype;

/**
 * 这就是设计模式中的原型模式(prototype pattern).
 * 由于Java提供的clone()方法, 使得原型模式的实现非常方便;
 * clone()比new效率更高(分配内存, 把原对象属性复制到新对象);
 * clone()方法只能实现浅表复制, 即对于引用类型属性只复制值, 
 * 复制得到的对象其引用属性和原对象的指向的是同一对象.
 * @author Administrator
 *
 */
public class ShallowClone_client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person(1, new String("zhangsan"));
		Person p2 = p1.clone();
		
		System.out.println(p1==p2);
		System.out.println(p1.getAge() == p2.getAge());
		System.out.println(p1.getName() == p2.getName());
	}
}

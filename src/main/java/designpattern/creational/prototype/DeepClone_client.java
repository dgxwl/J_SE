package designpattern.creational.prototype;

/**
 * 对象的deep clone:
 * 即对象的引用类型属性也复制一份新的(创建新对象), 而不是复制引用;
 * 当引用类型属性内部又包含引用类型属性时, 如果通过重写clone()的方法实现
 * 将会变得麻烦, 这时可以通过序列化的方式进行实现深克隆; 所涉及的所有类
 * 都需要实现Serializable接口.
 * @author Administrator
 *
 */
public class DeepClone_client {

	public static void main(String[] args) {
		Outer outer1 = new Outer(new Inner("the info"));
		System.out.println(outer1);
		Outer outer2 = outer1.myClone();
		System.out.println(outer2);
		System.out.println(outer1 == outer2);
	}
}

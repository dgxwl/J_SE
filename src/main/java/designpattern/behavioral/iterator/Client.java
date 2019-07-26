package designpattern.behavioral.iterator;

/**
 * 迭代器模式(Iterator Pattern).
 * 调用方不需要知道集合对象具体实现就能用统一接口遍历集合元素.
 * Java官方容器都已经实现了.
 *
 */
public class Client {

	public static void main(String[] args) {
		MyCollection<Integer> c = new ConcreteCollection<>();
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		
		for (MyIterator<Integer> iterator = c.iterator(); iterator.hasNext(); ) {
			System.out.println(iterator.next());
		}
	}
}

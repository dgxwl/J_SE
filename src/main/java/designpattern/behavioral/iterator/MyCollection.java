package designpattern.behavioral.iterator;

/**
 * 容器.应含有提供迭代器的方法
 *
 */
public interface MyCollection<T> {

	void add(T element);  //增
	
	void remove(T element);  //删
	
	MyIterator<T> iterator();  //获取遍历元素的迭代器
}

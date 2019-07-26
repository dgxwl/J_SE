package designpattern.behavioral.iterator;

/**
 * 迭代器, 用于访问/遍历集合元素
 * @author Administrator
 *
 */
public interface MyIterator<T> {

	T first();  //获取第一个元素
	
	T next();  //获取下一个元素
	
	boolean hasNext();  //是否还遍历没到末尾
}

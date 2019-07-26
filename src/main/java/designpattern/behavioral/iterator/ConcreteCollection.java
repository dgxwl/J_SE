package designpattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器实现类
 *
 */
public class ConcreteCollection<T> implements MyCollection<T> {
	
	private List<T> list = new ArrayList<>();

	@Override
	public void add(T element) {
		list.add(element);
	}

	@Override
	public void remove(T element) {
		list.remove(element);
	}

	@Override
	public MyIterator<T> iterator() {
		return new ConcreteIterator<T>();
	}

	//实现与当前容器配套的迭代器
	private class ConcreteIterator<Q> implements MyIterator<Q> {
		
		private int cursor = 0;  //游标, 记录遍历到的位置

		@SuppressWarnings("unchecked")
		@Override
		public Q first() {
			return (Q) list.get(0);
		}

		@SuppressWarnings("unchecked")
		@Override
		public Q next() {
			return (Q) list.get(cursor++);
		}

		@Override
		public boolean hasNext() {
			return cursor < list.size();
		}
		
	}
}

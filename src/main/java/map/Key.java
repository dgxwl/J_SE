package map;
/**
 * HashMap是散列表，使用散列算法实现。散列表是当今查询速度
 * 最快的数据结构。
 * 散列表内部使用数组保存Entry。之所以快是因为散列算法根据
 * Key元素的hashcode方法返回的值计算后得出其在数组的下标
 * 位置直接定位该元素，免去了遍历数组查找元素的麻烦从而提高了
 * 查询性能，并且不受元素多少的影响。
 * 
 * 由于作为Key元素的hashcode决定其在Map中的位置，而Map
 * 又根据Key的equals()判断是否是重复的Key。所以这两个方法
 * 在Java文档中有明确的重写规则。
 * 当一个Map中若两个Key的hashcode相同，但是equals()比较
 * 不为true，那么会在HashMap内部数组相同位置处产生链表；
 * 链表会降低散列表查询性能，所以要尽量避免。这就必须遵循
 * equals()与hashcode()重写规则.
 * 
 * API文档中Object里对equals()与hashcode()方法的重写要求：
 * 1:成对重写
 *   即:当需要重写一个类的equals()方法，就应当连同重写hashcode()方法。
 * 2:一致性
 *   即:当两个对象equals()比较为true时，hashcode方法返回的数字
 *     必须相等。反过来不是强制的，但是最好做到两个对象hashcode相等时
 *     equals()比较也为true.
 *     因为两个对象hashcode相等，但是equals()比较不为true时会在
 *     HashMap中出现链表。
 * 3:稳定性
 *   即:在参与equals()比较的属性值没有发生改变的前提下，多次调用
 *   hashcode()方法返回的数字应当不变.
 * @author JAVA
 *
 */
public class Key {
	private int x;
	private int y;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}

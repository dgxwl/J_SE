package bitmap;

import java.util.BitSet;

/**
 * BitSet可进行逻辑运算;
 * 一定程度上可代替SQL的条件筛选,较灵活,避免SQL语句越写越长;
 * 
 * bitmap全部位中比有意义数据的全集还多出一些无意义的位,
 * 取非时会将无意义值包含进去,得到错误的结果,
 * 因此BitSet不支持非运算.
 * @author Administrator
 *
 */
public class BitSetOrAndXor {
	public static void main(String[] args) {
		BitSet b1 = new BitSet();
		b1.set(1);
		b1.set(3);
		b1.set(5);
		//Object clone() 克隆一个bitset为新对象
		BitSet b1Copy = (BitSet) b1.clone();
		System.out.println("b1Copy: " + b1Copy);
		
		BitSet b2 = new BitSet();
		b2.set(2);
		b2.set(5);
		b2.set(6);
		System.out.println();
		
		//与运算(取交集),经过与运算后b1中存的是运算结果,结果去重且有序
		b1.and(b2);
		System.out.println("and: " + b1);  //5
		b1 = (BitSet) b1Copy.clone();
			
		//或运算(取并集)
		b1.or(b2);  //1,2,3,5,6
		System.out.println("or: " + b1);
		b1 = (BitSet) b1Copy.clone();
		
		//与非运算(先做与运算后取反,即排除b1中与b2共有的元素)
		b1.andNot(b2);
		System.out.println("andNot: " + b1);  //1,3
		b1 = (BitSet) b1Copy.clone();
		
		//异或运算(排除共有元素后取并集)
		b1.xor(b2);
		System.out.println("xor: " + b1);
		b1 = (BitSet) b1Copy.clone();
		
		//全集
		BitSet bAll = new BitSet();
		bAll.set(1);
		bAll.set(2);
		bAll.set(3);
		bAll.set(5);
		bAll.set(6);
		//非运算:需要借助全集,将需要取非的bitset与全集做异或运算,即求得取非结果
		b1.xor(bAll);
		System.out.println("not: " + b1);
	}
}

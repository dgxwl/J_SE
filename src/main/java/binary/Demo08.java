package binary;

public class Demo08 {

	public static void main(String[] args) {
		/**
		 * 与运算规则验证
		 * 如下计算可以将c的后6位截取存储到变量k中
		 * 这个截取计算称为: 掩码计算, 其中m称为掩码Mask 
		 */
		int c = 0x597d;//'好'
		int m = 0x3f;
		int k = c&m;
		System.out.println(
				Integer.toBinaryString(c));
		System.out.println(
				Integer.toBinaryString(m));
		System.out.println(
				Integer.toBinaryString(k));
	}

}

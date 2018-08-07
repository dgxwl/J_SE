package binary;

public class Demo10 {

	public static void main(String[] args) {
		/**
		 * >>> 移位计算验证
		 */
		int c = 0x597d;
		int k = c>>>1;
		int m = c>>>2;
		int n = c>>>6;
		//输出 c k m n 的2进制数据
		System.out.println(
				Integer.toBinaryString(c));
		System.out.println(
				Integer.toBinaryString(k));
		System.out.println(
				Integer.toBinaryString(m));
		System.out.println(
				Integer.toBinaryString(n));
	}

}

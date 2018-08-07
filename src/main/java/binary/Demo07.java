package binary;

public class Demo07 {

	public static void main(String[] args) {
		/**
		 * 输出字符的Unicode编码
		 */
		int ch1 = '您';
		int ch2 = '好';
		System.out.println(ch1);
		System.out.println(ch2);
		/**
		 * 输出2进制Unicode编码
		 */
		System.out.println(
				Integer.toBinaryString(ch1));
		System.out.println(
				Integer.toBinaryString(ch2));
	}

}





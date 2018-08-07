package binary;

public class Demo04 {
	public static void main(String[] args) {
		/**
		 * 补码
		 */
		int i = -3;
		System.out.println(
				Integer.toBinaryString(i));
		long l = -1L;
		System.out.println(
				Long.toBinaryString(l)); 
		
		//int max = Integer.MAX_VALUE;
		int max = 0x7fffffff;
		System.out.println(
				Integer.toBinaryString(max));
		System.out.println(max);
		//int min = Integer.MIN_VALUE;
		int min = 0x80000000;
		System.out.println(
				Integer.toBinaryString(min)); 
	}
}











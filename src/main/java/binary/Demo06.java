package binary;

public class Demo06 {

	public static void main(String[] args) {
		/**
		 * 验证 补码的互补对称现象:
		 * -n = ~n+1
		 */
		int n = 5;
		int m = ~n+1;
		System.out.println(m);//-5
		//验证:
		System.out.println(
				Integer.toBinaryString(n));
		System.out.println(
				Integer.toBinaryString(~n));
		System.out.println(
				Integer.toBinaryString(~n+1));
	}

}



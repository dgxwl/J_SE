package binary;

public class Demo01 {

	public static void main(String[] args) {
		/**
		 * 检验变量的2进制情况:
		 */
		int i = 50;//110010
		/*
		 * toBinaryString 方法:
		 * 将i在内存中实际的2进制情况转换为字符串
		 */
		System.out.println(
			Integer.toBinaryString(i));
		
		/**
		 * 输出 0~50全部的内存2进制数据
		 */
		for(i=0; i<=50; i++){
			System.out.println(
					Integer.toBinaryString(i));	
		}
		
	}

}

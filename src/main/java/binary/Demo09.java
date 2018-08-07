package binary;

public class Demo09 {

	public static void main(String[] args) 
		throws Exception {
		/**
		 * 将 '好' 进行UTF-8编码
		 */
		int ch = '好';
		int b3 = ch & 0x3f | 0x80; 
		int b2 = (ch>>>6) & 0x3f | 0x80; 
		int b1 = (ch>>>12) & 0xf | 0xe0;
		System.out.println(
				Integer.toBinaryString(ch));
		System.out.println(
				Integer.toBinaryString(b3));
		System.out.println(
				Integer.toBinaryString(b2));
		System.out.println(
				Integer.toBinaryString(b1));
		//利用Java的API进行解码, 验证 b1 b2 b3
		byte[] bytes = {(byte)b1,(byte)b2,(byte)b3};
		String s = new String(bytes, "UTF-8");
		System.out.println(s); 
		//UTF-8解码
		int c =((b1&0xf)<<12)|((b2&0x3f)<<6)|(b3&0x3f);
		System.out.println((char)c); 
		
		int n = 50;
		n += n>>1;
		System.out.println(n);
	}

}








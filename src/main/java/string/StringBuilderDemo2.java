package string;

public class StringBuilderDemo2 {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("a");
		for (int i=0; i<10000000; i++) {
			builder.append("a");
		}
		System.out.println("运行完了");
//		System.out.println(builder.toString());
	}

}

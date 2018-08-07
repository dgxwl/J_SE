package string;
/**
 * 和谐用语
 * @author JAVA
 *
 */
public class String_replaceAllDemo {

	public static void main(String[] args) {
		String regex = "(mmp|wqnmlgb|sb|nc|mdzz|cnm|djb)";
		String message = "mmp!你个sb!wqnmlgb!你怎么这么的nc";
		message = message.replaceAll(regex, "***");
		System.out.println(message);
	}

}

package staticimport;

//导入World类中的所有常量
import static staticimport.World.*;

/**
 * jdk1.5后可以导入其他类中的常量,大量使用某工具类中的常量时可使用这个机制.
 * import static 完整包名.*;
 * @author Administrator
 *
 */
public class Panel {
	public static void main(String[] args) {
		System.out.println(WIDTH + ", " + HEIGHT);
	}
}

package lombok;

/**
 * 使用lombok自动生成get() set() equals()等方法,
 * 只需在实体类上添加@Data注解即可;
 * 但此时eclipse中点不出这些方法,需要把lombok.jar
 * 放到eclipse根目录下并在命令行执行java -jar lombok.jar安装,
 * 然后clean项目.
 * @author Administrator
 *
 */
public class Demo {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("zhangsan");
		p.setAge(38);
		System.out.println(p.toString());
	}
}

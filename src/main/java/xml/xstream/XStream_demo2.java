package xml.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 使用@XStreamAlias注解对类名或属性名取别名
 * @author Administrator
 *
 */
public class XStream_demo2 {
	public static void main(String[] args) {
		Person2 p = new Person2(1, "hah");
		XStream xStream = new XStream(new DomDriver());
		//XStream默认不读取注解,因此需要声明注解来源的类
		xStream.processAnnotations(Person2.class);
		String xml = xStream.toXML(p);
		System.out.println(xml);
	}
}

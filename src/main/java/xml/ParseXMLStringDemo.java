package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 使用DocumentHelper.parseText()解析xml字符串
 * @author Administrator
 *
 */
public class ParseXMLStringDemo {
	public static void main(String[] args) throws DocumentException {
		Document doc = DocumentHelper.parseText("<student>"
												+ "<name>zhangsan</name>"
												+ "<gender>male</gender>"
												+ "<age>19</age>"
											+ "</student>");
		Element root = doc.getRootElement();
		String name = root.elementText("name");
		String gender = root.elementText("gender");
		String age = root.elementText("age");
		System.out.println("name: " + name + ", gender: " + gender + ", age: " + age);
	}
}

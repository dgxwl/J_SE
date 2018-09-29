package xml.xstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.thoughtworks.xstream.XStream;

/**
 * 使用XStream可以实现Java对象与XML字符串互相转换.
 * @author Administrator
 *
 */
public class XStream_demo1 {

	public static void main(String[] args) {
		Person p1 = new Person(1, "sally");
		XStream xStream = new XStream();
		//设置默认安全防护
		XStream.setupDefaultSecurity(xStream);
		//设置允许的类
		xStream.allowTypes(new Class[]{Person.class});
		//给类的输出节点设置别名
		xStream.alias("root", Person.class);
		//给类的属性输出节点设置别名
		xStream.aliasField("uid", Person.class, "id");
		//调用toXML()将对象转换为XML字符串
		String xmlStr = xStream.toXML(p1);
		System.out.println(xmlStr);
		
		//将XML字符串转换为对象
		Person p2 = (Person) xStream.fromXML(xmlStr);
		//实现了深克隆
		System.out.println(p1);
		System.out.println(p2);
		
		//使用dom4j将XML字符串写出为.xml文件
		Document doc = DocumentHelper.createDocument();
		doc.addElement(xmlStr);
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream("test.xml"), OutputFormat.createPrettyPrint());
			writer.write(doc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(writer != null){
				try {
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}

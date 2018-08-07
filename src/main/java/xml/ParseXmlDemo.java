package xml;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析XML文档
 * @author JAVA
 *
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		/*
		 * 解析emplist.xml文件,将所有的员工信息
		 * 以若干Emp实例形式存入一个集合.
		 * 
		 * 使用DOM解析XML文档的大致步骤:
		 * 1:创建SAXReader
		 * 2:使用SAXReader读取要解析的XML文档并生成
		 *   Document对象
		 * 3:通过Document对象获取根元素
		 * 4:按照XML文档的树结构通过根元素开始逐级获取
		 *   对应的子元素以达到遍历XML文档数据的目的
		 */
		//用于保存所有从XML文档中解析出来的员工信息
		List<Emp> list = new ArrayList<Emp>();
		
		try {
			//1
			SAXReader reader = new SAXReader();
			
			/*
			 * 2 读取xml文档时,SAXReader提供了多个重载
			 * 的read()方法,常用的:
			 * Document read(File file)
			 * Document read(InputStream in)
			 * Document read(Reader reader)
			 */
			Document doc = reader.read(new FileInputStream("emplist.xml"));
			/*
			 * 3获取根元素
			 * Document提供了获取根元素的方法:
			 * Element getRootElement()
			 * 
			 * Element类的每一个实例用于表示XML文档
			 * 中的一个元素(一对标签)
			 * 
			 * Element提供了获取其表示的元素的相关方法:
			 * 
			 * String getName()
			 * 获取当前元素的名字
			 * 
			 * String getText()
			 * 获取当前元素中间的文本信息
			 * 
			 * Element element(String name)
			 * 获取当前元素中指定名字的子元素
			 * 
			 * List elements()
			 * 获取当前元素中所有子元素
			 * 
			 * List elements(String name)
			 * 获取当前元素中所有同名子元素
			 * 
			 * Attribute attribute(String name)
			 * 获取当前元素中指定名字的属性
			 */
			Element root = doc.getRootElement();
			
			//获取根标签<list>下面的所有子标签<emp>
			List<Element> empList = root.elements();
			System.out.println("共有" + empList.size() + "个<emp>标签");
			
			/*
			 * 遍历所有的<emp>标签,将每个元素信息解析出来,
			 * 以若干Emp实例保存并存入list集合
			 */
			for (Element empEle : empList) {
				//获取名字
				Element nameEle = empEle.element("name");
				String name = nameEle.getText();
				System.out.println(name);
				//获取年龄
				Element ageEle = empEle.element("age");
				int age = Integer.parseInt(ageEle.getText());
				System.out.println(age);
				//获取性别
				/*
				 * String elementText(String name)
				 * 该方法时获取当前标签中指定名字子标签中间的文本
				 * 例如:
				 * empEle.elementText("gender")
				 * 等价于
				 * empEle.element("gender").getText()
				 */
				String gender  = empEle.elementText("gender");
				System.out.println(gender);
				//获取工资
				int salary = Integer.parseInt(empEle.elementText("salary"));
				System.out.println(salary);
				
//				Attribute attr = empEle.attribute("id");
//				int id = Integer.parseInt(attr.getValue());
				
				int id = Integer.parseInt(empEle.attributeValue("id"));
				
				Emp emp = new Emp(id, name, age, gender, salary);
				list.add(emp);
			}
			
			System.out.println("解析完毕!");
			for (Emp e : list) {
				System.out.println(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

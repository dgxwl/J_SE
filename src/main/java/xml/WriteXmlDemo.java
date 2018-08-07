package xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 使用DOM写出一个xml文档
 * @author JAVA
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		/*
		 * 写出XML文档的大致步骤:
		 * 1:创建一个Document对象,表示一个空白文档
		 * 2:向Document对象中添加根元素
		 * 3:向根元素中逐级添加子元素以形成XML文档需要
		 *   的树形结构
		 * 4:创建Xmlwriter
		 * 5:通过Xmlwriter将Document写出以形成XML文档
		 */
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(1, "张三", 22, "男", 3000));
		list.add(new Emp(2, "李四", 23, "女", 4000));
		list.add(new Emp(3, "王五", 24, "男", 5000));
		list.add(new Emp(4, "赵六", 25, "女", 6000));
		
		//1
		Document doc = DocumentHelper.createDocument();
		
		/*
		 * 2向文档中添加根元素
		 * Document提供了添加根元素的方法:
		 * Element addElement(String name)
		 * 向当前文档中添加给定名字的根元素,并将其以
		 * Element实例的形式返回,以便对根元素继续操作.
		 * 需要注意,该方法只能调用一次,因为一个文档中
		 * 只能有一个根元素.
		 */
		Element root = doc.addElement("list");
		/*
		 * Element提供了添加相关信息的方法
		 * 
		 * Element addElement(String name)
		 * 向当前标签中添加给定名字的子标签并将其返回
		 * 
		 * Element addText(String text)
		 * 向当前标签中间添加给定文本信息.返回值还是当前标签
		 * 
		 * Element addAttribute(String name, String value)
		 * 向当前标签中添加给定的属性
		 */
		for (Emp e : list) {
			//向根元素中添加<emp>标签
			Element empEle = root.addElement("emp");
			
			//添加name
			Element nameEle = empEle.addElement("name");
			nameEle.addText(e.getName());
			
			Element ageEle = empEle.addElement("age");
			ageEle.addText(e.getAge()+"");
			
			Element genderEle = empEle.addElement("gender");
			genderEle.addText(e.getGender());
			
			Element salaryEle = empEle.addElement("salary");
			salaryEle.addText(e.getSalary()+"");
			
			empEle.addAttribute("id", e.getId()+"");
		}
		
		XMLWriter writer = null;
		try {
			//创建XMLWriter
			writer = new XMLWriter(new FileOutputStream("myemp.xml"), OutputFormat.createPrettyPrint());
			
			writer.write(doc);
			System.out.println("写出完毕!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
}

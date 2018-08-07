package json;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json转为对象
 * @author Administrator
 *
 */
public class JsonToObjectDemo {
	public static void main(String[] args) {
		String json = "{\"name\": \"zhangsan\", \"age\": \"16\"}";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			//使用mapper.readValue()将json字符串转换为对象
			Person p = mapper.readValue(json, Person.class);
			System.out.println(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

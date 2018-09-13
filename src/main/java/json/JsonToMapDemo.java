package json;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 将json字符串转为map
 * @author Administrator
 *
 */
public class JsonToMapDemo {
	public static void main(String[] args) {
		String json = "{\"name\": \"zhangsan\", \"age\": \"16\"}";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			//使用mapper.readValue()将json字符串转换为map
			Map<?, ?> map = mapper.readValue(json, Map.class);
			System.out.println(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

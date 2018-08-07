package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 使用jackson将对象转换为json字符串
 * @author Administrator
 *
 */
public class ObjectToJsonDemo {
	public static void main(String[] args) throws JsonProcessingException {
		Person p = new Person("zhangsan", 23);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(p);
		System.out.println(jsonStr);
	}
}

package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 试下enum类型会转成什么样
 * @author Administrator
 *
 */
public class TestEnum {
	Type type;
	
	public TestEnum(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public static void main(String[] args) throws JsonProcessingException {
		TestEnum testEnum = new TestEnum(Type.type1);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(testEnum);
		System.out.println(jsonStr);
	}
}

enum Type {
	type1, type2
}
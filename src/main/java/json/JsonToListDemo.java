package json;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 将json字符串转为list
 * @author Administrator
 *
 */
public class JsonToListDemo {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "[\"1101\", \"1102\", \"1103\", \"1104\"]";
		
		try {
			List<?> list = mapper.readValue(json, ArrayList.class);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

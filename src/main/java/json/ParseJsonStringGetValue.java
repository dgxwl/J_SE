package json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 使用jackson解析json字符串并获取值
 * @author Administrator
 *
 */
public class ParseJsonStringGetValue {
	public static void main(String[] args) throws JsonProcessingException, IOException {
		String jsonString = "{\"access_token\":\"I AM ACCESS_TOKEN\",\"expires_in\":7200}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonString);
		String accessToken = node.get("access_token").toString();
		int expiresIn = Integer.parseInt(node.get("expires_in").toString());
		System.out.println(accessToken);
		System.out.println(expiresIn);
	}
}

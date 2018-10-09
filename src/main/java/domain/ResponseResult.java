package domain;

import java.util.Collection;
import java.util.Map;

public class ResponseResult {
	private int result = 0;
	private String message;
	private int total;
	private Object data;
	
	public ResponseResult() {
	}

	public ResponseResult(String message) {
		this.message = message;
	}

	public ResponseResult(int result, String message) {
		this.result = result;
		this.message = message;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
		if (data instanceof Collection) {
			Collection<?> c = (Collection<?>) data;
			total = c.size();
		} else if (data instanceof Map) {
			Map<?, ?> m = (Map<?, ?>) data;
			total = m.size();
		}
	}
	
	
}

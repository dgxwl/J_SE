package domain;

public class ResponseResult {
	private int result = 0;
	private String message;
	private int count;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}

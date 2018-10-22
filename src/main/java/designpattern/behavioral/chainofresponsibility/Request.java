package designpattern.behavioral.chainofresponsibility;

import lombok.Data;

/**
 * 请求类
 * @author Administrator
 *
 */
@Data
public class Request {
	private int day;
	private String reason;
	
	public Request(int day, String reason) {
		this.day = day;
		this.reason = reason;
	}
	
}

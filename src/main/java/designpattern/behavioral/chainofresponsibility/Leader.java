package designpattern.behavioral.chainofresponsibility;

import lombok.Data;

/**
 * 处理请求抽象类
 * @author Administrator
 *
 */
@Data
public abstract class Leader {
	protected String name;
	protected Leader successor;
	
	public Leader(String name) {
		this.name = name;
	}
	
	public abstract void processRequest(Request request);
}

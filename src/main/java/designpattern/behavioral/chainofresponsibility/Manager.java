package designpattern.behavioral.chainofresponsibility;

/**
 * 具体处理对象1
 * @author Administrator
 *
 */
public class Manager extends Leader {

	public Manager(String name) {
		super(name);
	}

	@Override
	public void processRequest(Request request) {
		if (request.getDay() <= 0.5) {
			System.out.println(name + " processed the request");
		} else if (successor != null) {
			successor.processRequest(request);
		}
	}
	
}

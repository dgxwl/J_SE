package exception;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 派生类在重写超类含有异常抛出声明的方法时对throws
 * 的重写准则
 * @author JAVA
 *
 */
public class Exception_throws_override {
	public void dosome() throws IOException, AWTException {
		
	}
}

class Son extends Exception_throws_override {
//	@Override
//	public void dosome() throws IOException, AWTException {
//		
//	}
	/**
	 * 允许仅抛出父类方法抛出的部分异常
	 */
//	@Override
//	public void dosome() throws IOException {
//		
//	}
	/**
	 * 允许不再抛出任何异常
	 */
//	@Override
//	public void dosome() {
//		
//	}
	/**
	 * 允许抛出父类方法抛出的异常的子类型异常
	 */
//	@Override
//	public void dosome() throws FileNotFoundException {
//		
//	}
	/**
	 * 不允许抛出额外异常
	 */
//	@Override
//	public void dosome() throws SQLException {
//		
//	}
	
	/**
	 * 不允许抛出父类方法抛出的异常的父类型异常
	 */
//	@Override
//	public void dosome() throws Exception {
//		
//	}
}
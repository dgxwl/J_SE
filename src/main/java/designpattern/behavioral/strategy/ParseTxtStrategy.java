package designpattern.behavioral.strategy;

public class ParseTxtStrategy implements IStrategy {

	@Override
	public void parse(String rawFilePath) {
		System.out.println("解析txt原始数据...");
	}

}

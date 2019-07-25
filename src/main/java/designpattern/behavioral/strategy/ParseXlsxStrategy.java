package designpattern.behavioral.strategy;

public class ParseXlsxStrategy implements IStrategy {

	@Override
	public void parse(String rawFilePath) {
		System.out.println("解析xlsx原始数据...");
	}
}

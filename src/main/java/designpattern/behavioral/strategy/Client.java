package designpattern.behavioral.strategy;

/**
 * 策略模式(strategy pattern)可以使程序在运行时根据需要,选择要执行的算法
 *
 */
public class Client {
	public static void main(String[] args) {
		ParseTxtStrategy txt = new ParseTxtStrategy();
		ParseXlsxStrategy xlsx = new ParseXlsxStrategy();
		
		StrategyContext context = new StrategyContext(txt);
		context.parseRawData("C:/rawData.txt");
		
		context.setStrategy(xlsx);  //更改策略
		context.parseRawData("C:/rawData.xlsx");  //同样调用context.parseRawData(), 但执行算法不同
	}
}

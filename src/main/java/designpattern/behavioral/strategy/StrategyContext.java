package designpattern.behavioral.strategy;

/**
 * 策略模式上下文类,需要执行算法的角色
 *
 */
public class StrategyContext {
	private IStrategy strategy;
	
	public StrategyContext(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void parseRawData(String rawFilePath) {
		strategy.parse(rawFilePath);
	}

	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
}

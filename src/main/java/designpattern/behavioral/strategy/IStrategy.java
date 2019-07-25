package designpattern.behavioral.strategy;

/**
 * 策略算法接口.
 * 所有算法类都实现这个接口
 */
public interface IStrategy {

	void parse(String rawFilePath);
}

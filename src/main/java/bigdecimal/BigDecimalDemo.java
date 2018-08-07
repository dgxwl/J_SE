package bigdecimal;

import java.math.BigDecimal;

/**
 * 使用BigDecimal避免浮点数舍入误差,可用于商业计算.
 * @author Administrator
 *
 */
public class BigDecimalDemo {
	public static void main(String[] args) {
		// 传入double构造,运算仍未避免误差
		BigDecimal b1 = new BigDecimal(1.01);
		BigDecimal b2 = new BigDecimal(2.02);
		// BigDecimal add(BigDecimal augend) 计算两个BigDecimal的和,返回运算结果(新的BigDecimal对象)
		System.out.println(b1.add(b2));

		// 传入String表示的浮点数,可避免误差
		b1 = new BigDecimal("1.01");
		b2 = new BigDecimal("2.02");
		System.out.println(b1.add(b2));

		// BigDecimal subtract(BigDecimal subtrahend) 减法
		System.out.println(b2.subtract(b1));

		// BigDecimal multiply(BigDecimal multiplicand) 乘法
		System.out.println(b1.multiply(b2));

		// BigDecimal divide(BigDecimal divisor) 除法
		System.out.println(b1.divide(b2));

		// BigDecimal negate() 求相反数
		System.out.println(b1.negate());

		// BigDecimal abs() 求绝对值
		System.out.println(b1.abs());

		// BigDecimal pow(int n) 求n次幂
		System.out.println(b1.pow(2));

		// 求两个数中大的值
		System.out.println(b1.max(b2));

		// 求两个数中小的值
		System.out.println(b1.min(b2));

		// int compareTo(BigDecimal val) 比较两个数的大小;返回int值: 1(大于),0(等于),-1(小于)
		System.out.println(b1.compareTo(b2));

		b1 = new BigDecimal("2.4567");
		/*
		 * BigDecimal setScale(int newScale, int roundingMode) 设置精度 newScale:保留小数点后位数;
		 * ROUND_HALF_UP:四舍五入
		 */
		System.out.println(b1.setScale(2, BigDecimal.ROUND_HALF_UP));

		// ROUND_DOWN:向0舍入
		System.out.println(b1.setScale(2, BigDecimal.ROUND_DOWN));

		// ROUND_DOWN:向远离0舍入
		System.out.println(b1.setScale(2, BigDecimal.ROUND_UP));

		// ROUND_DOWN:向正无穷舍入
		System.out.println(b1.setScale(2, BigDecimal.ROUND_CEILING));

		// ROUND_FLOOR:向负无穷舍入
		System.out.println(b1.setScale(2, BigDecimal.ROUND_FLOOR));
		
		//转为double类型
		System.out.println(b1.doubleValue());
		
		//转为int类型
		System.out.println(b1.intValue());
	}
}

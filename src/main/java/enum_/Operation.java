package enum_;

/**
 * 《Effective Java》第30条
 * @author Administrator
 *
 */
public enum Operation {
	/*
	 * 这种写法虽然可行, 但是缺少throw语句就不能通过编译, 而且
	 * 新增一项时如果忘记在switch...case中补充一条就会在运行时出错
	 */
//	PLUS, MINUS, TIMES, DIVIDE;
//	double apply(double x, double y) {
//		switch (this) {
//		case PLUS: return x + y;
//		case MINUS: return x - y;
//		case TIMES: return x * y;
//		case DIVIDE: return x / y;
//		}
//		throw new AssertionError("Unknown op: " + this);
//	}
	
	/*
	 * 改进: 在枚举中将apply()声明为抽象方法, 每当添加枚举常量时
	 * 必须重写这个方法才能通过编译, 避免了因为忘记补充规则而出错
	 */
	PLUS {
		double apply(double x, double y) {return x + y;}
	},
	MINUS {
		double apply(double x, double y) {return x - y;}
	},
	TIMES {
		double apply(double x, double y) {return x * y;}
	},
	DIVIDE {
		double apply(double x, double y) {return x / y;}
	};
	
	abstract double apply(double x, double y);
}

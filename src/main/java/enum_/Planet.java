package enum_;

/**
 * 代码来自《Effective Java》第30条
 * @author Administrator
 *
 */
public enum Planet {
	/*
	 * 可使用枚举来代替常量;
	 * 枚举是特殊的类, 每个枚举常量都是这个类的实例
	 */
	MERCURY(3.302e+23, 2.439e6),
	VENUS(4.869e+24, 6.052e6),
	EARTH(5.975e+24, 6.378e6),
	MARS(6.419e+23, 3.393e6),
	JUPITER(1.899e+27, 7.149e7),
	SATURN(5.685e+26, 6.027e7),
	URANUS(8.683e+25, 2.556e7),
	NEPTUNES(1.024e+26, 2.477e7);
	//属性为final且私有
	private final double mass;
	private final double radius;
	private final double surfaceGravity;
	
	private static final double G = 6.67300E-11;
	//构造方法为私有
	private Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
		surfaceGravity = G * mass / (radius * radius);
	}
	//提供外部访问属性的方法
	public double getMass() {
		return mass;
	}

	public double getRadius() {
		return radius;
	}

	public double getSurfaceGravity() {
		return surfaceGravity;
	}
	
	public double surfaceWeight(double mass) {
		return mass * surfaceGravity;
	}
}

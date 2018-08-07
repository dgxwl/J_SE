package designpattern.builder;

/**
 * Builder模式定义的类
 * @author Administrator
 *
 */
public class Person {
	private final int id;
	private final String name;
	private final String gender;
	private final int age;
	
	//私有构造，从Builder中获取属性值
	private Person(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.gender = builder.gender;
		this.age = builder.age;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public static class Builder {
		//必要参数(定义为final)
		private final int id;
		//可选参数
		private String name;
		private String gender;		
		private int age;
		
		//Builder构造器，给必要参数初始化
		public Builder(int id) {
			this.id = id;
		}
		
		//给可选参数初始化，并返回当前Builder
		public Builder name(String val) {
			this.name = val;
			return this;
		}
		
		public Builder gender(String val) {
			this.gender = val;
			return this;
		}
		
		public Builder age(int val) {
			this.age = val;
			return this;
		}
		
		/*
		 * build()方法最终返回一个完成初始化的外部类的对象;
		 * 在这个方法中检查非法参数.
		 */
		public Person build() {
			return new Person(this);
		}
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
}

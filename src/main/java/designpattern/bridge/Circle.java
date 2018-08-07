package designpattern.bridge;

public class Circle extends Shape {

	public Circle(Color color) {
		super(color);
	}

	@Override
	public void paint() {
		System.out.println("paint a " + color.applyColor() + " circle.");
	}

}

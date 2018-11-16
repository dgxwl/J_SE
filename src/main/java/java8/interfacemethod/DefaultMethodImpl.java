package java8.interfacemethod;

public class DefaultMethodImpl implements IDefaultMethod {

	public static void main(String[] args) {
//		DefaultMethodImpl.def();  error
		DefaultMethodImpl d = new DefaultMethodImpl();
		d.defaultMethod();
		
		IDefaultMethod.staticMethod();
//		DefaultMethodImpl.staticMethod();  error
		
		IDefaultMethod im = new IDefaultMethod() {
			
		};
		im.defaultMethod();
	}
}

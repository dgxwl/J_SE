package designpattern.structrual.composite;

/**
 * 组合模式(Composite Pattern)将对象组合成树形结构以表示"部分-整体"的层次结构,
 * 使得用户对单个对象和组合对象的使用具有一致性;
 * 可分为透明组合模式和安全组合模式:
 * 透明模式中定义了操作子构件的方法,所有子构件具有一致性;但是在Leaf中,操作其子构件的
 * 方法是无意义的,如果没有进行相应的异常处理,可能会导致运行期出错;
 * 安全模式将操作子构件的方法在Composite中声明并实现,显得安全但客户端需要增加对节点类型的判断.
 * 
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Component composite1 = new Composite("Level 1");
		Component composite2 = new Composite("Level 2");
		composite1.add(composite2);
		Component composite3 = new Composite("Level 3");
		composite2.add(composite3);
		Component leaf = new Leaf("Level 4");
		composite3.add(leaf);
		
		composite1.display(1);
	}
}

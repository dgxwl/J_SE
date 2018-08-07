package lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用forEach()配合Lambda遍历Map
 * 
 * @author Administrator
 *
 */
public class LambdaForEachTraverseMapDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		
		map.forEach((kSubject, vMark) -> System.out.println("subject: " + kSubject + ", mark: " + vMark));
		System.out.println();
		map.forEach((kSubject, vMark) -> {
			if ("语文".equals(kSubject) || "英语".equals(kSubject)) {
				System.out.println("最爱的科目: " + vMark);
				// 在forEach()中不能使用break和continue, 可以使用return来达到continue的效果(因此不能中止遍历).
				//break;
				return ;
			}
			System.out.println("不爱" + kSubject);
		});
	}
}

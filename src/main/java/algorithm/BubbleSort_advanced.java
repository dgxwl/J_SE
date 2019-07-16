package algorithm;

import java.util.Arrays;

/**
 * 冒泡算法优化
 * 1.添加有序标记isSorted, 每轮初始为true, 若过程中有交换, 则变为false;
 * 本轮全部对比过后若标记仍是true, 说明已经有序, 剩下的几轮就不必进行了;
 * 2.每排序一轮, 最右的有序区长度增1, 在每一轮排序的最后记录下最后一次元素交换的位置,
 * 即有序区和无序区的边界, 不必跟有序区内进行比较了.
 * @author Administrator
 *
 */
public class BubbleSort_advanced {
	public static void main(String[] args) {
		//初始化数据
		int[] arr = Common.randomIntArray(10, 20);
		System.out.println("排序前: " + Arrays.toString(arr));
		
		//开始排序
		//有序标记
		boolean isSorted;
		//最后一次交换的位置
		int lastExchangeIndex = 0;
		//有序区最左下标
		int sortBorder = arr.length - 1;
		int temp;
		for (int i = 0; i < arr.length - 1; i++) {
			isSorted = true;
			for (int j = 0; j < sortBorder; j++) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					//发生交换, 还不是有序
					isSorted = false;
					//发生交换, 更新最后交换位置
					lastExchangeIndex = j;
				}
			}
			//记录本轮最后交换的位置
			sortBorder = lastExchangeIndex;
			if (isSorted) {
				break;
			}
		}
		System.out.println("排序后: " + Arrays.toString(arr));
	}
}

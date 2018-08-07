package algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 鸡尾酒排序是冒泡排序的改进, 为了避免
 * 2, 3, 4, 5, 6, 7, 8, 1这种极端情况(最小的在最右而剩余的已经有序, 还是对比了7次),
 * 改为从左到右、从右到左交替比较, 避免上述类似情况.
 * @author Administrator
 *
 */
public class CockTailSort {
	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(200);
		}
		System.out.println("排序前: " + Arrays.toString(arr));

		//有序标记
		boolean isSorted;
		//记录右侧最后一次交换的位置
		int lastRightExchangeIndex = 0;
		//记录左侧最后一次交换的位置
		int lastLeftExchangeIndex = 0;
		//无序数列的左边界，每次比较只需要比到这里为止
		int leftSortBorder = 0;
		//无序数列的右边界，每次比较只需要比到这里为止
		int rightSortBorder = arr.length - 1;
		for (int i = 0; i < arr.length / 2 - 1; i++) {
			isSorted = true;
			//从左向右比较
			for (int j = i; j < rightSortBorder; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSorted = false;
					lastRightExchangeIndex = j;
				}
			}
			rightSortBorder = lastRightExchangeIndex;
			if (isSorted) {
				break;
			}
			
			isSorted = true;
			//从右向左比较
			for (int j = arr.length - 1 - i; j > leftSortBorder; j--) {
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					isSorted = false;
					lastLeftExchangeIndex = j;
				}
			}
			leftSortBorder = lastLeftExchangeIndex;
			if (isSorted) {
				break;
			}
		}
		System.out.println("排序后: " + Arrays.toString(arr));
	}
}

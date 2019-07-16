package algorithm;

import java.util.Arrays;

/**
 * 选择排序
 * @author Administrator
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = Common.randomIntArray(10, 20);
		System.out.println("排序前: " + Arrays.toString(arr));
		
		int sortedLength = 0;
		while (sortedLength != arr.length) {
			int minIndex = sortedLength;
			for (int i = sortedLength; i < arr.length; i++) {
				if (arr[i] < arr[minIndex]) {
					minIndex = i;
				}
			}
			
			if (sortedLength != minIndex) {
				int temp = arr[sortedLength];
				arr[sortedLength] = arr[minIndex];
				arr[minIndex] = temp;
			}
			
			sortedLength++;
		}
		
		System.out.println("排序后: " + Arrays.toString(arr));
	}
}

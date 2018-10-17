package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 桶排序: 使用"桶"将元素划分为多个区间范围, 再对各个桶内部进行排序;
 * 不适用于元素分布极不均衡的情况.
 * @author Administrator
 *
 */
public class BucketSort {
	public static void main(String[] args) {
		//初始化数据
		Random random = new Random();
		double[] arr = new double[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextDouble() * 10;
		}
		System.out.println("排序前: " + Arrays.toString(arr));
		
		//开始排序
		double min = arr[0];
		double max = arr[0];
		//1.得到数据的最大最小值
		for (int i = 1; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		//计算差值
		double d = max - min;
		//2.初始化桶
		//决定桶的个数有很多种策略
		int bucketNum = arr.length;
		ArrayList<ArrayList<Double>> buckets = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			buckets.add(new ArrayList<>());
		}
		//3.将数据分别放入桶中
		for (int i = 0; i < arr.length; i++) {
			//将数据根据比例决定应放入的桶
			int bucketIndex = (int) ((arr[i] - min) * (bucketNum - 1) / d);
			buckets.get(bucketIndex).add(arr[i]);
		}
		//4.对各个桶内的数据进行排序
		int i = 0;
		for (ArrayList<Double> bucket : buckets) {
			//每个桶内排序可使用不同算法, 甚至递归调用桶排序
			bucket.sort(null);
			//将桶内已有序的数据放回原数组
			for (Double data : bucket) {
				arr[i] = data;
				i++;
			}
		}
		
		System.out.println("排序后: " + Arrays.toString(arr));
	}
}

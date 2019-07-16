package algorithm;

import java.util.Random;

public class Common {

	private static Random random = new Random();
	
	public static int[] randomIntArray(int length, int bound) {
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(bound);
		}
		return arr;
	}
	
	public static double[] randomDoubleArray(int length, double bound) {
		double[] arr = new double[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextDouble() * bound;
		}
		return arr;
	}
}

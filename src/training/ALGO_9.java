package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_9 {
	/*
	 * 常规解法：50 分超时
	 * */
	static int length, operation;
	static int[] weight;
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		length = Integer.parseInt(arr[0]);
		operation = Integer.parseInt(arr[1]);
		weight = new int[length];
		arr = buf.readLine().split(" ");
		for (int i = 0; i < length; i++) {
			weight[i] = Integer.parseInt(arr[i]);
		}
		for (int i = 0; i < operation; i++) {
			arr = buf.readLine().split(" ");
			int option = Integer.parseInt(arr[0]);
			int x = Integer.parseInt(arr[1]) - 1;
			int y = Integer.parseInt(arr[2]) - 1;
			switch(option) {
			case 1:{
				weight[x] = y + 1;
				break;
			}
			case 2:{
				System.out.println(getSum(x, y));
				break;
			}
			case 3:{
				System.out.println(getMax(x, y));
				break;
			}
			}
		}
		buf.close();
	}
	static int getSum(int start, int end) {
		int sum = 0;
		while (start <= end) {
			sum += weight[start];
			start++;
		}
		return sum;
	}
	static int getMax(int start, int end) {
		int max = 0;
		while (start <= end) {
			if (max < weight[start]) {
				max = weight[start];
			}
			start++;
		}
		return max;
	}
}

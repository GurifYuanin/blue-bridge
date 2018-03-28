package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ALGO_53 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int time = Integer.parseInt(buf.readLine());
		for (int i = 0; i < time; i++) {
			int length = Integer.parseInt(buf.readLine());
			int[] arr1 = new int[length];
			int[] arr2 = new int[length];
			int sum = 0;
			String[] arr = buf.readLine().split(" ");
			for (int j = 0; j < length; j++) {
				arr1[j] = Integer.parseInt(arr[j]);
			}
			arr = buf.readLine().split(" ");
			for (int j = 0; j < length; j++) {
				arr2[j] = Integer.parseInt(arr[j]);
			}
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			for (int j = 0; j < length; j++) {
				sum += (arr1[j] * arr2[length - j - 1]);
			}
			System.out.println(sum);
		}
		buf.close();
	}
}

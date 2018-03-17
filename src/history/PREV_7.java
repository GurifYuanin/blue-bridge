package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_7 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(buf.readLine());
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		int[] num = new int[length];
		for (int i = 0; i < length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		int min = -1, max = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < length; i++) {
			min = max = num[i];
			count++;
			for (int j = i + 1; j < length; j++) {
				if (num[j] > max) {
					max = num[j];
				} else if (num[j] < min) {
						min = num[j];
					}
				if (max - min == j - i) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}

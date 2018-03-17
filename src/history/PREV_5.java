package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_5 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int row = Integer.parseInt(buf.readLine());
		String[] arr = null;
		int[] num = new int[100001];
		int length = 0, index = 0;
		Arrays.fill(num, 0);
		for (int i = 0; i < row; i++) {
			arr = buf.readLine().trim().split(" ");
			length = arr.length;
			for (int j = 0; j < length; j++) {
				index = Integer.parseInt(arr[j]);
				num[index]++;
			}
		}
		buf.close();
		
		index = 0;
		while (num[index] == 0) {
			index++;
		}
		int start = index;
		while(num[index] != 0) {
			index++;
		}
		System.out.print(index+ " ");
		num[index] = 1;
		index = start;
		while (num[index] != 2) {
			index++;
		}
		System.out.print(index);
	}
}

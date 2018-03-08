package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_32 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine());
		int[] candy = new int[number];
		String[] arr = buf.readLine().split(" ");
		for (int i = 0; i < number; i++) {
			candy[i] = Integer.parseInt(arr[i]);
		}
		buf.close();
		
		int sum = 0, temp = 0;
		while (!isSame(candy)) {
			for (int i = 0; i < number; i++) {
				candy[i] /= 2;
			}
			temp = candy[0];
			for (int i = 0; i < number - 1; i++) {
				candy[i] += candy[i + 1];
			}
			candy[number - 1] += temp;
			for (int i = 0; i < number; i++) {
				if (candy[i] % 2 == 1) {
					sum++;
					candy[i]++;
				}
			}
		}
		System.out.print(sum);
	}
	static boolean isSame (int[] arr) {
		int length = arr.length, candyNumber = arr[0];
		for (int i = 1; i < length; i++) {
			if (arr[i] != candyNumber) {
				return false;
			}
		}
		return true;
	}
}

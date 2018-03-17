package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_8_2 {
	static int num1, num2, max = 0;
	static int N = 50000;
	static boolean[] isCombinable = new boolean[N];
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr =buf.readLine().split(" ");
		num1 = Integer.parseInt(arr[0]);
		num2 = Integer.parseInt(arr[1]);
		Arrays.fill(isCombinable, false);
		buf.close();
		
		int th1 = N / num1;
		int th2 = 0;
		for (int i = 0; i <= th1; i++) {
			th2 = (N - i * num1) / num2;
			for (int j = 0; i * num1 + j * num2 < N && j <= th2; j++) {
				isCombinable[i * num1 + j * num2] = true;
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			if (!isCombinable[i]) {
				System.out.print(i);
				return;
			}
		}
	}
}

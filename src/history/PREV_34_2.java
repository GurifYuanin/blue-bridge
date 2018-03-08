package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_34_2 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int m = Integer.parseInt(arr[0]);
		int n = Integer.parseInt(arr[1]);
		buf.close();
	
		int x = Math.max(m, n);
		int y = Math.min(m, n);
		m = n = 1;
		for (int i = 2; i <= y; i++) {
			if (countFactorNumber(i) % 2 == 1) {
				m++;
			}
		}
		n = m;
		for (int i = y + 1; i <= x; i++) {
			if (countFactorNumber(i) % 2 == 1) {
				n++;
			}
		}
		System.out.print(m * n);
	}
	static int countFactorNumber (int number) {
		int sum = 2;
		int sqrt = number / 2;
		for (int i = 2; i <= sqrt; i++) {
			if (number % i == 0) {
				sum++;
			}
		}
		return sum;
	}
}

package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_21 {
	static int sum;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		sum = Integer.parseInt(buf.readLine());
		buf.close();
		
		boolean flag = true;
		for (int i = 10001; i <= 999999; i++) {
			if (isPalindrome(i, sum)) {
				System.out.println(i);
				flag = false;
			}
		}
		if (flag) {
			System.out.print(-1);
		}
	}
	static boolean isPalindrome(int num, int sum) {
		String str = String.valueOf(num);
		int length = str.length();
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1)) {
				return false;
			}
		}
		for (int i = 0; i < length; i++) {
			sum -= (str.charAt(i) - 48);
		}
		if (sum != 0) {
			return false;
		}
		return true;
	}
}

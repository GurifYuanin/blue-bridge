package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic_9 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine());
		buf.close();
		
		for (int i = 10001; i < 1000000; i++) {
			if (isPalindrome(i) && countSum(i) == number) {
				System.out.println(i);
			}
		}
	}
	static boolean isPalindrome (int number) {
		boolean result = true;
		String str = String.valueOf(number);
		int length = str.length();
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1)) {
				result = false;
				break;
			}
		}
		return result;
	}
	static int countSum (int number) {
		int result = 0;
		while (number != 0) {
			result += number % 10;
			number /= 10;
		}
		return result;
	}
}

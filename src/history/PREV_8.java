package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_8 {
	static int num1, num2, max = 0;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr =buf.readLine().split(" ");
		num1 = Integer.parseInt(arr[0]);
		num2 = Integer.parseInt(arr[1]);
		buf.close();
		
		dfs(Math.min(num1, num2) - 1);
		System.out.print(max);
	}
	static boolean isCombinable(int num) {
		if (num % num1 == 0 || num % num2 == 0) {
			return true;
		}
		while ((num -= num1) > 0) {
			if (num % num2 == 0) {
				return true;
			}
		}
		return false;
	}
	static void dfs(int num) {
		if (!isCombinable(num)) {
			max = Math.max(max, num);
			dfs(num + num1);
			dfs(num + num2);
		}
	}
}

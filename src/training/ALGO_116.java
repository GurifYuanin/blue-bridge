package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_116 {
	static int[] num;
	static int[][] dp;
	static int length, mulNumber;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		length = Integer.parseInt(arr[0]);
		mulNumber = Integer.parseInt(arr[1]);
		num = new int[length];
		dp = new int[length][mulNumber];
		arr = buf.readLine().split(" ");
		for (int i = 0; i < length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		dp[0][0] = num[0];
		for (int i = 1; i < length; i++) {
			dp[i][0] = dp[i - 1][0] + num[i];
		}
		buf.close();

		for (int i = 0; i < length; i++) {
			for (int j = 1; j < mulNumber; j++) {
				if(i >= j) {
					for (int k = 1; k < i; k++) {
						if (dp[i][j] < dp[k][j - 1] * (dp[i][0] - dp[k][0])) {
							dp[i][j] = dp[k][j - 1] * (dp[i][0] - dp[k][0]);
						}
					}
				}
			}
		}
		
		System.out.print(dp[length - 1][mulNumber - 1]);
	}

}

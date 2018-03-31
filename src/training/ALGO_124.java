package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_124 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int row = Integer.parseInt(buf.readLine());
		int[][] num = new int[row][row], sum = new int[row][row];
		for (int i = 0; i < row; i++) {
			String[] arr = buf.readLine().split(" ");
			for (int j = 0; j < arr.length; j++) {
				num[i][j] = Integer.parseInt(arr[j]);
			}
		}
		buf.close();
		
		// init
		sum[0][0] = num[0][0];
		for (int i = 1; i < row; i++) {
			sum[i][0] = sum[i - 1][0] + num[i][0];
			sum[i][i] = sum[i - 1][i - 1] + num[i][i];
		}
		// dp
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < i; j++) {
				sum[i][j] = Math.max(sum[i - 1][j], sum[i - 1][j - 1]) + num[i][j];
			}
		}
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < row; i++) {
			if (result < sum[row - 1][i]) {
				result = sum[row - 1][i];
			}
		}
		System.out.println(result);
	}
}

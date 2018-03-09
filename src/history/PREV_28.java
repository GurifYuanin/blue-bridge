package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_28 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int row = Integer.parseInt(arr[0]);
		int col = Integer.parseInt(arr[1]);
		int num = Integer.parseInt(arr[2]);
		int[][][][] plan = new int[51][51][13][13];
		int[][] value = new int[51][51];
		int mod = 1000000007;
		for (int i = 1; i <= row; i++) {
			arr = buf.readLine().split(" ");
			for (int j = 1; j <= col; j++) {
				value[i][j] = Integer.parseInt(arr[j - 1]);
			}
		}
		buf.close();
		for (int i = 0; i < 51; i++) {
			for (int j = 0; j < 51; j++) {
				for (int k = 0; k < 13; k++) {
					Arrays.fill(plan[i][j][k], 0);
				}
			}
		}
		plan[1][1][0][0] = plan[1][1][1][value[1][1]] = 1;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				plan[i][j][0][0] += (plan[i - 1][j][0][0] + plan[i][j - 1][0][0]);
				plan[i][j][0][0] %= mod;
				for (int m = 1; m <= num; m++) {
					for (int n = 0; n <= 12; n++) {
						// 不拿起当前宝物
						plan[i][j][m][n] += plan[i - 1][j][m][n];
						plan[i][j][m][n] %= mod;
						plan[i][j][m][n] += plan[i][j - 1][m][n];
						plan[i][j][m][n] %= mod;
					}
					// 拿起当前宝物
					if (m == 1) {
						plan[i][j][1][value[i][j]] += plan[i - 1][j][0][0];
						plan[i][j][1][value[i][j]] %= mod;
						plan[i][j][1][value[i][j]] += plan[i][j - 1][0][0];
						plan[i][j][1][value[i][j]] %= mod;
					} else {
						for (int t = 0; t < value[i][j]; t++) {
							plan[i][j][m][value[i][j]] += plan[i - 1][j][m - 1][t];
							plan[i][j][m][value[i][j]] %= mod;
							plan[i][j][m][value[i][j]] += plan[i][j - 1][m - 1][t];
							plan[i][j][m][value[i][j]] %= mod;
						}
					}
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 13; i++ ) {
			sum += plan[row][col][num][i];
			sum %= mod;
		}
		System.out.print(sum);
	}
}

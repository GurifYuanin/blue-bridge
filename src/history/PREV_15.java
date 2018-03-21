package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_15 {
	static int N = 10001;
	static int MOD = 1000000007;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int col = Integer.parseInt(buf.readLine()); // 城墙的列数
		buf.close();
		
		long[] result = new long[N]; // 城墙列数为 index 时从边角出发的可走数量
		long[] pow = new long[N]; // 2^index
		result[0] = 0;
		result[1] = 1;
		result[2] = 6;
		pow[0] = 0;
		pow[1] = 1;
		pow[2] = 2;
		for (int i = 3; i <= col; i++) {
			pow[i] = (2 * pow[i - 1]) % MOD;
			result[i] = (2 * result[i - 1] + pow[i] + 4 * result[i - 2]) % MOD;
		}
		
		long sum = 0;
		if (col == 1) {
			sum = 2;
		} else {
			sum = 4 * result[col];
		}
		for (int i = 2; i < col; i++) {
			sum += (8 * pow[i - 1] * result[col - i]) % MOD + (8 * pow[col - i] * result[i - 1]) % MOD;
			sum %= MOD;
		}
		System.out.print(sum);
	}
}

package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_30 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		int length = Integer.parseInt(arr[0]); // 数字个数
		int sum = Integer.parseInt(arr[1]); // 总和
		int inc = Integer.parseInt(arr[2]); // 增量
		int dec = Integer.parseInt(arr[3]); // 减量
		int all = inc + dec;
		int number = length;
		int index = 0;
		length = length * (length - 1) / 2;
		// 构建映射表
		int[][] map = new int[2][length + 1]; // 方案数 => 利用前 i 个元素 ( 1, 2, 3, ..., n ) 组成和为 j 的方案数
		Arrays.fill(map[0], 0);
		map[0][0] = map[1][0] = 1;
		for (int i = 1; i < number; i++) {
			index = 1 - index;
			for (int j = 1; j <= length; j++) {
				if (i <= j) {
					map[index][j] = (map[1 - index][j] + map[1 - index][j - i]) % 100000007;
				} else {
					map[index][j] = map[1 - index][j];
				}
			}
		}
		int count = 0;
		sum -= inc * length;
		for (int i = 0; i <= length; i++) {
			if (sum % number == 0) {
				count += map[index][i];
			}
			sum += all;
		}
		System.out.print(count % 100000007);
	}
}

package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_3 {
	static int sum, kindNumber = 0, length = 10;
	static int[] list = new int[length]; // 0~9 数字摆放
	static boolean[] flag = new boolean[length]; // 下标数字是否已经加入 list
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		sum = Integer.parseInt(buf.readLine());
		buf.close();
		
		Arrays.fill(flag, false);
		dfs(1, length, sum);
		System.out.print(kindNumber);
	}
	static void dfs(int start, int length, int sum) {
		if (start == length) {
			count(list, length, sum);
		} else {
			for (int i = 1; i < length; i++) {
				if (flag[i]) {
					continue;
				} else {
					list[start] = i;
					flag[i] = true;
					dfs(start  + 1, length, sum);
					flag[i] = false;
				}
			}
		}
	}
	static void count(int[] list, int length, int sum) {
		for (int i = 1; i < length; i++) {
			int remainder = getRangeOf(list, 1, i);
			if (remainder >= sum) {
				// 如果余数大于目标数，直接返回
				return;
			} else {
				for (int j = i + (length - i) / 2; j < length - 1; j++) {
					int beDivisor = getRangeOf(list, i + 1, j); // 被除数
					int divisor = getRangeOf(list, j + 1, length - 1); // 除数
					if (beDivisor % divisor == 0 && sum == beDivisor / divisor + remainder) {
						kindNumber++;
					}
				}
			}
		}
	}
	static int getRangeOf(int[] list, int start, int end) {
		int result = 0;
		for (int i = start; i <= end; i++) {
			result = result * 10 + list[i];
		}
		return result;
	}
}

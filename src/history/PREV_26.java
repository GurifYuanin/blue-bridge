package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_26 {
	static int row; // 行数
	static int col; // 列数
	static int[][] value; // 矩阵元素值
	static int[] sum; // 矩阵降纬后的数组（列元素和）
	static String[] arr; // 临时数组
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		row = Integer.parseInt(arr[0]);
		col = Integer.parseInt(arr[1]);
		value = new int[row][col];
		sum = new int[col];
		for (int i = 0; i < row; i++) {
			arr = buf.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				value[i][j] = Integer.parseInt(arr[j]);
			}
		}
		buf.close();
		
		// 降纬（枚举）
		int result = value[0][0];
		for (int i = 0; i < row; i++) {
			Arrays.fill(sum, 0);
			for (int j = i; j < row; j++) {
				for (int k = 0; k < col; k++) {
					sum[k] += value[j][k];
				}
				result = Math.max(result, getMax(sum));
			}
		}
		System.out.print(result);
	}
	static int getMax (int[] list) {
		int result = list[0];
		int tmp = 0;
		for (int i = 0; i < col; i++) {
			if (tmp < 0) {
				tmp = list[i];
			} else {
				tmp += list[i];
			}
			result = Math.max(result, tmp);
		}
		return result;
	}
}

package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_26 {
	static int row; // ����
	static int col; // ����
	static int[][] value; // ����Ԫ��ֵ
	static int[] sum; // ����γ������飨��Ԫ�غͣ�
	static String[] arr; // ��ʱ����
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
		
		// ��γ��ö�٣�
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

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
		
		int length = Integer.parseInt(arr[0]); // ���ָ���
		int sum = Integer.parseInt(arr[1]); // �ܺ�
		int inc = Integer.parseInt(arr[2]); // ����
		int dec = Integer.parseInt(arr[3]); // ����
		int all = inc + dec;
		int number = length;
		int index = 0;
		length = length * (length - 1) / 2;
		// ����ӳ���
		int[][] map = new int[2][length + 1]; // ������ => ����ǰ i ��Ԫ�� ( 1, 2, 3, ..., n ) ��ɺ�Ϊ j �ķ�����
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

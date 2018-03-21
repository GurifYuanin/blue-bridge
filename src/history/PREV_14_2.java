package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_14_2 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		int monkNumber = arr.length; // С��������
		int[] position = new int[monkNumber]; // С��������λ��
		for (int i = 0; i < monkNumber; i++) {
			position[i] = Integer.parseInt(arr[i]);
		}
		
		for (int i = 0; i < monkNumber - 1; i++) {
			int tmp = position[i]; // ��ǰС��������λ��
			while (position[i] + 1 < position[i + 1]) {
				position[i]++; // ��ǰС������ǰһ��
				if (isWin(position)) {
					System.out.print(tmp + " " + position[i]);
					return;
				}
			}
			position[i] = tmp;
		}
		System.out.print(-1);
	}
	static boolean isWin(int[] position) {
		int[] stack = new int[32]; // ��ķ��
		Arrays.fill(stack, 0);
		int monkNumber = position.length;
		for (int i = 0; i + 1 < monkNumber; i += 2) {
			int distence = position[i + 1] - position[i] - 1; // ������֮���̨����
			String tmp = Integer.toBinaryString(distence);
			for (int j = tmp.length() - 1, k = 0; j >= 0; j--, k++) {
				if (tmp.charAt(j) == '1') {
					stack[k]++;
				}
			}
		}
		for (int i = 0; i < 32; i++) {
			if (stack[i] % 2 != 0) {
				return false;
			}
		}
		return true;
	}
}

package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_14 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");				
		buf.close();
		
		int monkNumber = arr.length;
		int[] position = new int[monkNumber];
		for (int i = 0; i < monkNumber; i++) {
			position[i] = Integer.parseInt(arr[i]);
		}
		int stepHeight = position[monkNumber - 1];
		
		int notNeedMove = 0, needMove = monkNumber;
		for (int i = monkNumber - 1, j = stepHeight; i >= 0 && position[i] == j ; i--, j--) {
			notNeedMove++;
		}
		needMove -= notNeedMove;
		if (needMove % 2 == 0) {
			// 如果需要移动的小和尚为偶数
			for (int i = 0; i < needMove;) {
				if (position[i] + 1 == position[i + 1]) {
					i += 2;
				} else {
					System.out.print(position[i] + " " + (position[i + 1] - 1));
					return;
				}
			}
		} else {
			// 如果为奇数
			for (int i = 0; i < needMove;) {
				if (position[i] + 2 >= position[i + 1]) {
					i += 2;
				} else {
					System.out.print(position[i] + " " + (position[i + 1] - 2));
					return;
				}
			}
		}
		System.out.print(-1);
	}
}

package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class PREV_17 {
	static int[] remaindCard = new int[101]; // 剩余卡片
	static int[] selectableCard = new int[101]; // 可选卡片
	static int remaindNumber; // 剩余卡片数量
	static int selectableNumber; // 可选卡片数量
	static LinkedList<Integer>[] list = new LinkedList[101]; // 下标的公约/倍数
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		remaindNumber = arr.length;
		for (int i = 0; i < remaindNumber; i++) {
			remaindCard[Integer.parseInt(arr[i])]++;
		}
		arr = buf.readLine().split(" ");
		selectableNumber = arr.length;
		for (int i = 0; i < selectableNumber; i++) {
			selectableCard[Integer.parseInt(arr[i])]++;
		}
		buf.close();
		
		for (int i = 1; i < 101; i++) {
				list[i] = new LinkedList<Integer>();
				for (int j = 1; j < 101; j++) {
					if (remaindCard[j] == 1 && j == i) {
						continue;
					} else if (remaindCard[j] > 0 && (j > i ? j % i : i % j) == 0) {
						list[i].add(j);
					}
				}
		}
		for (int i = 1; i < 101; i++) {
			if (selectableCard[i] > 0) {
				remaindCard[i]--;
				if (!isWin(i)) {
					System.out.print(i);
					return;
				}
				remaindCard[i]++;
			}
		}
		System.out.print(-1);
	}
	static boolean isWin(int select) {
		for (int i = list[select].size() - 1; i >= 0; i--) {
			int tmp = list[select].get(i);
			if (remaindCard[tmp] > 0) {
				remaindCard[tmp]--;
				boolean flag = isWin(tmp);
				remaindCard[tmp]++;
				if (!flag) {
					return true;
				}
			}
		}
		return false;
	}
}

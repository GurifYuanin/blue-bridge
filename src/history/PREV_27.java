package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class PREV_27 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine()); // 蚂蚁数
		String[] arr = buf.readLine().split(" ");
		Ant[] ants = new Ant[number]; // 蚂蚁实例
		int coldAntPosition = Math.abs(Integer.parseInt(arr[0])); // 感冒蚂蚁所在位置
		int coldAntIndex = 0; // 感冒蚂蚁所在索引
		for (int i = 0; i < number; i++) {
			int temp = Integer.parseInt(arr[i]);
			if (temp < 0) {
				ants[i] = new Ant(Math.abs(temp));
				ants[i].toLeft = true;
			} else {
				ants[i] = new Ant(temp);
				ants[i].toLeft = false;
			}
		}
		// 排序位置
		Arrays.sort(ants, new Comparator<Ant>() {
			public int compare (Ant a, Ant b)  {
				return a.position - b.position;
			}
		});
		// 找出感冒蚂蚁所在索引
		for (int i = 0; i < number; i++) {
			if (ants[i].position == coldAntPosition) {
				coldAntIndex = i;
				break;
			}
		}
		int all = 1; // 最终感冒蚂蚁数
		if (ants[coldAntIndex].toLeft) {
			// 如果感冒蚂蚁往左走
			for (int i = 0; i < coldAntIndex; i++) {
				if (!ants[i].toLeft) {
					all++;
				}
			}
			if (all > 1)  {
				for (int i = coldAntIndex + 1; i < number; i++) {
					if (ants[i].toLeft) {
						all++;
					}
				}
			}
		} else {
			// 如果感冒蚂蚁向右走
			for (int i = coldAntIndex + 1; i < number; i++) {
				if (ants[i].toLeft) {
					all++;
				}
			}
			if (all > 1) {
				for (int i = 0; i < coldAntIndex; i++) {
					if (!ants[i].toLeft) {
						all++;
					}
				}
			}
		}
		System.out.print(all);
	}
}
class Ant {
	int position;
	boolean toLeft;
	Ant (int p) {
		position = p;
	}
}

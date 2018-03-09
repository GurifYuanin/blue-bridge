package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class PREV_27 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine()); // ������
		String[] arr = buf.readLine().split(" ");
		Ant[] ants = new Ant[number]; // ����ʵ��
		int coldAntPosition = Math.abs(Integer.parseInt(arr[0])); // ��ð��������λ��
		int coldAntIndex = 0; // ��ð������������
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
		// ����λ��
		Arrays.sort(ants, new Comparator<Ant>() {
			public int compare (Ant a, Ant b)  {
				return a.position - b.position;
			}
		});
		// �ҳ���ð������������
		for (int i = 0; i < number; i++) {
			if (ants[i].position == coldAntPosition) {
				coldAntIndex = i;
				break;
			}
		}
		int all = 1; // ���ո�ð������
		if (ants[coldAntIndex].toLeft) {
			// �����ð����������
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
			// �����ð����������
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

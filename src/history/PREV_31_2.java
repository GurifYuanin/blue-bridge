package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_31_2 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine());
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		int[] height = new int[number]; // 身高
		int max = 0; // 最高身高
		int angry = 0;
		for (int i = 0; i < number; i++) {
			height[i] = Integer.parseInt(arr[i]);
			if (max < height[i]) {
				max = height[i];
			}
		}
		int[] count = new int[max + 1]; // 出现次数
		int[] move = new int[number]; // 被移动次数
		Arrays.fill(move, 0);
		Arrays.fill(count, 0);
		int[] table = new int[number];
		table[0] = 0;
		for (int i = 1; i < number; i++) {
			table[i] = table[i - 1] + i;
		}
		for (int i = 0; i < number; i++) {
			int h = height[i];
			count[h]++;
			int sum = 0;
			for (int j = h + 1; j <= max; j++) {
				sum += count[j];
			}
			move[i] += sum;
		}
		Arrays.fill(count, 0);
		for (int i = number - 1; i >= 0; i--) {
			int h = height[i];
			count[h]++;
			int sum = 0;
			for (int j = 0; j < h; j++) {
				sum += count[j];
			}
			move[i] += sum;
		}
		for (int i = 0; i < number; i++) {
			angry += table[move[i]];
		}
		System.out.print(angry);
	}
}

package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_34 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int m = Integer.parseInt(arr[0]);
		int n = Integer.parseInt(arr[1]);
		buf.close();
		
		boolean[][] rect = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(rect[i], true);
		}
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				for (int i = 1;; i++) {
					int newX = (x + 1) * i;
					if (newX < m) {
						for (int j = 1;; j++) {
							int newY = (y + 1) * j;
							if (newY < n) {
								rect[newX][newY] = !rect[newX][newY];
							}
							else {
								break;
							}
						}
					} else {
						break;
					}
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!rect[i][j]) {
					sum++;
				}
			}
		}
		System.out.print(sum);
	}
}

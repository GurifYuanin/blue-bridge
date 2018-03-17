package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_13 {
	static int nodeNumber, pathNumber, count = 0;
	static boolean[][] path;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		nodeNumber = Integer.parseInt(arr[0]);
		pathNumber = Integer.parseInt(arr[1]);
		path = new boolean[nodeNumber][nodeNumber];
		for (int i = 0; i < pathNumber; i++) {
			arr = buf.readLine().split(" ");
			int x = Integer.parseInt(arr[0]) - 1;
			int y = Integer.parseInt(arr[1]) - 1;
			path[x][y] = path[y][x] = true;
		}
		buf.close();
		
		for (int i = 0; i < nodeNumber; i++) {
			dfs(-1, i, 2);
		}
		System.out.print(count);
	}
	static void dfs(int from, int current, int remaindStep) {
		if (remaindStep == 0) {
			count++;
		} else {
			for (int i = 0; i < nodeNumber; i++) {
				if (i != from && path[current][i]) {
					dfs(current, i, remaindStep - 1);
				}
			}
		}
	}
}

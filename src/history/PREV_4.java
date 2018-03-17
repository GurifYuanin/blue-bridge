package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_4 {
	static int row, col, result, sum; // 行数 列数 最少个数
	static int[][] table;
	static boolean[][] isVisited;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		row = Integer.parseInt(arr[1]);
		col = Integer.parseInt(arr[0]);
		sum = 0;
		result = Integer.MAX_VALUE;
		table = new int[row][col];
		isVisited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			arr = buf.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				table[i][j] = Integer.parseInt(arr[j]);
				sum += table[i][j];
				isVisited[i][j] = false;
			}
		}
		buf.close();
		dfs(0, 0, 0, 1);
		if (result == Integer.MAX_VALUE) {
			System.out.print(0);
		} else {
			System.out.print(result);
		}
	}
	static void dfs(int x, int y, int currentSum, int count) {
		currentSum += table[x][y];
		int remainder = sum - currentSum;
		if (currentSum == remainder) {
			result = Math.min(result, count);
			return;
		}
		if (y + 1 < col && !isVisited[x][y + 1] && currentSum + table[x][y + 1] <= remainder - table[x][y + 1]) {
			isVisited[x][y + 1] = true;
			dfs(x, y + 1, currentSum, count + 1);
			isVisited[x][y + 1] = false;
		}
		if (x + 1 < row && !isVisited[x + 1][y] && currentSum + table[x + 1][y] <= remainder - table[x + 1][y]) {
			isVisited[x + 1][y] = true;
			dfs(x + 1, y, currentSum, count + 1);
			isVisited[x + 1][y] = false;
		}
		if (y - 1 >= 0 && !isVisited[x][y - 1] && currentSum + table[x][y - 1] <= remainder - table[x][y - 1]) {
			isVisited[x][y - 1] = true;
			dfs(x, y - 1, currentSum, count + 1);
			isVisited[x][y - 1] = false;
		}
		if (x - 1 >= 0 && !isVisited[x - 1][y] && currentSum + table[x - 1][y] <= remainder - table[x - 1][y]) {
			isVisited[x - 1][y] = true;
			dfs(x - 1, y, currentSum, count + 1);
			isVisited[x - 1][y] = false;
		}
	}
}

package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_9 {
	static int cityNumber, max = 0;
	static int[][] path;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		cityNumber = Integer.parseInt(buf.readLine());
		path = new int[cityNumber][cityNumber];
		arrFill(path, 0);
		for (int i = 0; i < cityNumber - 1; i++) {
			String[] arr = buf.readLine().split(" ");
			int x = Integer.parseInt(arr[0]) - 1;
			int y = Integer.parseInt(arr[1]) - 1;
			int distence = Integer.parseInt(arr[2]);
			path[x][y] = path[y][x] = distence;
		}
		buf.close();
		
		for (int i = 0; i < cityNumber; i++) {
			if (isEdgeNode(i)) {
				dfs(i, i, 0);
			}
		}
		System.out.print(countConsume(max));
	}
	static int countConsume(int km) {
		int result = 0;
		int base = 11;
		for (int i = 0; i < km; i++) {
			result += base;
			base++;
		}
		return result;
	}
	static void arrFill(int[][] arr, int num) {
		for (int i = 0; i < cityNumber; i++) {
			Arrays.fill(arr[i], num);
		}
	}
	static boolean isEdgeNode(int node) {
		int count = 0;
		for (int i = 0; i < cityNumber; i++) {
			if (path[node][i] != 0) {
				count++;
			}
		}
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}
	static void dfs(int node, int from, int sum) {
		sum += path[from][node];
		for (int i = 0; i < cityNumber ; i++) {
			if (i != from && path[node][i] != 0) {
				dfs(i, node, sum);
			}
		}
		max = Math.max(max, sum);
	}
}

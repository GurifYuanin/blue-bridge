package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PREV_12 {
	static int count = 0, siteNumber, tunnelNumber, x, y;
	static boolean[][] isConnected;
	static boolean[] isVisited;
	static boolean flag;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		siteNumber = Integer.parseInt(arr[0]);
		tunnelNumber = Integer.parseInt(arr[1]);
		isConnected = new boolean[siteNumber][siteNumber];
		isVisited = new boolean[siteNumber];
		for (int i = 0; i < tunnelNumber; i++) {
			arr = buf.readLine().split(" ");
			x = Integer.parseInt(arr[0]) - 1;
			y = Integer.parseInt(arr[1]) - 1;
			isConnected[x][y] = isConnected[y][x] = true;
		}
		arr = buf.readLine().split(" ");
		x = Integer.parseInt(arr[0]) - 1;
		y = Integer.parseInt(arr[1]) - 1;
		buf.close();
		
		boolean[] tmp = new boolean[siteNumber];
		for (int i = 0; i < siteNumber; i++) {
			if (i != x && i != y) {
				Arrays.fill(tmp, false);
				for (int j = 0; j < siteNumber; j++) {
					tmp[j] = isConnected[i][j];
				}
				Arrays.fill(isConnected[i], false);
				Arrays.fill(isVisited, false);
				flag = false;
				dfs(x);
				if (!flag) {
					count++;
				}
				for (int j = 0; j < siteNumber; j++) {
					isConnected[i][j] = tmp[j];
				}
			}
		}
		System.out.print(count);
	}
	static void dfs(int currentSite) {
		isVisited[currentSite] = true;
		if (currentSite == y) {
			flag = true;
		}
		for (int i = 0; i < siteNumber; i++) {
			if (!isVisited[i] && isConnected[currentSite][i]) {
				dfs(i);
			}
		}
	}
}

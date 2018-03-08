package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_33 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int row = Integer.parseInt(arr[0]);
		int col = Integer.parseInt(arr[1]);
		/* 
		 * 0 / false => 白 => 左转 => (direction - 1) % 4
		 * 1 / true => 黑 => 右转 => (direction + 1) % 4
		 * 左上右下 / LURD => 0123
		 */
		boolean[][] path = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			arr = buf.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				if (arr[j].equals("0")) {
					path[i][j] = false;
				} else {
					path[i][j] = true;
				}
			}
		}
		arr = buf.readLine().split(" ");
		int x = Integer.parseInt(arr[0]);
		int y = Integer.parseInt(arr[1]);
		int direction = -1;
		switch (arr[2]) {
		case "L": direction = 0; break;
		case "U": direction = 1; break;
		case "R": direction = 2; break;
		case "D": direction = 3; break;
		}
		int step = Integer.parseInt(arr[3]);
		buf.close();
		
		
		for (int i = 0; i < step; i++) {
			if (path[x][y]) {
				// 如果在黑格 => 右转
				direction = (direction + 1) % 4;
			} else {
				// 如果在白格 => 左转
				if (direction == 0) {
					direction = 3;
				} else {
					direction--;
				}
			}
			path[x][y] = !path[x][y];
			switch (direction) {
			case 0: y--; break;
			case 1: x--; break;
			case 2: y++; break;
			case 3: x++; break;
			}
		}
		System.out.print(x + " " + y);
	}
}

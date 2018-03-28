package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ALGO_161 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int startX = 0, startY = 0, endX = 0, endY = 0;
		RPoint[][] points = new RPoint[9][9];
		Stack<String> stack = new Stack<String>();
		String str;
		String[] arr;
		do {
			// 初始化
			str = buf.readLine();
			if (str.equals("END")) {
				break;
			}
			System.out.println(str);
			arr = buf.readLine().split(" ");
			startX = Integer.parseInt(arr[0]) - 1;
			startY = Integer.parseInt(arr[1]) - 1;
			endX = Integer.parseInt(arr[3]) - 1;
			endY = Integer.parseInt(arr[4]) - 1;
			do {
				str = buf.readLine();
				if (str.equals("0")) {
					break;
				}
				arr = str.split(" ");
				int x = Integer.parseInt(arr[0]) - 1; 
				int y = Integer.parseInt(arr[1]) - 1; 
				points[x][y] = new RPoint();
				for (int i = 2; i < arr.length; i++) {
					setDirection(arr[i], points[x][y].label);
				}
			} while (true);
			// 模拟
			int currentX = endX, currentY = endY;
			while (currentX != startX || currentY != startY) {
				stack.push("(" + currentX + "," + currentY + ")");
				// 检查左侧的点是否存在、是否走得到当前点
				if (currentY > 0 && points[currentX][currentY - 1] != null && isConnect(points[currentX][currentY - 1], 2)) {
					currentY--; // 走到左侧的点
				} else if (currentX > 0 && points[currentX - 1][currentY] != null && isConnect(points[currentX - 1][currentY], 3 )) {
					currentX--;
				} else if (currentY + 1 < 9 && points[currentX][currentY + 1] != null && isConnect(points[currentX][currentY + 1], 0)) {
					currentY++;
				} else {
					currentX++;
				}
			}
			// 输出
			if (stack.size() == 1) {
				System.out.println("No Solution Possible");
			} else {
				System.out.print("(" + startX + "," + startY + ")");
				while (!stack.isEmpty()) {
					System.out.print(" " + stack.pop());
				}
			}
		} while(true);
	}
	static boolean isConnect(RPoint target, int direction) {
		// target 点是否可以向 direction 方向走
		for (int i = 0; i < 4; i++) {
			if (target.label[i][direction] == 1) {
				return true;
			}
		}
		return false;
	}
	static void setDirection(String str, int[][] label) {
		if (!str.equals("*")) {
			int position;
			switch(str.charAt(0)) {
			case 'N': {
				position = 3;
				break;
			}
			case 'W': {
				position = 2;
				break;
			}
			case 'S': {
				position = 1;
				break;
			}
			default: {
				position = 0;
				break;
			}
			}
			for (int i = 1; i < str.length(); i++) {
				int direction = getIndex(position, str.charAt(i));
				label[position][direction] = 1;
			}
		}
	}
	static int getIndex(int direction, char c) {
		switch(c) {
		case 'L': {
			return (1 + direction) % 4;
		}
		case 'F': {
			return (2 + direction) % 4;
		}
		default: {
			return (3 + direction) % 4;
		}
		}
	}
}
class RPoint{
	int[][] label = new int[4][4]; // 路标在哪个位置、指向哪个方向（0~3 -> 左上右下 -> 西北东南 -> WNES）
}

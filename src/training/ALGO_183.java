package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_183 {
	static int countrysNumber, completed; // 国家数量、完成收集的国家数
	static int day;
	static Country[] countrys;
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		countrysNumber = Integer.parseInt(buf.readLine());
		do {
			countrys = new Country[countrysNumber];
			for (int i = 0; i < countrysNumber; i++) {
				String[] arr = buf.readLine().split(" ");
				countrys[i] = new Country(arr[0], Integer.parseInt(arr[1]) - 1, Integer.parseInt(arr[2]) - 1, Integer.parseInt(arr[3]) - 1, Integer.parseInt(arr[4]) - 1, countrysNumber);
			}
			Point[][] point = createPoint(countrys);
			day = 0;
			completed = 0;
			int index = 0;
			do {
				day++;
				index++;
				System.out.println("Case Number " + index);
				int width = point.length;
				int height = point[0].length;
				for (int i = 0; i < width; i++) {
					for (int j = 0; j < height; j++) {
						Point p = point[i][j];
						if (p != null) {
							for (int k = 0; k < countrysNumber && p.coin[k] > 1000; k++) {
								int tmp = point[i][j].coin[k] / 1000;
								if (i > 0 && point[i - 1][j] != null) {
									updatePoint(point[i - 1][j], k, tmp);
									p.coin[k] -= tmp;
								}
								if (j > 0 && point[i][j - 1] != null) {
									updatePoint(point[i][j - 1], k, tmp);
									p.coin[k] -= tmp;
								}
								if (i < width - 1 && point[i + 1][j] != null) {
									updatePoint(point[i + 1][j], k, tmp);
									p.coin[k] -= tmp;
								}
								if (j < height - 1 && point[i][j + 1] != null) {
									updatePoint(point[i][j + 1], k, tmp);
									p.coin[k] -= tmp;
								}
							}
						}
					}
				}
			} while (!isCompleted());
		} while ((countrysNumber = Integer.parseInt(buf.readLine())) != 0);
		buf.close();
	}
	static void updatePoint(Point p, int k, int inc) {
			if (p.coin[k] == 0) {
				p.completed++;
				if (p.completed == countrysNumber) {
					countrys[p.belong].completed++;
					if (countrys[p.belong].check(day)) {
						completed++;
					}
				}
			}
			p.coin[k] += inc;
	}
	static Point[][] createPoint(Country[] countrys) {
		int width = 0, height = 0;
		for (int i = 0; i < countrysNumber; i++) {
			if (width < countrys[i].x2) {
				width = countrys[i].x2;
			}
			if (height < countrys[i].y2) {
				height = countrys[i].y2;
			}
		}
		Point[][] p = new Point[width][height];

		for (int i = 0; i < countrysNumber; i++) {
			for (int m = countrys[i].x1; m < countrys[i].x2; m++) {
				for (int n = countrys[i].y1; n < countrys[i].y2; n++) {
					p[m][n] = new Point(i, countrysNumber);
				}
			}
		}
		return p;
	}
	static boolean isCompleted () {
		return completed == countrysNumber;
	}

}
class Point {
	int[] coin;
	int belong, completed;
	Point(int b, int countrysNumber) {
		this.completed = 1; // 该城市收集到的硬币种类数
		this.belong = b; // 该点属于哪个国家
		this.coin = new int[countrysNumber]; // 该点的 inedx 国家硬币收集数
		this.coin[b] = 1000000; // 本国硬币初始为 100W
	}
}
class Country {
	String name;
	int x1, x2, y1, y2, completed; // 该国家完成收集的城市数
	Country (String name, int x1, int y1, int x2, int y2, int countrysNumber) {
		this.name = name;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.completed = 0;
	}
	boolean check(int day) {
		System.out.println("   " + name + " " + day);
		return completed == (x2 - x1) * (y2 - y1);
	}
}


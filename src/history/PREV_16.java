package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_16 {
	static double width, height, angle;
	static int number;
	static Round[] cloud;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		height = Double.parseDouble(arr[0]);
		width = Double.parseDouble(arr[1]);
		angle = Double.parseDouble(buf.readLine());
		number = Integer.parseInt(buf.readLine());
		cloud = new Round[number];
		for (int i = 0; i < number; i++) {
			arr = buf.readLine().split(" ");
			cloud[i] = new Round(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]));
		}
		buf.close();
	}
	static double getArea(Round r1, Round r2) {
		// 计算两圆面积
		double result = Math.PI * (Math.pow(r1.radius, 2) + Math.pow(r2.radius, 2));
		double distence = Math.sqrt(Math.pow(r1.y - r2.y, 2) + Math.pow(r1.x - r2.x, 2)); // 圆心距离
		if (distence < r1.radius + r2.radius) { // 如果两圆有相交
			// 减去交叉部分
			double triangle1, triangle2, arc1, arc2; // 三角形面积、圆弧面积
			double angle1, angle2; // 圆弧角度
			double cosA = (Math.pow(r1.radius, 2) + Math.pow(distence, 2) - Math.pow(r2.radius, 2)) / (2 * r1.radius * distence);
			angle1 = Math.acos(cosA) * 2;
			arc1 = Math.PI * Math.pow(r1.radius, 2) * angle1 / 360;
			triangle1 = 0.5 * r1.radius * r1.radius * Math.sin(angle1);
			result += (arc1 - triangle1);
		}
		return result;
	}
}
class Round{
	double radius, x, y, z; // 圆的半径、圆心 X 坐标、圆心 Y 坐标
	Round (double x, double y, double z, double r) {
		this.radius = r;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

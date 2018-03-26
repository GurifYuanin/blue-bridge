package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_18 {
	static int pointNumber;
	static double radius;
	static Point[] points;
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		pointNumber = Integer.parseInt(arr[0]);
		radius = Double.parseDouble(arr[1]);
		points = new Point[pointNumber];
		for (int i = 0; i < pointNumber; i++) {
			arr = buf.readLine().split(" ");
			double x = Double.parseDouble(arr[0]);
			double y = Double.parseDouble(arr[1]);
			points[i] = new Point(x, y);
		}
		buf.close();
		
		double distence = (points[1].y - points[0].y);
		double allAngel = 0;
		Point lastPoint, thisPoint, nextPoint;
		double lastK, nextK;
		lastPoint = points[0];
		thisPoint = points[1];
		for (int i = 2; i < pointNumber - 1; i++) {
			nextPoint = points[i];
			lastK = getK(lastPoint, thisPoint);
			nextK = getK(thisPoint, nextPoint);
			if (lastK == 1 && nextK < 0) {
				double angel = Math.atan(Math.abs(nextPoint.y - thisPoint.y) / Math.abs(nextPoint.x - nextPoint.x));
				allAngel += angel;
				if (i + 1 < pointNumber) {
					Point tmp = points[i + 1];
					double tmpK = getK(nextPoint, tmp);
					if (tmpK > 0) {
//						然后就没有然后了
					}
				}
			}
			
		}
	}
	
	static double getK(Point a, Point b) {
		return (b.y - a.y) / (b.x - a.x);
	}
}
class Point{
	double x, y;
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

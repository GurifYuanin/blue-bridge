package improve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADV_256 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine());
		Mountain[] mountains = new Mountain[number];
		for (int i = 0; i < number; i++) {
			String[] arr = buf.readLine().split(" ");
			int offset = Integer.parseInt(arr[0]);
			int height = Integer.parseInt(arr[1]);
			int width = Integer.parseInt(arr[1]);
			mountains[i] = new Mountain(offset, height, width);
		}
		buf.close();
		
		double sum = 0;
		for (int i = 0; i < number; i++) {
			sum += (mountains[i].border * 2);
		}
		for (int i = 1; i < number; i++) {
			if (mountains[i].offset - mountains[i - 1].offset < (mountains[i].width + mountains[i - 1].width) / 2) {
				int w = (mountains[i - 1].width + mountains[i].width) / 2 - (mountains[i].offset - mountains[i - 1].offset);
				int b = w * mountains[i - 1].width * mountains[i].height / (mountains[i - 1].height * mountains[i].width + mountains[i].height * mountains[i - 1].width);
				int h = 2 * b * mountains[i - 1].height / mountains[i - 1].width;
				sum -= Math.sqrt(b * b + h * h);
				sum -= Math.sqrt((w - b) * (w - b)+ h * h);
			}
		}
		System.out.print((int)sum);
	}
}
class Mountain{
	int offset, height, width;
	double border;
	Mountain (int offset, int height, int width) {
		this.offset = offset;
		this.height = height;
		this.width = width;
		this.border = Math.sqrt((width / 2) * (width / 2) + height * height);
	}
}
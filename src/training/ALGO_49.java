package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_49 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(buf.readLine());
		String[] arr = buf.readLine().split(" ");
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < length; i++) {
			if (max < Integer.parseInt(arr[i])) {
				max = Integer.parseInt(arr[i]);
				index = i;
			}
		}
		System.out.println(max + " " + index);
		buf.close();
	}
}

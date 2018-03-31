package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_81 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(buf.readLine().trim());
		int sum = 0;
		String[] arr = buf.readLine().split(" ");
		buf.close();
		for (int i = 0; i < length; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		System.out.println(sum + " " + (sum / length));
	}
}

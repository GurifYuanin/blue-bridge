package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic_14 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(buf.readLine());
		String[] arr = buf.readLine().split(" ");
		int target = Integer.parseInt(buf.readLine());
		buf.close();
		
		for (int i = 0; i < length; i++) {
			if (Integer.parseInt(arr[i]) == target) {
				System.out.println(i + 1);
				return;
			}
		}
		System.out.println(-1);
	}
}

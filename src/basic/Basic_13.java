package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Basic_13 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine());
		if (number == 0) {
			return;
		}
		String[] stringArr = buf.readLine().split(" ");
		int[] arr= new int[number];
		for (int i = 0; i < number; i++) {
			arr[i] = Integer.parseInt(stringArr[i]);
		}
		buf.close();
		
		Arrays.sort(arr);
		System.out.print(arr[0]);
		for (int i = 1; i < number; i++) {
			System.out.print(" " + arr[i]);
		}
	}
}

package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_133 {
	static char[] arr;
	static int ACLength = 0, BLength, Bindex;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().toCharArray();
		buf.close();
		
		boolean A = false;
		int i = 0, j = arr.length - 1;
		while (i < j) {
			if (arr[i] != arr[j]) {
				if (!A) {
					i++;
				} else {
					break;
				}
			} else {
				i++;
				j--;
				ACLength++;
				A = true;
			}
		}
		if (i >= j) {
			System.out.println(1);
			if (!A) {
				System.out.println(1 + " " + arr.length);
			} else {
				System.out.println(i - ACLength + 1 + " " + arr.length);
			}
		} else {
			BLength = 1;
			Bindex = i + 1;
			for (int m = i + 1; m < j; m++) {
				count(i, j, m);
			}
			System.out.println(3);
			System.out.println(i - ACLength + 1 + " " + ACLength);
			System.out.println(Bindex + " " + BLength);
			System.out.println(j + 2 + " " + ACLength);
		}
	}
	static void count(int start, int end, int now) {
		int result = 1;
		for (int i = now - 1, j = now + 1; i >= start && j <= end && arr[i] == arr[j]; i--, j++) {
			result += 2;
		}
		if (result > BLength) {
			BLength = result;
			Bindex = now - result / 2 + 1;
		}
	}
}

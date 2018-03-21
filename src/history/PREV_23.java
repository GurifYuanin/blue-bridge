package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_23 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		long peopleNumber = Integer.parseInt(arr[0]);
		long mod = Integer.parseInt(arr[1]);
		long time = Integer.parseInt(arr[2]);
		buf.close();
		
		long sum = 1;
		for (long i = 1, last = 1, tmp; i < time; i++) {
			tmp = last + ((i - 1) * peopleNumber + 1 + i * peopleNumber) * peopleNumber / 2;
			tmp %= mod;
			sum += tmp;
			last = tmp;
			
		}
		System.out.print(sum);
	}
}

package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PREV_29 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		BigInteger mod = new BigInteger(arr[2]);
		
		int max = Math.max(n, m);
		BigInteger[] fib = new BigInteger[max + 1];
		fib[0] = fib[1] = fib[2] = new BigInteger("1");
		for (int i = 3; i <= max; i++) {
			fib[i] = fib[i - 1].add(fib[i - 2]);
		}
		
		BigInteger sum = new BigInteger("0");
		for (int i = 1; i <= n; i++) {
			sum = sum.add(fib[i]);
		}
		System.out.print(sum.remainder(fib[m]).remainder(mod).toString());
	}
}

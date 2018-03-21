package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PREV_20 {
	static long p = 999101;
	static BigInteger P = new BigInteger("999101");
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		BigInteger n = new BigInteger(buf.readLine());
		BigInteger m = new BigInteger(buf.readLine());
		BigInteger k = new BigInteger(buf.readLine());
		buf.close();
		System.out.print(Lucas(n, m));
	}
	static BigInteger Lucas(BigInteger n, BigInteger m) {
		if (m.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		} else {
			return BigInteger.valueOf(Cnm(n.mod(P).longValue(), m.mod(P).longValue())).multiply(Lucas(n.divide(P), m.divide(P))).mod(P);
		}
	}
	static long Cnm(long n, long m) {
		return Hierarchy(n, n - m + 1) / Hierarchy(1, m);
	}
	static long Hierarchy(long start, long end) {
		long sum = 1;
		for (; start <= end; start++) {
			sum *= start;
			sum %= p;
		}
		return sum;
	}
}

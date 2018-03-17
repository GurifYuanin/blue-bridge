package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_1 {
	static int g1, g2, g3;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String arr[] = buf.readLine().split(" ");		
		buf.close();
		
		g1 = Integer.parseInt(arr[0]);
		g2 = Integer.parseInt(arr[1]);
		g3 = Integer.parseInt(arr[2]);
		int max = g1 * g2 * g3;
		int min = Math.min(g1, Math.min(g2, g3));
		for (int i = min; i <= max; i++) {
			if (i % g1 == 0 && i % g2 == 0 && i % g3 ==0) {
				System.out.print(i);
				return;
			}
		}
	}
}

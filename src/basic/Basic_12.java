package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic_12 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine());
		for (int i = 0; i < number; i++) {
			System.out.println(String.format("%o", Integer.valueOf(buf.readLine(), 16)));
		}
		buf.close();
	}
}

package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Basic_11{
	public static void main(String[] args)throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String string = buf.readLine();
		if (string.length() <= 7) {
			System.out.print(Integer.parseInt(string, 16));
		} else {
			String result = String.valueOf(Integer.parseInt(string.substring(1,8) ,16) + map(string.charAt(0)) * Math.pow(16, 7));
			int pow = map(result.charAt(result.length() - 1)) + 1;
			for (int i = 0; i < pow; i++) {
				if (result.charAt(i) == 46) {
					pow++;
				} else {
					System.out.print(result.charAt(i));
				}
			}
		}
		buf.close();
	}
	static int map (char c) {
		switch (c) {
		case '0': return 0;
		case '1': return 1;
		case '2': return 2;
		case '3': return 3;
		case '4': return 4;
		case '5': return 5;
		case '6': return 6;
		case '7': return 7;
		case '8': return 8;
		case '9': return 9;
		case 'a': return 10;
		case 'A': return 10;
		case 'b': return 11;
		case 'B': return 11;
		case 'c': return 12;
		case 'C': return 12;
		case 'd': return 13;
		case 'D': return 13;
		case 'e': return 14;
		case 'E': return 14;
		case 'f': return 15;
		case 'F': return 15;
		}
		return 0;
	}
}
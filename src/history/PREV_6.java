package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_6 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String str = buf.readLine();
		char[] ch1 = str.toCharArray();
		str = buf.readLine();
		char[] ch2 = str.toCharArray();
		buf.close();
		
		int length = ch1.length - 1;
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (ch1[i] != ch2[i]) {
				ch1[i] = swap(ch1[i]);
				ch1[i + 1] = swap(ch1[i + 1]);
				count++;
			}
		}
		System.out.println(count);
	}
	static char swap(char c) {
		char result = '\0';
		switch (c) {
		case '*': result = 'o'; break;
		case 'o': result = '*'; break;
		}
		return result;
	}
}

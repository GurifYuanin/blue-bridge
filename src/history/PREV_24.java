package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_24 {
	static int peopleNumber, mailboxNumber, needNumber;
	static double min = Double.MAX_VALUE;
	static People[] people;
	static Mailbox[] mailbox;
	static double[][] distence;
	static boolean[] isBuild;
	static String result = null;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		peopleNumber = Integer.parseInt(arr[0]);
		mailboxNumber = Integer.parseInt(arr[1]);
		needNumber = Integer.parseInt(arr[2]);
		people = new People[peopleNumber];
		mailbox = new Mailbox[mailboxNumber];
		distence = new double[peopleNumber][mailboxNumber];
		isBuild = new boolean[mailboxNumber];
		for (int i = 0; i < peopleNumber; i++) {
			arr = buf.readLine().split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			people[i] = new People(x, y);
		}
		for (int i = 0; i < mailboxNumber; i++) {
			arr = buf.readLine().split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			mailbox[i] = new Mailbox(x, y);
		}
		buf.close();
		
		for (int i = 0; i < peopleNumber; i++) {
			for (int j = 0; j < mailboxNumber; j++) {
				distence[i][j] = getDistence(people[i], mailbox[j]);
			}
		}
		dfs(0, 0);
		System.out.print(result.trim());
	}
	static double getDistence(People p, Mailbox m) {
		return Math.sqrt(Math.pow(p.x - m.x, 2) + Math.pow(p.y - m.y, 2));
	}
	static void dfs(int start, int buildedNumber) {
		if (buildedNumber == needNumber) {
			double sum = 0;
			for (int i = 0; i < peopleNumber; i++) {
				double tmp = Double.MAX_VALUE;
				for (int j = 0; j < mailboxNumber; j++) {
					if (isBuild[j] && tmp > distence[i][j]) {
						tmp = distence[i][j];
					}
				}
				sum += tmp;
			}
			if (sum < min) {
				min = sum;
				result = "";
				for (int i = 0; i < mailboxNumber; i++) {
					if (isBuild[i]) {
						result += (i + 1) + " ";
					}
				}
			}
		} else {
			for (int i = start; i < mailboxNumber; i++) {
				if (!isBuild[i]) {
					isBuild[i] = true;
					dfs(i, buildedNumber + 1);
					isBuild[i] = false;
				}
			}
		}
	}
}
class People{
	int x, y;
	People (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class Mailbox{
	int x, y;
	Mailbox (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

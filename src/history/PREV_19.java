package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class PREV_19 {
	static String origin, dest;
	static HashSet<String> set = new HashSet<String>();
	static LinkedList<QuickShot> list = new LinkedList<QuickShot>();
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		origin = buf.readLine();
		dest = buf.readLine();
		buf.close();
		
		int currentPosition = origin.indexOf('.');
		list.add(new QuickShot(currentPosition % 3, currentPosition / 3, 0, origin));
		set.add(origin);
		while (!list.isEmpty()) {
			QuickShot current = list.removeFirst();
			if (current.status.equals(dest)) {
				System.out.print(current.count);
				return;
			}
			currentPosition = current.y * 3 + current.x;
			for (int i = -3; i <= 3; i += 2) {
				int nextPosition = currentPosition + i;
				if (nextPosition >= 0 && nextPosition <= 8) {
					int count = current.count + 1;
					String status = current.status;
					char ch = status.charAt(nextPosition);
					status = status.replace(ch, 'a');
					status = status.replace('.', ch);
					status = status.replace('a', '.');
					if (!set.contains(status)) {
						set.add(status);
						list.add(new QuickShot(nextPosition % 3, nextPosition / 3, count, status));
					}
				}
			}
		}
		System.out.print(-1);
	}
}
class QuickShot{
	int x, y;
	int count;
	String status;
	QuickShot(int x, int y, int c, String s) {
		this.x = x;
		this.y = y;
		this.count = c;
		this.status = s;
	}
}

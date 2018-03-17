package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class PREV_10 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		int min = Integer.parseInt(arr[0]);
		int max = Integer.parseInt(arr[1]);
		int count = 0;
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1, j = 1; j < 1000000; i++, j += 2) {
			if (i % 3 != 0) {
				list.add(j);
			}
		}
		int size = list.size();
		for (int i = 1, j ; i <= size; i++) {
			j = list.removeFirst();
			if (i % 7 != 0) {
				list.add(j);
			}
		}
		Iterator<Integer> ite = list.iterator();
		while (ite.hasNext()) {
			int number = (int) ite.next();
			if (number > min) {
				count++;
				break;
			}
		}
		while (ite.hasNext()) {
			int number = (int) ite.next();
			if (number < max) {
				count++;
			} else {
				break;
			}
		}
		System.out.print(count);
	}
}

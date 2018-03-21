package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PREV_22 {
	static boolean[][] connect;
	static int island, path;
	static boolean[] isVisited;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		island = Integer.parseInt(arr[0]);
		path = Integer.parseInt(arr[1]);
		connect = new boolean[island][island];
		isVisited = new boolean[island];
		HashMap<Integer, LinkedList<Link>> map = new HashMap<Integer, LinkedList<Link>>();
		for (int i = 0; i < path; i++) {
			arr = buf.readLine().split(" ");
			int island1 = Integer.parseInt(arr[0]) - 1;
			int island2 = Integer.parseInt(arr[1]) - 1;
			int day = Integer.parseInt(arr[2]);
			connect[island1][island2] = connect[island2][island1] = true;
			if (!map.containsKey(day)) {
				LinkedList<Link> list = new LinkedList<Link>();
				list.add(new Link(island1, island2));
				map.put(day, list);
			} else {
				map.get(day).add(new Link(island1, island2));
			}
		}
		buf.close();

		/*
		for (int i = 0; i < island; i++) {
			for (int j = 0; j < island; j++) {
				System.out.print(connect[i][j] + " ");
			}
			System.out.println();
		}
		*/
		int sum = 0, count;
		List<Map.Entry<Integer,LinkedList<Link>>> l = new ArrayList<Map.Entry<Integer,LinkedList<Link>>>(map.entrySet());
		// Iterator<Entry<Integer, LinkedList<Link>>> ite = map.entrySet().iterator();
		Collections.sort(l, new Comparator<Map.Entry<Integer,LinkedList<Link>>>() {
			@Override
			public int compare(Entry<Integer, LinkedList<Link>> o1, Entry<Integer, LinkedList<Link>> o2) {
				// TODO Auto-generated method stub
				return o1.getKey() - o2.getKey();
			}
		});
		Iterator<Entry<Integer, LinkedList<Link>>> ite = l.iterator();
		while (ite.hasNext()) {
			count = 0;
			Iterator<Link> listIte = ite.next().getValue().iterator();
			while (listIte.hasNext()) {
				Link tmp = (Link) listIte.next();
				int island1 = tmp.island1;
				int island2 = tmp.island2;
				connect[island1][island2] = connect[island2][island1] = false;
				if (!isConnect(island1, island2)) {
					count++;
				}
			}
			if (count > 0) {
				sum++;
			}
		}
		System.out.print(sum);
	}
	static boolean isConnect(int index1, int index2) {
		if (connect[index1][index2]) {
			return true;
		} else {
			boolean flag = false;
			for (int i = 0; i < island; i++) {
				if (!isVisited[i] && connect[index1][i]) {
					isVisited[i] = true;
					flag = flag || isConnect(i, index2);
					isVisited[i] = false;
				}
			}
			return flag;
		}
		
	}
}
class Link{
	int island1, island2;
	Link(int i1, int i2) {
		this.island1 = i1;
		this.island2 = i2;
	}
}

package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class PREV_25 {
	static int cityNumber, pathNumber, result = Integer.MAX_VALUE;
	static int[] pre, dock;
	static boolean[] isVisited;
	static boolean[][] connect;
	static LinkedList<Path> path;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		cityNumber = Integer.parseInt(arr[0]);
		pathNumber = Integer.parseInt(arr[1]);
		path = new LinkedList<Path>();
		pre = new int[cityNumber + 1];
		for (int i = 0; i < pathNumber; i++) {
			arr = buf.readLine().split(" ");
			int city1 = Integer.parseInt(arr[0]);
			int city2 = Integer.parseInt(arr[1]);
			int cost = Integer.parseInt(arr[2]);
			path.add(new Path(city1, city2, cost));
		}
		kruskal();
		arr = buf.readLine().split(" ");
		for (int i = 0; i < cityNumber; i++) {
			int tmp = Integer.parseInt(arr[i]);
			if (tmp != -1) {
				path.add(new Path(0, i + 1, tmp));
			}
		}
		kruskal();
		buf.close();
		
		System.out.print(result);
	}


	static int find (int index) {
		while (pre[index] != index) {
			index = pre[index];
		}
		return index;
	}
	static void union (int index1, int index2) {
		int root1 = find(index1);
		int root2 = find(index2);
		if (root1 != root2) {
			pre[root1] = root2;
		}
	}
	static boolean isConnect(int index1, int index2) {
		return find(index1) == find(index2);
	}
	static void init(int length) {
		for (int i = 0; i < length; i++) {
			pre[i] = i;
		}
	}
	static void kruskal() {
		Collections.sort(path, new Comparator<Path>() {
			public int compare(Path o1, Path o2) {
				return o1.cost - o2.cost;
			}
		});
		init(cityNumber + 1);
		int length = path.size();
		int consume = 0, dockNumber = 0;
		float count = cityNumber;
		for (int i = 0; i < length; i++) {
			int city1 = path.get(i).city1;
			int city2 = path.get(i).city2;
			int cost = path.get(i).cost;
			if (!isConnect(city1, city2) && count > 1) {
				consume += cost;
				union(city1, city2);
				if (city1 == 0 || city2 == 0) {
					if (dockNumber > 0) {
						count--;
					}
					dockNumber++;
				} else {
					count--;
				}
			} else if (cost < 0) {
				consume += cost;
			} else if (count == 1 && cost > 0) {
				break;
			}
		}
		if (count == 1 && dockNumber != 1) {
			result = Math.min(result, consume);
		}
	}
}
class Path{
	int city1, city2, cost;
	Path(int c1, int c2, int c) {
		this.city1 = c1;
		this.city2 = c2;
		this.cost = c;
	}
}

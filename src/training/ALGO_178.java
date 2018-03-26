package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class ALGO_178 {
	static int cityNumber, pathNumber, peopleNumber, target, distence = 0;
	static int[] id, pre;
	static int[][] path;
	static LinkedList<Path> list = new LinkedList<Path>(); // 路径链表
	static HashSet<String> set = new HashSet<String>(); // 可以选择的路径集合
	static String[] output; // 路径输出数组
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		cityNumber = Integer.parseInt(arr[0]);
		target = Integer.parseInt(arr[1]);
		pathNumber = Integer.parseInt(arr[2]);
		id = new int[cityNumber]; // 城市的所属 id
		pre = new int[cityNumber]; // 最短路径的前一个节点
		path = new int[cityNumber][cityNumber]; // 邻接矩阵表示城市之间的距离
		Arrays.fill(id, -1);
		for (int i = 0; i < cityNumber; i++) {
			Arrays.fill(path[i], Integer.MAX_VALUE);
			path[i][i] = 0; // 自身到自身的距离为 0
		}
		for (int i = 0; i < pathNumber; i++) {
			arr = buf.readLine().split(" ");
			Path p = new Path(Integer.parseInt(arr[0]) - 1, Integer.parseInt(arr[1]) - 1, Integer.parseInt(arr[2]));
			list.add(p);
		}
		Collections.sort(list, new Comparator<Path>() {
			public int compare(Path o1, Path o2) {
				return o1.distence - o2.distence;
			}
		});
		kruscal();
		peopleNumber = Integer.parseInt(buf.readLine());
		arr = buf.readLine().split(" ");
		output = new String[peopleNumber]; // 输出内容
		for (int i = 0; i < peopleNumber; i++) {
			Arrays.fill(pre, -1);
			dijkstra(Integer.parseInt(arr[i]) - 1);
			int tmp = target - 1;
			int last = tmp;
			output[i] = (tmp + 1) + "";
			while ((tmp = pre[tmp]) != -1) {
				String r = tmp + "-" + last;
				if (!set.contains(r)) {
					set.add(r);
					distence += path[tmp][last];
				}
				output[i] = (tmp + 1) + "-" + output[i];
				last = tmp;
			}
		}
		System.out.println("distence = " + distence);
		for (int i = 0; i < peopleNumber; i++) {
			System.out.println(output[i]);
		}
		buf.close();
	}
	static void dijkstra(int start) {
		boolean[] isVisited = new boolean[cityNumber];
		int[] dis = new int[cityNumber];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0; // 自身到自身的距离为 0 
		for (int i = 0; i < cityNumber; i++) {
			int index = start;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < cityNumber; j++) { // 找出最近的未遍历过的节点
				if (!isVisited[j] && min > dis[j]) {
					min = dis[j];
					index = j;
				}
			}
			isVisited[index] = true; // 标记为已遍历
			for (int j = 0; j < cityNumber; j++) {
				if (!isVisited[j] && path[index][j] < Integer.MAX_VALUE && dis[j] > dis[index] + path[index][j]) {
					dis[j] = dis[index] + path[index][j];
					pre[j] = index;
				}
			}
		}
	}
	static void kruscal () {
		int count = cityNumber; // 独立集合数量
		Iterator<Path> ite = list.iterator();
		while (ite.hasNext() && count > 1) {
			Path p = ite.next();
			int city1 = p.city1;
			int city2 = p.city2;
			if (!isConnected(city1, city2)) { // 判断两城市是否已经连通
				path[city1][city2] = path[city2][city1] = p.distence;
				count--;
			}
		}
	}
	static void union(int index1, int index2) {
		int root1 = find(index1);
		int root2 = find(index2);
		if (root1 != root2) {
			id[root1] = root2;
		}
	}
	static boolean isConnected(int index1, int index2) {
		return find(index1) == find(index2);
	}
	static int find(int index) {
		while (id[index] != -1) {
			index = id[index];
		}
		return index;
	}
}

class Path {
	int city1, city2, distence;
	Path(int c1, int c2, int d) {
		this.city1 = c1;
		this.city2 = c2;
		this.distence = d;
	}
}
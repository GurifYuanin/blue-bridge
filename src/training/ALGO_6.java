package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class ALGO_6 {
	static int nodeNumber, pathNumber;
	static int[] time; // 每个牧场需要停留的时间
	static int[] id;
	static Road[] roads;
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		nodeNumber = Integer.parseInt(arr[0]);
		pathNumber = Integer.parseInt(arr[1]);
		time = new int[nodeNumber];
		id = new int[nodeNumber];
		roads = new Road[pathNumber];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nodeNumber; i++) {
			time[i] = Integer.parseInt(buf.readLine());
			if (min > time[i]) {
				min = time[i];
			}
		}
		for (int i = 0; i < pathNumber; i++) {
			arr = buf.readLine().split(" ");
			int n1 = Integer.parseInt(arr[0]) - 1;
			int n2 = Integer.parseInt(arr[1]) - 1;
			int dis = Integer.parseInt(arr[2]);
			roads[i] = new Road(n1, n2, dis);
			roads[i].setWeight(time[n1], time[n2]);
		}
		buf.close();
		
		sortRoads(roads);
		Arrays.fill(id, -1);
		/*
		for (int i = 0; i < nodeNumber; i++) {
			id[i] = i;
		}
		*/
		System.out.print(krusal() + min);
	}
	static void sortRoads(Road[] roads) {
		for (int i = 1; i < pathNumber; i++) {
			for (int j = pathNumber - i; j > 0; j--) {
				if (roads[j - 1].weight > roads[j].weight) {
					Road tmp = roads[j - 1];
					roads[j - 1] = roads[j];
					roads[j] = tmp;
				}
			}
		}
	}
	static int find(int index) {
		/*
		while (index != id[index]) {
			index = id[index];
		}
		return index;
		*/
		int result = index;
		while (id[result] >= 0) {
			result = id[result];
		}
		int tmp;
		while (index != result) {
			tmp = id[index];
			id[index] = result;
			index = tmp;
		}
		return result;
	}
	static boolean isConnect(int index1, int index2) {
		return find(index1) == find(index2);
	}
	static void union(int index1, int index2) {
		int root1 = find(index1);
		int root2 = find(index2);
		/*
		if (root1 != root2) {
			id[root1] = root2;
		}
		*/
		int num = id[root1] + id[root2];
		if (id[root1] < id[root2]) {
			id[root2] = root1;
			id[root1] = num;
		} else{
			id[root1] = root2;
			id[root2] = num;
		}
	}
	static int krusal() {
		int sum = 0; // 总花费时间
		int count = nodeNumber; // 独立集的个数
		for (int i = 0; i < pathNumber && count > 1; i++) {
			Road tmp = roads[i];
			int node1 = tmp.node1;
			int node2 = tmp.node2;
			if (!isConnect(node1, node2)) {
				sum += tmp.weight;
				union(node1, node2);
				count--;
			}
		}
		return sum;
	}
}
class Road {
	int node1, node2, distence, weight;
	Road (int n1, int n2, int dis) {
		this.node1 = n1;
		this.node2 = n2;
		this.distence = dis;
	}
	void setWeight(int time1, int time2) {
		this.weight = 2 * this.distence + time1 + time2; 
	}
}

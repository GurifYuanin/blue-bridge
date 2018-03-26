package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class ALGO_5 {
	static int UNCONNECT = 10000000;
	static int nodeNumber, pathNumber;
	static int[][] path;
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		nodeNumber = Integer.parseInt(arr[0]);
		pathNumber = Integer.parseInt(arr[1]);
		path = new int[nodeNumber][nodeNumber];
		for (int i = 0; i < nodeNumber; i++) {
			Arrays.fill(path[i], UNCONNECT);
		}
		for (int i = 0; i < pathNumber; i++) {
			arr = buf.readLine().split(" ");
			int a = Integer.parseInt(arr[0]) - 1;
			int b = Integer.parseInt(arr[1]) - 1;
			path[a][b] = Integer.parseInt(arr[2]);
		}
		
		buf.close();
//		int[] result = dijkstra(0);
		int[] result = spfa(0);
		for (int i = 1; i < nodeNumber; i++) {
			System.out.println(result[i]);
		}
	}
	static int[] spfa(int index) {
		int[] value = new int[nodeNumber];
		boolean[] isInList = new boolean[nodeNumber];
		Arrays.fill(value, UNCONNECT);
		LinkedList<Integer> list = new LinkedList<Integer>();
		value[0] = 0;
		list.add(index);
		isInList[index] = true;
		while (!list.isEmpty()) {
			int tmp = list.remove();
			isInList[tmp] = false;
			for (int i = 0; i < nodeNumber; i++) {
				if (value[i] > value[tmp] + path[tmp][i]) {
					value[i] = value[tmp] + path[tmp][i];
					if (!isInList[i]) {
						list.add(i);
						isInList[i] = true;
					}
				}
			}
		}
		return value;
	}
	static int[] dijkstra(int index) {
		int[] value = new int[nodeNumber];
		boolean[] isVisited = new boolean[nodeNumber];
		for (int i = 0; i < nodeNumber; i++) {
			value[i] = path[index][i];
		}
		for (int i = 0; i < nodeNumber; i++) {
			int min = UNCONNECT, current = index;
			for (int j = 0; j < nodeNumber; j++) {
				if (min > value[i] && !isVisited[i]) {
					min = value[i];
					current = i;
				}
			}
			isVisited[current] = true;
			for (int j = 0; j < nodeNumber; j++) {
				if (path[current][j] < UNCONNECT && value[current] < UNCONNECT && !isVisited[j] && value[j] > value[current] + path[current][j]) {
					value[j] = value[current] + path[current][j];
				}
			}
		}
		return value;
	}
}

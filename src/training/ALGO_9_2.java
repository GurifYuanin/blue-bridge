package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_9_2 {
	/*
	 * 使用线段树解法
	 * */
	static int length, operation; // 数据长度、操作次数
	static int[] weight; // 数据权值
	static int[] maxTree, sumTree; // 线段树
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		length = Integer.parseInt(arr[0]);
		operation = Integer.parseInt(arr[1]);
		weight = new int[length];
		maxTree = new int[length * 4];
		sumTree = new int[length * 4];
		arr = buf.readLine().split(" ");
		for (int i = 0; i < length; i++) {
			weight[i] = Integer.parseInt(arr[i]);
		}
		createTree(0, 0, length - 1);
		for (int i = 0; i < operation; i++) {
			arr = buf.readLine().split(" ");
			int option = Integer.parseInt(arr[0]);
			int x = Integer.parseInt(arr[1]) - 1;
			int y = Integer.parseInt(arr[2]) - 1;
			switch(option) {
			case 1:{
				update(0, 0, length - 1, x, y + 1);
				break;
			}
			case 2:{
				System.out.println(query(0, x, y, 0, length - 1, false));
				break;
			}
			case 3:{
				System.out.println(query(0, x, y, 0, length - 1, true));
				break;
			}
			}
		}
	}
	static void createTree (int index, int start, int end) {
		if (start == end) {
			maxTree[index] = sumTree[index] = weight[start];
		} else {
			int mid = (start + end) / 2;
			createTree(2 * index + 1, start, mid);
			createTree(2 * index + 2, mid + 1, end);
			maxTree[index] = Math.max(maxTree[2 * index + 1], maxTree[2 * index + 2]);
			sumTree[index] = sumTree[2 * index + 1] + sumTree[2 * index + 2];
		}
	}
	static int query(int index, int queryStart, int queryEnd, int dateStart, int dateEnd, boolean flag) {
		if (queryStart > dateEnd || queryEnd < dateStart) {
			if (flag) {
				return Integer.MIN_VALUE;
			} else {
				return 0;
			}
		}
		if (queryStart <= dateStart && queryEnd >= dateEnd) {
			if (flag) {
				return maxTree[index];
			} else {
				return sumTree[index];
			}
		}
		int mid = (dateStart + dateEnd) / 2;
		if (flag) {
			return Math.max(query(2 * index + 1, queryStart, queryEnd, dateStart, mid, flag),
					query(2 * index + 2, queryStart, queryEnd, mid + 1, dateEnd, flag));
		} else {
			return query(2 * index + 1, queryStart, queryEnd, dateStart, mid, flag)+
					query(2 * index + 2, queryStart, queryEnd, mid + 1, dateEnd, flag);
		}
		
	}
	static void update(int index, int start, int end, int target, int value) {
		if (start == end) {
			if (start == target) {
				maxTree[index] = sumTree[index] = value;
			}
		} else {
			int mid = (start + end) / 2;
			if (target <= mid) {
				update(2 * index + 1, start, mid, target, value);
			} else{
				update(2 * index + 2, mid + 1, end, target, value);
			}
			maxTree[index] = Math.max(maxTree[2 * index + 1], maxTree[2 * index + 2]);
			sumTree[index] = sumTree[2 * index + 1] + sumTree[2 * index + 2];
		}
	}
}

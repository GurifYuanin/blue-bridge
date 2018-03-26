package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_4 {
	static int nodeNumber;
	static int[] weight;
	static int[][] dp;
	static boolean[][] path;
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		nodeNumber = Integer.parseInt(buf.readLine());
		weight = new int[nodeNumber];
		path = new boolean[nodeNumber][nodeNumber];
		dp = new int[nodeNumber][2];
		String[] arr = buf.readLine().split(" ");
		for (int i = 0; i < nodeNumber; i++) {
			weight[i] = Integer.parseInt(arr[i]);
		}
		for (int i = 1; i < nodeNumber; i++) {
			arr = buf.readLine().split(" ");
			int node1 = Integer.parseInt(arr[0]) - 1;
			int node2 = Integer.parseInt(arr[1]) - 1;
			path[node1][node2] = path[node2][node1] = true;
		}
		buf.close();
		dfs(-1, 0);
		int max = Math.max(dp[0][0], dp[0][1]);
		System.out.print(max);
	}
	static void dfs(int from, int index) {
		boolean flag = true;
		for (int i = 0; i < nodeNumber; i++) {
			if (i != from && path[index][i]) {
				dfs(index, i);
				flag = false;
			}
		}
		if (flag) { // 如果是叶子节点
			dp[index][0] = 0;
			dp[index][1] = weight[index];
		} else {
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < nodeNumber; i++) {
				if (path[index][i]) {
					sum1 += Math.max(dp[i][0], dp[i][1]);
					sum2 += dp[i][0];
				}
			}
			dp[index][0] = sum1;
			dp[index][1] = weight[index] + sum2;
		}
	}
}

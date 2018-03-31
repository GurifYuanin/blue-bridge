package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_122 {
	static int returnNumber, rentNumber;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		buf.close();
		int caseNumber;
		returnNumber = Integer.parseInt(arr[0]);
		rentNumber = Integer.parseInt(arr[1]);
		if (returnNumber < rentNumber) {
			caseNumber = 0;
		} else {
			caseNumber = dfs(returnNumber, rentNumber);
		}
		System.out.println(caseNumber);
	}
	static int dfs(int returnNum, int rentNum) {
		if (returnNum == 0 || rentNum == 0) {
			return 1;
		}
		if (returnNumber - returnNum == rentNumber - rentNum) {
			return dfs(returnNum - 1, rentNum);
		}
		if (returnNumber - returnNum > rentNumber - rentNum) {
			return dfs(returnNum - 1, rentNum) + dfs(returnNum, rentNum - 1);
		}
		return 0;
	}
}

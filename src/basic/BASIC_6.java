package basic;

import java.util.Scanner;

public class BASIC_6 {
	public static void main(String[] args) {
		int row = (new Scanner(System.in)).nextInt();
		int[][] tri = new int[row][row];
		for (int i = 0; i < row; i++) {
			tri[i][0] = 1;
			tri[i][i] = 1;
		}
		for (int i = 2; i < row; i++) {
			for (int j = 1; j < i; j++) {
				tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
			}
		}
		for (int i = 0; i < row; i++) {
			System.out.print(1);
			for (int j = 1; j <= i; j++) {
				System.out.print(" " + tri[i][j]);
			}
			System.out.println();
		}
	}
}

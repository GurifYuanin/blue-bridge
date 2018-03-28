package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_48 {
	/*
	 * row������ / �ڵ���
	 * col������ / �߶���
	 * �������Ŵ������ҽ����1 ��ʾ���ȵĽڵ㣬-1 ��ʾ��ȵĽڵ�
	 * */
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int row = Integer.parseInt(arr[0]);
		int col = Integer.parseInt(arr[1]);
		int[][] path = new int[row][col];
		for (int i = 0; i < col; i++) {
			arr = buf.readLine().split(" ");
			int a = Integer.parseInt(arr[0]) - 1;
			int b = Integer.parseInt(arr[1]) - 1;
			path[a][i] = 1;
			path[b][i] = -1;
		}
		buf.close();
		
		for (int i = 0; i < row; i++) {
			System.out.print(path[i][0]);
			for (int j = 1; j < col; j++) {
				System.out.print(" " + path[i][j]);
			}
			System.out.println();
		}
	}
}

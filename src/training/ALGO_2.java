package training;

import java.util.Scanner;

public class ALGO_2 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		long N = sca.nextInt();
		sca.close();
		if (N % 2 == 0) {
			if (N % 3 == 0) {
				System.out.print((N - 1) * (N - 2) * (N - 3));
			} else {
				System.out.print(N * (N - 1) * (N - 3));
			}
		} else {
			System.out.print(N * (N - 1) * (N - 2));
		}
	}

}

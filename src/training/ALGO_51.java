package training;

import java.util.Scanner;

public class ALGO_51 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int length = sca.nextInt();
		sca.close();
		
		int sum = 1;
		for (int i = 2, j = 0; j < length; i++) {
			if (is(i)) {
				sum = (sum * i) % 50000;
				j++;
			}
		}
		System.out.println(sum);
	}
	static boolean is(int number) {
		int threshold = (int) Math.sqrt(number);
		for (int i = 2; i <= threshold; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}

package basic;

public class Basic_7 {
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			if (isSpecial(i)) {
				System.out.println(i);
			}
		}
	}
	static boolean isSpecial (int number) {
		int sum = 0, tmp = number;
		while (tmp != 0) {
			sum += Math.pow((tmp % 10), 3);
			tmp /= 10;
		}
		return sum == number;
	}
}

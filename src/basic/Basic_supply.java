package basic;

public class Basic_supply {
	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			if (isPalindrome(i)) {
				System.out.println(i + " " + countSum(i));
			}
		}
	}
	static boolean isPalindrome (int number) {
		boolean result = true;
		String str = String.valueOf(number);
		int length = str.length();
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1)) {
				result = false;
				break;
			}
		}
		return result;
	}
	static int countSum (int number) {
		int result = 0;
		while (number != 0) {
			result += number % 10;
			number /= 10;
		}
		return result;
	}
}

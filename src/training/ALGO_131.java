package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ALGO_131 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine()); // 科学家的数量
		Scientist[] scientist = new Scientist[number];
		String[] arr = null;
		for (int i = 0; i < number; i++) {
			arr = buf.readLine().split(" ");
			scientist[i] = new Scientist(
					Integer.parseInt(arr[0]),
					Integer.parseInt(arr[1]),
					Integer.parseInt(arr[2]),
					Integer.parseInt(arr[3]),
					Integer.parseInt(arr[4])
					);
			scientist[i].code = i + 1;
		}
		buf.close();
		
		sortArr(scientist, number);
		System.out.println(badNumber(scientist, number));
		printArr(scientist, number);
	}
	static void printArr(Scientist[] s, int length) {
		for (int i = 0; i < length; i++) {
			int thes = s[i].problemNumber;
			for (int j = 0; j < thes; j++) {
				System.out.println(s[i].problem[j] + " " + s[i].code);
			}
		}
	}
	
	static void sortArr(Scientist[] s, int length) {
		for (int i = 0; i < length; i++) {
			for (int j = 1; j < length - i; j++) {
				if (s[j - 1].min > s[j].min) {
					Scientist tmp = s[j - 1];
					s[j - 1] = s[j];
					s[j] = tmp;
				}
			}
		}
	}
	static int badNumber(Scientist[] s, int length) {
		int result = 0;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length && s[j].min < s[j - 1].max; j++) {
				result += Arrays.binarySearch(s[i].problem, s[j].min);
			}
		}
		return result;
	}
}
class Scientist{
	int[] problem;
	int problemNumber, min, max, code;
	Scientist(int pNumber, int start, int rate, int inc, int mod){
		problemNumber = pNumber;
		problem = new int[pNumber];
		problem[0] = start;
		for (int i = 1; i < pNumber; i++) {
			problem[i] = (problem[i - 1] * rate + inc) % mod;
		}
		Arrays.sort(problem);
		min = problem[0];
		max = problem[pNumber - 1];
	}
}
package basic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Basic_12_2 {
	static boolean flag;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(buf.readLine());
		int[] oldArr = new int[4];
		int[] newArr = new int[4];
		for (int i = 0; i < count; i++) {
			flag = false;
			Arrays.fill(oldArr, 0);
			Arrays.fill(newArr, 0);
			String str = buf.readLine();
			int length = str.length();
			int old = 3 - 4 *length % 3;
			int j = 0;
			while (j < length) {
				if (old != 0) {
					oldArr = newArr;
					newArr= hexToBin(str.charAt(j++));
				}
				switch (old) {
					case 0: {
						binToPrint("" + newArr[0] + newArr[1] + newArr[2]);
						old = 1;
						break;
					}
					case 1: {
						binToPrint("" + oldArr[3] + newArr[0] + newArr[1]);
						old = 2;
						break;
					}
					case 2: {
						binToPrint("" + oldArr[2] + oldArr[3] + newArr[0]);
						old = 3;
						break;
					}
					case 3: {
						binToPrint("" + oldArr[1] + oldArr[2] + oldArr[3]);
						old = 0;
						break;
					}
				}
			}
			binToPrint("" + newArr[1] + newArr[2] + newArr[3]);
			System.out.println();
		}
		buf.close();
	}
	static int[] hexToBin(char hex) {
		int[] result = {0, 0, 0, 0};
		switch (hex) {
			case '0': break;
			case '1': result[3] = 1; break;
			case '2': result[2] = 1; break;
			case '3': result[3] = 1; result[2] = 1; break;
			case '4': result[1] = 1; break;
			case '5': result[3] = 1; result[1] = 1; break;
			case '6': result[2] = 1; result[1] = 1; break;
			case '7': result[3] = 1; result[2] = 1; result[1] = 1; break;
			case '8': result[0] = 1; break;
			case '9': result[3] = 1; result[0] = 1; break;
			case 'A': result[0] = 1; break;
			case 'B': result[3] = 1; result[0] = 1; break;
			case 'C': result[2] = 1; result[0] = 1; break;
			case 'D': result[3] = 1; result[2] = 1; result[0] = 1; break;
			case 'E': result[2] = 1; result[1] = 1; result[0] = 1;break;
			case 'F': result[3] = 1; result[2] = 1; result[1] = 1; result[0] = 1;break;
		}
		return result;
	}
	static void binToPrint(String option) {
		switch (option) {
		case "000": {
			if (flag) {
				System.out.print(0);
			}
			break;
		}
		case "001": System.out.print(1); flag = true; break;
		case "010": System.out.print(2); flag = true; break;
		case "011": System.out.print(3); flag = true; break;
		case "100": System.out.print(4); flag = true; break;
		case "101": System.out.print(5); flag = true; break;
		case "110": System.out.print(6); flag = true; break;
		case "111": System.out.print(7); flag = true; break;
		}
	}
}

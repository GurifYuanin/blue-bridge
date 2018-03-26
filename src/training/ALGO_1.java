package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ALGO_1 {
	static int[] list;
	static int length, count;
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		length = Integer.parseInt(buf.readLine());
		list = new int[length];
		String[] tmp = buf.readLine().split(" ");
		for (int i = 0; i < length; i++) {
			list[i] = Integer.parseInt(tmp[i]);
		}

		count = Integer.parseInt(buf.readLine());
		for (int i = 0; i < count; i++) {
			tmp = buf.readLine().split(" ");
			int start = Integer.parseInt(tmp[0]);
			int end = Integer.parseInt(tmp[1]);
			int rank = Integer.parseInt(tmp[2]);
			int[] tmpList = Arrays.copyOfRange(list, start - 1, end);
			Arrays.sort(tmpList);
			System.out.println(tmpList[tmpList.length - rank]);
		}
 		buf.close();
	}
	

}

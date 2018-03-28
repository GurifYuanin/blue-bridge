package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_79 {
	 public static void main(String[] args) throws IOException {
		 BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		 int length = Integer.parseInt(buf.readLine());
		 String[] arr = buf.readLine().split(" ");
		 int count = 0;
		 String output = "";
		 for (int i = 0; i < length; i++) {
			 if (Integer.parseInt(arr[i]) != 0) {
				 output += arr[i] + " ";
				 count++;
			 }
		 }
		 System.out.println(count);
		 System.out.println(output.trim());
		 buf.close();
	 }
}

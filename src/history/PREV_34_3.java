package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_34_3 {
	 public static void main(String[] args) throws IOException {
		 BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		 String[] arr = buf.readLine().split(" ");
		 long row = Integer.parseInt(arr[0]);
		 long col = Integer.parseInt(arr[1]);
		 buf.close();
		 
		 System.out.println((int)Math.sqrt(row) * (int)Math.sqrt(col));
	 }

}

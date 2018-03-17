package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_2 {
	static int layer, row, col;
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		layer = Integer.parseInt(buf.readLine());
		buf.close();
		
		int switch1 = 0, switch2 = 0, index = 0;
		char[] meun = {'$', '.'};
		row = col = 4 * layer + 5;
		String[] list = new String[row / 2];
		for (int i = 0; i < row / 2; i++) {
			list[i] = "";
		}
		
		printTail(layer, true);
		for (int i = 2; i < row / 2; i++) {
			String tmp ="";
			for (int j = 0; j < 4 * (layer  - 1) + 1 - 2 * (i - 2); j++) {
				tmp += meun[switch1];
			}
			switch2 = 0;
			for (int j = 2; j < i; j++) {
				list[index] += meun[switch2];
				switch2 = 1 - switch2;
			}
			list[index] += meun[switch1];
			list[index] += meun[switch1];
			list[index] += meun[switch1];
			list[index] += meun[1 - switch1];
			if (!tmp.equals("")) {
				list[index] += tmp;
				list[index] += meun[1 - switch1];
			} 
			list[index] += meun[switch1];
			list[index] += meun[switch1];
			list[index] += meun[switch1];
			switch2 = 1 - switch2;
			for (int j = 2; j < i; j++) {
				list[index] += meun[switch2];
				switch2 = 1 - switch2;
			}
			list[index] += "\n";
			System.out.print(list[index++]);
			switch1 = 1 - switch1;
		}
		switch2 = 1 - switch2;
		for (int i = 0; i < (col - 5) / 2; i++) {
			System.out.print(meun[switch2]);
			switch2 = 1 - switch2;
		}
		System.out.print("$$$$$");
		switch2 = 1 - switch2;
		for (int i = 0; i < (col - 5) / 2; i++) {
			System.out.print(meun[switch2]);
			switch2 = 1 - switch2;
		}
		System.out.println();
		for (int i = row / 2 - 1; i >= 0; i--) {
			System.out.print(list[i]);
		}
		printTail(layer, false);
	}
	static void printTail(int layer, boolean isHead) {
		if (isHead) {
			firstLine(layer);
			secondLine(layer);
		} else {
			secondLine(layer);
			firstLine(layer);
		}	
	}
	static void firstLine(int layer)  {
		// 第一行
		System.out.print("..");
		for (int i = 4 * layer + 1; i > 0; i--) {
			System.out.print("$");
		}
		System.out.println("..");
	}
	static void secondLine(int layer) {
		// 第二行
		System.out.print("..$");
		for (int i = 4 * layer - 1; i > 0; i--) {
			System.out.print(".");
		}
		System.out.println("$..");
	}
}

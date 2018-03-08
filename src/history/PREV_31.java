package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_31 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine());
		Child[] children = new Child[number];
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		for (int i = 0; i < number; i++) {
			children[i] = new Child(Integer.parseInt(arr[i]));
		}
		
		int valve, allAngry = 0;
		Child temp = new Child(0);
		for (int i = 0; i < number; i++) {
			valve = number - i - 1;
			for (int j = 0; j < valve; j++) {
					if (children[j].height > children[j + 1].height) {
						temp = children[j];
						children[j] = children[j + 1];
						children[j + 1] = temp;
						children[j].update();
						children[j + 1].update();
					}
				}
			allAngry += children[valve].angry;
			}
		System.out.print(allAngry);
		}
	}

class Child {
	int angry = 0;
	int time = 0;
	int height;
	Child(int height) {
		this.height = height;
	}
	void update () {
		time++;
		angry += time;
	}
}

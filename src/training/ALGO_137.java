package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALGO_137 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		Person[] people = new Person[3];
		for (int i = 0; i < 3; i++) {
			String[] arr = buf.readLine().split(" ");
			people[i] = new Person(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
		}
		buf.close();
		
		int max = 0, index = 0, tmp, max2 = 0;
		for (int i = 0; i < 3; i++) {
			tmp = people[i].position + people[i].move;
			if (max < tmp && isInside(people, tmp)) {
				max = tmp;
			}
			if (max2 < tmp) {
				max2 = tmp;
				index = i;
			}
		}
		tmp = max;
		max = 0;
		for (int i = 0; i < 3; i++) {
			tmp += people[i].thr;
			if (i != index && max < people[i].move) {
				max = people[i].move;
			}
		}
		tmp += max;
		System.out.println(tmp);
	}
	static boolean isInside(Person[] p, int position) {
		if (
				position >= p[0].position - p[0].move - 1 &&
				position <= p[0].position + p[0].move + 1&&
				position >= p[1].position - p[1].move - 1&&
				position <= p[1].position + p[1].move + 1&&
				position >= p[2].position - p[2].move - 1&&
				position <= p[2].position + p[2].move + 1
				) {
			return true;
		} else {
			return false;
		}
	}
}
class Person{
	int position, move, thr;
	Person(int p, int m, int t){
		this.position = p;
		this.move = m;
		this.thr = t;
	}
}
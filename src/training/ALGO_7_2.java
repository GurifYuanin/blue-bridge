package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class ALGO_7_2 {
	static int nodeNumber, index = 0;
	static int[] weight;
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		nodeNumber = 2 * Integer.parseInt(buf.readLine()) - 1;
		weight = new int[nodeNumber];
		for (int i = 0; i < nodeNumber; i++) {
			weight[i] = Integer.parseInt(buf.readLine());
		}
		buf.close();
		Node root = createTree();
		int revNumber = dfs(root);
		System.out.print(revNumber);
	}
	static Node createTree() {
		int date = weight[index];
		index++;
		Node root = new Node(date);
		if (date == 0) {
			// 非叶节点
			root.left = createTree();
			root.right = createTree();
		}
		return root;
	}
	static int dfs(Node root) {
		int result = 0;
		if (root.weight != 0) {
			// 如果是叶子节点
			root.revNumber = 0;
			root.list.add(root.weight);
		} else {
			// 如果是非叶节点
			result = dfs(root.left) + dfs(root.right);
			int beforeRev = getRevNumber(root.left.list, root.right.list);
			int afterRev = getRevNumber(root.right.list, root.left.list);
			if (afterRev < beforeRev) {
				// 如果转换后逆序数变少，则进行转换
				Node tmp = root.left;
				root.left = root.right;
				root.right = tmp;
			}
			root.list.addAll(root.left.list);
			root.list.addAll(root.right.list);
			root.revNumber = Math.min(beforeRev, afterRev);
			result += root.revNumber;
		}
		return result;
	}
	static int getRevNumber(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		Iterator<Integer> ite1 = list1.iterator();
		int count = 0, a, b;
		while (ite1.hasNext()) {
			a = ite1.next();
			Iterator<Integer> ite2 = list2.iterator();
			while (ite2.hasNext()) {
				b = ite2.next();
				if (a > b) {
					count++;
				}
			}
		}
		return count;
	}
}
class Node{
	Node left = null, right = null;
	int weight, revNumber;
	LinkedList<Integer> list = new LinkedList<Integer>();
	Node(int weight) {
		this.weight = weight;
	}
}

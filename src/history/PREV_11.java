package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PREV_11 {
	public static void main (String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		int length = arr.length;
		int[] value = new int[length];
		for (int i = 0; i < length; i++) {
			value[i] = Integer.parseInt(arr[i]);
		}
		
		Node root = new Node(value[0]);
		for (int i = 1; i < length; i++) {
			root = createAVL(root, value[i]);
		}
		dfs(root, 0);
	}
	static Node createAVL(Node node, int value) {
		if (node == null) {
			node = new Node(value);
		}
		if (node.value < value) {
			createAVL(node.left, value);
		} else {
			createAVL(node.right, value);
		}
		return node;
	}
	static int dfs(Node node, int x) {
		if (node.right != null) {
			node.y = dfs(node.right, x + 1) + 1;
		}
		if (node.left != null) {
			dfs(node.left, x + 1);
		}
		return node.y;
	}
}
class Node {
	int value, x, y;
	Node left = null, right = null;
	Node(int value) {
		this.value = value;
	}
}

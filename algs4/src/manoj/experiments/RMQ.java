import RMQ;

import java.util.Arrays;

import RMQ.Node;

public class RMQ {
	class Node {
		int data;
		Node left;
		Node right;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

	private Node constructTree(int begin, int end, int[] arr) {
		if (begin == end) {
			Node base = new Node();
			base.setData(arr[begin]);
			base.setLeft(null);
			base.setRight(null);
			// System.out.println(begin);
			return base;
		} else {
			Node n = new Node();
			n.setLeft(constructTree(begin, (int) Math.floor((begin + end) / 2),
					arr));
			n.setRight(constructTree((int) Math.floor(((begin + end) / 2) + 1),
					end, arr));
			n.setData(Math.max(n.getLeft().getData(), n.getRight().getData()));
			return n;
		}

	}

	private void initialize(int node, int b, int e, int M[], int A[]) {
		try {
			if (b == e) {
				M[node] = b;
			} else {
				initialize(2 * node + 1, b, (b + e) / 2, M, A);
				initialize(2 * node + 2, ((b + e) / 2) + 1, e, M, A);
				if (A[M[2 * node + 1]] >= A[M[2 * node + 2]])
					M[node] = M[2 * node + 1];
				else
					M[node] = M[2 * node + 2];
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			Arrays.toString(M);
		}

	}

	public void printTree(Node n) {
		if (n.getLeft() != null)
			printTree(n.getLeft());
		if (n.getRight() != null)
			printTree(n.getRight());
		System.out.print(" " + n.getData() + " ");
	}

	public static void main(String args[]) {
		RMQ rmqTest = new RMQ();
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Node segTree = rmqTest.constructTree(0, arr.length - 1, arr);
		System.out.println(segTree.getData());
		System.out.println(segTree.getLeft().getData());
		System.out.println(segTree.getRight().getData());
		rmqTest.printTree(segTree);

	}
}

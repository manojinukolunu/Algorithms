package manoj.experiments;

public class Tree {
	public class Node {
		int data;
		Node left;
		Node right;

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return this.right;
		}

		public Node getLeft() {
			return this.left;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node() {
			this.left = null;
			this.right = null;
			this.data = 0;
		}

	}

	public Tree() {

	}

	private Node root;

	public void setRoot(Node root) {
		this.root = root;
	}

}

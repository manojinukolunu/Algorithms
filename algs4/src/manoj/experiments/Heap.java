package manoj.experiments;

public class Heap {
	public int parent(int i) {
		return i / 2;
	}

	public int leftChild(int i) {
		return 2 * i + 1;
	}

	public int rightChild(int i) {
		return 2 * i + 2;
	}

	public int[] maxHeapify(int[] A, int i) {
		return null;
	}

	public int[] buildMaxHeadp(int[] A) {
		int size = A.length;
		for (int i = size / 2; i >= 0; i--) {
			A = maxHeapify(A, i);
		}
		return A;
	}
}

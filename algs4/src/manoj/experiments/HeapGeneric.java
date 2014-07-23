package manoj.experiments;

public class HeapGeneric {
	public int parent(int i) {
		return (i / 2);
	}

	public int leftChild(int i) {
		return 2 * i + 1;
	}

	public int rightChild(int i) {
		return 2 * i + 2;
	}

	public int[] maxHeapify(int[] array, int i) {
		int l = leftChild(i);
		int r = rightChild(i);
		int largest;
		if (l <= array.length && array[l] > array[i])
			largest = l;
		else
			largest = i;
		if (r <= array.length && array[r] > array[largest])
			largest = r;
		if (largest != i) {
			swap(array[i], array[largest]);
			maxHeapify(array, largest);

		}

		return null;
	}

	private void swap(int object, int object2) {
		// TODO Auto-generated method stub

	}

	public int[] heapSort(int[] unorderedArray) {
		int[] maxHeap = buildMaxHeap(unorderedArray);
		for (int i = maxHeap.length; i >= 2; i--) {
			swap(maxHeap[1], maxHeap[i]);
			// maxHeap.length = maxHeap.length - 1; decrement the size of the
			// heap
			maxHeapify(maxHeap, 1);
		}
		return maxHeap;
	}

	public int[] buildMaxHeap(int[] array) {
		int size = array.length;
		for (int i = size / 2; i >= 0; i--) {
			array = maxHeapify(array, i);
		}
		return array;
	}
}

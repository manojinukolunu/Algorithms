package manoj.experiments;

public class SegTree {

	private int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	private int constructSegTreeUntil(int arr[], int ss, int se, int st[],
			int si) {
		// If there is one element in array, store it in current node of
		// segment tree and return
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}

		// If there are more than one elements, then recur for left and
		// right subtrees and store the sum of values in this node
		int mid = getMid(ss, se);
		st[si] = constructSegTreeUntil(arr, ss, mid, st, si * 2 + 1)
				+ constructSegTreeUntil(arr, mid + 1, se, st, si * 2 + 2);
		return st[si];
	}

	private int[] constructSegmentTree(int[] input) {
		int x = (int) (Math.ceil(Math.log(input.length)));
		int max_size = 2 * (int) (Math.pow(2, x) - 1);
		int[] segTree = new int[max_size];
		constructSegTreeUntil(input, 0, input.length - 1, segTree, 0);
		return segTree;
	}

	public static void main(String args[]) {
		int[] arr = {-1, 2, 4, 5, -8, 123};
		SegTree seg = new SegTree();
		int[] segtree = seg.constructSegmentTree(arr);
	}
}

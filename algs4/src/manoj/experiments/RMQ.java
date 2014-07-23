package manoj.experiments;

import java.util.Arrays;

public class RMQ {
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
	public static void main(String args[]) {
		RMQ rmqTest = new RMQ();
		int arr[] = {0, 1, 2, 3};
		int segTree[] = new int[(int) (2 * Math.pow(2, Math.log(arr.length)
				/ Math.log(2)) - 1)];
		rmqTest.initialize(0, 0, arr.length - 1, segTree, arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(segTree));
	}
}

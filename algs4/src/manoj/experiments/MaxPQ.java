package manoj.experiments;

import java.util.Iterator;
import java.util.concurrent.Exchanger;

public class MaxPQ<Key> implements Iterable<Key> {

	/*
	 * Event Driven Simulation customers in a line , colliding particles
	 * Numerical computation reducing roundoff error Data compression Huffman
	 * codes Graph Searching Dijkstra's algorithm,Prim's algorithm Number Theory
	 * sum of powers Artificial Intelligence A * search Statistics maintain
	 * largest M values in a sequence Operating Systems load balancing,
	 * interrupt handling Discrete Optimization bin packing , scheduling Spam
	 * Filtering bayesian spam filter
	 */

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k ){
		while(2*k < = N){
			int j = 2*k;
			if ( j < N && less(j,j+1)) j++;
			if ( !less(k,j)) break;
			exch(k,j);
			k  = j;
		}
	}
	public MaxPQ() {

	}

	public MaxPQ(Key[] a) {

	}

	public void insert(Key v) {

	}

	public Key delMax() {
		return null;
	}

	public boolean isEmpty() {
		return false;
	}

	public Key max() {
		return null;
	}

	public int size() {
		return -1;
	}

	@Override
	public Iterator<Key> iterator() {
		return null;
	}

}

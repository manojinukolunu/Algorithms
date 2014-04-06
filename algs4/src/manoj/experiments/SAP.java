package manoj.experiments;

import java.io.File;
import java.util.Arrays;

import manoj.algs4.BreadthFirstDirectedPaths;
import manoj.algs4.Digraph;
import manoj.stdlib.In;

public class SAP {

	private Digraph G;

	// constructor takes a digraph (not necessarily a DAG)
	public SAP(Digraph G) {
		this.G = G;
	}

	// length of shortest ancestral path between v and w ; -1 if no such path
	public int length(int v, int w) {
		BreadthFirstDirectedPaths bfds = new BreadthFirstDirectedPaths(G, v);
		BreadthFirstDirectedPaths _bfds = new BreadthFirstDirectedPaths(G, w);
		System.out.println(Arrays.toString(bfds.getDistance()));
		System.out.println(Arrays.toString(_bfds.getDistance()));
		return -1;
	}

	// a common ancestor of v and w than participates in the shortest ancestral
	// path ; -1 if no such path
	public int ancestor(int v, int w) {
		return -1;
	}

	// length of shortest ancestral path between any vertex in v and any vertex
	// in w ; -1 if no such path
	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		return -1;

	}

	// a common ancestor that participates in shortest ancestral path ; -1 if no
	// such path
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		return -1;
	}

	public static void main(String[] args) {
		In in = new In(new File("C:/digraph1.txt"));
		// System.out.println(in.readInt());
		Digraph G = new Digraph(in);
		SAP sap = new SAP(G);

		sap.length(3, 11);
	}

}

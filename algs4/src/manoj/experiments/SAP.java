package manoj.experiments;

import java.io.File;
import java.util.Arrays;

import manoj.algs4.BreadthFirstDirectedPaths;
import manoj.algs4.Digraph;
import manoj.stdlib.In;
import manoj.stdlib.StdIn;
import manoj.stdlib.StdOut;

public class SAP {

	private Digraph G;

	// constructor takes a digraph (not necessarily a DAG)
	public SAP(Digraph G) {
		this.G = G;
	}

	// length of shortest ancestral path between v and w ; -1 if no such path
	public int length(int v, int w) {
		BreadthFirstDirectedPaths bfsv = new BreadthFirstDirectedPaths(G, v);
		BreadthFirstDirectedPaths bfsw = new BreadthFirstDirectedPaths(G, w);
		
		System.out.println(Arrays.toString(bfsv.getReachableVerticesfromSourceVertex(v)));
		
		System.out.println(Arrays.toString(bfsw.getReachableVerticesfromSourceVertex(w)));
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
		Digraph G = new Digraph(in);
		SAP sap = new SAP(G);
		sap.length(3, 11);
	}
}

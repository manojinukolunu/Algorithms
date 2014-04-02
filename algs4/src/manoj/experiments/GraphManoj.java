package manoj.experiments;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import manoj.experiments.algorithms.base.Bag;
import manoj.experiments.algorithms.base.DepthFirstSearch;
import manoj.experiments.algorithms.base.Graph;
import manoj.experiments.algorithms.base.Queue;

public class GraphManoj {
	private int numVertices;
	private int numEdges;
	private Bag<Integer>[] adjList;

	private boolean[] marked; // marked[v] = has vertex v been marked?
	private static int[] id; // id[v] = id of connected component containing v
	private int[] size; // size[id] = number of vertices in given component
	private int count; // number of connected components

	private static final int INFINITY = Integer.MAX_VALUE;
	// private boolean[] marked; // marked[v] = is there an s-v path
	private int[] edgeTo; // edgeTo[v] = previous edge on shortest s-v path
	private int[] distTo; // distTo[v] = number of edges shortest s-v path

	private static HashMap<String, Integer> alphabet = new HashMap();

	private void dfs(GraphManoj G, int v) {
		marked[v] = true;
		id[v] = count;
		size[count]++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public void CC(GraphManoj G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	/**
	 * Initialize the adjList for this graph with number of vertices
	 */
	public GraphManoj() {
		adjList = new Bag[numVertices];
		for (int i = 0; i < numVertices; i++) {
			adjList[i] = new Bag<Integer>();
		}
	}

	public int V() {
		return numVertices;
	}

	/**
	 * Returns the number of edges in the graph.
	 * 
	 * @return the number of edges in the graph
	 */
	public int E() {
		return numEdges;
	}

	/**
	 * Get the Graph as an adjacency List
	 * 
	 * @return
	 */
	public Bag<Integer>[] getAdjList() {
		return adjList;
	}

	public Iterable<Integer> adj(int v) {
		if (v < 0 || v >= numVertices)
			throw new IndexOutOfBoundsException();
		return adjList[v];
	}

	/**
	 * Read from file an adjlist and construct a graph out of it
	 * 
	 * @throws Exception
	 * 
	 */
	public GraphManoj(File file) throws Exception {
		if (file == null) {
			throw new Exception("Invalid File");
		}
		Scanner scan = new Scanner(file);
		numVertices = 10;
		numEdges = 11;
		adjList = new Bag[numVertices];
		for (int i = 0; i < numVertices; i++) {
			adjList[i] = new Bag<Integer>();
		}
		int i = 0;
		while (scan.hasNextLine()) {
			String vertexPreprocess = scan.nextLine();
			Bag<Integer> b = new Bag<Integer>();
			String arr[] = vertexPreprocess.split(":")[1].split(" ");
			for (int j = arr.length; j > 0; j--) {
				b.add((int) arr[j - 1].getBytes()[0] - 65);
			}
			adjList[i++] = b;
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		// s.append(numVertices + " vertices, " + numEdges + " edges " +
		// NEWLINE);
		for (int v = 0; v < numVertices; v++) {
			s.append(Character.toString((char) (v + 65)) + ": ");
			for (int w : adjList[v]) {
				s.append(Character.toString((char) (w + 64)) + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	private void bfs(GraphManoj G, int s) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		Queue<Integer> q = new Queue<Integer>();
		for (int v = 0; v < G.V(); v++)
			distTo[v] = INFINITY;
		distTo[s] = 0;
		marked[s] = true;
		q.enqueue(s);

		while (!q.isEmpty()) {
			int v = q.dequeue();
			System.out.print((char) (v + 65) + " ");
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		GraphManoj g = new GraphManoj(new File("C:/Users/Manoj/workspace/Algorithms/src/manoj/experiments/algorithms/base/connectivity.txt"));
		System.out.println(g.toString());
//		 DepthFirstSearch dfs = new DepthFirstSearch(g, 0);
//		g.bfs(g, 0);
		 g.CC(g);
		 System.out.println(Arrays.toString(id));

	}
}

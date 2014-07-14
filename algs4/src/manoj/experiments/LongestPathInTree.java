package manoj.experiments;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LongestPathInTree {
	private ArrayList<Edge> edges;

	class Edge {
		private int beginVertex;

		public int getBeginVertex() {
			return beginVertex;
		}

		public void setBeginVertex(int beginVertex) {
			this.beginVertex = beginVertex;
		}

		public int getEndVertex() {
			return endVertex;
		}

		public void setEndVertex(int endVertex) {
			this.endVertex = endVertex;
		}

		private int endVertex;
	}

	public void addEdge(Edge e) {
		this.edges.add(e);
	}

	public LongestPathInTree() {
		edges = new ArrayList<Edge>();
	}

	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		LongestPathInTree t = new LongestPathInTree();
		int numNodes = Integer.parseInt(reader.readLine());
		while (numNodes-- > 0) {
			String[] edge = reader.readLine().split(" ");
			Edge e = t.new Edge();
			e.setBeginVertex(Integer.parseInt(edge[0]));
			e.setEndVertex(Integer.parseInt(edge[1]));
			t.addEdge(e);
		}
	}
}

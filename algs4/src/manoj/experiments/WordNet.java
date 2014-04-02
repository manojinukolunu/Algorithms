package manoj.experiments;

import java.io.File;
import java.util.HashSet;

import manoj.algs4.Digraph;
import manoj.algs4.Topological;
import manoj.stdlib.In;

public class WordNet {

	private String[] synset;

	private HashSet<String> nouns; // HashSet for fastest lookup its O(1)

	public WordNet(String synsets, String hypernyms) {
		nouns = new HashSet<String>();
		// Pattern pattern = Pattern.compile("\n");
		// pattern.split(hypernyms,0);
		synset = synsets.split("\n");
		for (int i = 0; i < synset.length; i++) {
			nouns.add(synset[i].split(",")[1]);
		}

		String[] hypernym = hypernyms.split("\n");
		Digraph digraph = new Digraph(hypernym.length);
		System.out.println("Building Digraph with " + hypernym.length + " Vertices");
		Long start = System.currentTimeMillis();
		for (int i = 0; i < hypernym.length; i++) {
			String[] line = hypernym[i].split(",");
			for (int j = 0; j < line.length - 1; j++) {
				digraph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[j + 1]));
			}
		}

		Long end = System.currentTimeMillis();
		System.out.println("Building Digraph Completed " + (end - start));
		Topological t = new Topological(digraph);
		if (!t.hasOrder())
			throw new IllegalArgumentException();
	}

	public Iterable<String> nouns() {
		return nouns;
	}

	public boolean isNoun(String word) {
		if (nouns.contains(word))
			return true;
		else
			return false;
	}

	public int distance(String nounA, String nounB) {
		if (!(nouns.contains(nounA) && nouns.contains(nounB)))
			throw new IllegalArgumentException();
		return -1;
	}

	public String sap(String nounA, String nounB) {
		if (!(nouns.contains(nounA) && nouns.contains(nounB)))
			throw new IllegalArgumentException();
		return null;
	}

	public static void main(String[] args) {

		String synsetFileName = "C:/Users/Manoj/Projects/Algorithms/synsets.txt";
		String hypernymFileName = "C:/Users/Manoj/Projects/Algorithms/hypernyms.txt";

		In in = new In(new File(synsetFileName));
		String synset = in.readAll();
		in = new In(new File(hypernymFileName));
		String hypernym = in.readAll();

		WordNet wordNet = new WordNet(synset, hypernym);

	}
}

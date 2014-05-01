package manoj.experiments;

import java.util.LinkedList;

import manoj.stdlib.BinaryStdIn;

public class MoveToFront {

	public static LinkedList<Integer> radix = new LinkedList<Integer>();

	// apply move to front encoding, reading from standard input and writing to
	// standard output
	public static void encode() {
		for (int i = 0; i < 256; i++) {
			radix.add(i);
		}
		
		while (true) {
			int ch = BinaryStdIn.readChar();
			if (radix.contains(ch)) {
				
			}
			System.out.println(ch);
		}

	}

	// apply move to front decoding , reading from standard input and writing to
	// standard output
	public static void decode() {

	}

	// if args[0] is '-' apply move to front encoding
	// if args[0] is '+' apply move to front decoding

	public static void main(String args[]) {
		if (args.length <= 0) {
			throw new IllegalArgumentException();
		}

		if (args[0].equals("-")) {
			MoveToFront move = new MoveToFront();
			move.encode();
		}
		if (args[0].equals("+")) {
			MoveToFront move = new MoveToFront();
			move.decode();
		}
	}
}

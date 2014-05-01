package manoj.experiments;

public class CircularSuffixArray {

	private String originalString;

	public CircularSuffixArray(String s) {
		this.originalString = s;
	}

	public int length() {
		return originalString.length();
	}

	public int index(int i) {
		return -1;
	}

}

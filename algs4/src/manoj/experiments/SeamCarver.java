package manoj.experiments;

import manoj.stdlib.Picture;

public class SeamCarver {
	public SeamCarver(Picture picture) {

	}
	
	// Current Picture
	public Picture picture() {
		return null;
	}

	//width of current picture
	public int width() {
		return -1;
	}
	
	//height of current picture
	public int height() {
		return -1;
	}
	
	//energy of pixel at coulmn x and row y in current picture
	public double energy(int x, int y) {
		return -1;
	}
	
	
	//sequence of indices for horizontal seam in current picture
	public int[] findHorizontalSeam() {
		return null;
	}
	
	// sequence of indices for vertical seam in current picture
	public int[] findVerticalSeam() {
		return null;
	}
	
	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] a) {

	}
	
	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] a) {

	}

}

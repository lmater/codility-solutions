package org.lmater;

import java.util.Arrays;

public class NumberOfDiscIntersections {

	public int solution(int[] A) {
		if (A.length <= 1)
			return 0;

		int unorderedPairs = 0;
		int exceeds = 10_000_000;
		int openedDisks = 0;

		Disc[] disks = new Disc[A.length];
		long[] indexOfCloses = new long[A.length];
		for (int i = 0; i < A.length; i++) {
			disks[i] = new Disc(((long) i - (long) A[i]), ((long) i + (long) A[i]));
			indexOfCloses[i] = i + (long) A[i];
		}

		Arrays.sort(disks);
		Arrays.sort(indexOfCloses);

		for (int i = 0, j = 0; i < A.length;) {
			if (j < A.length && disks[i].openAfterClose(indexOfCloses[j])) {
				openedDisks--;
				j++;
			} else {
				unorderedPairs += openedDisks;
				openedDisks++;
				i++;
			}
			if (unorderedPairs > exceeds)
				return -1;
		}

		return unorderedPairs;
	}

	class Disc implements Comparable<Disc> {
		Long right;
		Long left;

		public Disc(Long left, Long right) {
			this.right = right;
			this.left = left;
		}

		public Long getRight() {
			return right;
		}

		public Long getLeft() {
			return left;
		}

		@Override
		public String toString() {
			return getLeft() + "," + getRight();
		}

		@Override
		public int compareTo(Disc o) {
			if (this.getLeft() < o.getLeft())
				return -1;
			else if (this.getLeft() > o.getLeft())
				return 1;
			return 0;
		}

		public boolean openAfterClose(long right) {
			return (this.getLeft() > right);
		}
	}
}

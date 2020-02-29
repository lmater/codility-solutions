package org.lmater;

import java.util.Arrays;

public class NumberOfDiscIntersections {

	public int solution(int[] A) {
		if (A.length <= 1)
			return 0;

		int unorderedPairs = 0;
		int exceeds = 10_000_000;

		Disc[] list = new Disc[A.length];
		for (int i = 0; i < A.length; i++) {
			list[i] = new Disc(((long) i - (long) A[i]), ((long) i + (long) A[i]));
		}
		Arrays.sort(list);

		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (list[i].intersect(list[j])) {
					unorderedPairs++;
				} else
					break;
				if (unorderedPairs > exceeds)
					return -1;
			}
		}

		return unorderedPairs;
	}

	class Disc implements Comparable<Disc> {
		private final Long right;
		private final Long left;

		public Disc(Long left, Long right) {
			this.right = right;
			this.left = left;
		}

		private Long getRight() {
			return right;
		}

		private Long getLeft() {
			return left;
		}

		@Override
		public String toString() {
			return getLeft() + "," + getRight();
		}

		@Override
		public int compareTo(Disc o) {
			return (int) (o.getRight() - this.getRight());
		}

		public boolean intersect(Disc o) {
			return (o.getRight() >= this.getLeft());
		}
	}
}

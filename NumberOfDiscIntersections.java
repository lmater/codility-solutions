package org.lmater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfDiscIntersections {

	public int solution(int[] A) {
		if (A.length <= 1)
			return 0;

		int unorderedPairs = 0;
		int exceeds = 10_000_000;
		int count = 0;

		Disc[] list = new Disc[A.length];
		List<Long> left = new ArrayList<Long>();
		int p = 0;
		for (int i = 0; i < A.length; i++) {
			list[i] = new Disc(((long) i - (long) A[i]), ((long) i + (long) A[i]));
			if (i >= A[i]) {
				left.add((long) i - (long) A[i]);
				p++;
			}
		}

		Arrays.sort(list);
		Collections.sort(left, (o1, o2) -> {
			return (int) (o2 - o1);
		});

		for (int i = 0, k = 0; i < list.length; i++) {
			Long r = list[i].getRight();
			while (k < p && r < left.get(k)) {
				count--;
				k++;
			}

			unorderedPairs += count;
			count++;

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
			return (int) (o.getRight() - this.getRight());
		}
	}
}

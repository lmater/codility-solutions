package org.lmater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfDiscIntersections {

	public int solution(int[] A) {

		if (A.length <= 1)
			return 0;

		int unorderedPairs = 0;
		int exceeds = 10_000_000;
		int count = 0;

		List<Disc> list = new ArrayList<Disc>();
		List<Long> left = new ArrayList<Long>();
		for (int i = 0; i < A.length; i++) {
			list.add(new Disc(Long.valueOf(i) - Long.valueOf(A[i]), Long.valueOf(i) + Long.valueOf(A[i])));
			if (i >= A[i]) {
				left.add(Long.valueOf(i) - Long.valueOf(A[i]));
			}
		}

		Collections.sort(list);
		Collections.sort(left, (o1, o2) -> {
			return (int) (o2 - o1);
		});

		for (int i = 0; i < list.size(); i++) {
			Long r = list.get(i).getRight();
			while (!left.isEmpty() && r < left.get(0)) {
				count--;
				left.remove(0);
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
			return getLeft() + " " + getRight();
		}

		@Override
		public int compareTo(Disc o) {
			return (int) (o.getRight() - this.getRight());
		}
	}
}

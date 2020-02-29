package org.lmater;

import java.util.Arrays;

public class NumberOfDiscIntersections {

	public int solution(int[] A) {
		if (A.length <= 1)
			return 0;

		int unorderedPairs = 0;
		int exceeds = 10_000_000;

		long[][] list = new long[A.length][2];
		for (int i = 0; i < A.length; i++) {
			list[i][0] = i - (long) A[i];
			list[i][1] = i + (long) A[i];
		}
		Arrays.sort(list, (l1, l2) -> {
			if (l1[1] > l2[1])
				return -1;
			return 1;
		});

		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (list[i][0] <= list[j][1]) {
					unorderedPairs++;
					if (unorderedPairs > exceeds)
						return -1;
				} else
					break;
			}
		}

		return unorderedPairs;
	}
}

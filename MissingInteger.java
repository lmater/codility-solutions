package org.lmater;

import java.util.Arrays;

public class MissingInteger {
	public int solution(int[] A) {
		Arrays.sort(A);
		int smallestPositive = 1;
		for (int i = 0; i < (A.length); i++) {
			if (A[i] >= 1) {
				if (A[i] == smallestPositive) {
					smallestPositive++;
				} else if (A[i] == (smallestPositive - 1)) {
					continue;
				} else {
					return smallestPositive;
				}
			}
		}
		return smallestPositive;
	}
}

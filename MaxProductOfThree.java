package org.lmater;

import java.util.Arrays;

public class MaxProductOfThree {

	public int solution(int[] A) {

		Arrays.sort(A);
		int n = A.length;

		if (A[n - 1] <= 0 || (A[n - 2] * A[n - 3]) > (A[0] * A[1])) {
			return A[n - 1] * A[n - 2] * A[n - 3];
		} else {
			return A[n - 1] * A[0] * A[1];
		}
	}

}

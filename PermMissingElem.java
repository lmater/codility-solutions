package org.lmater;

import java.util.Arrays;

public class PermMissingElem {
	public static int solution(int[] A) {
		Arrays.sort(A);
		for (int i = 1; i < (A.length + 1); i++) {
			if (i != A[i-1])
				return i;
		}
		return A.length + 1;
	}
}

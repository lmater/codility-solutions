package org.lmater;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

	public int solution(int[] A) {
		int result = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (!set.contains(A[i])) {
				set.add(A[i]);
				result++;
			}
		}
		return result;
	}
}

package org.lmater;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
	public int solution(int X, int[] A) {
		Set<Integer> leafsSet = new HashSet<Integer>();
		int earliestTime = -1;
		for (int i = 0; i < A.length; i++) {
			if (!leafsSet.contains(A[i])) {
				leafsSet.add(A[i]);
			}
			if (leafsSet.size() >= X) {
				earliestTime = i;
				break;
			}
		}
		return earliestTime;
	}
}

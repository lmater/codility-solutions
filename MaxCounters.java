package org.lmater;

import java.util.Arrays;

public class MaxCounters {
	public int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		int nextMax = 0;
		int maxToadd = 0;
		for (int i = 0; i < A.length; i++) {
			int value = A[i];
			if (value == (N + 1)) {
				maxToadd += nextMax;
				nextMax = 0;
				// counters = new int[N];
			} else if ((counters[value - 1] += 1) <= nextMax) {
				counters[value - 1] = nextMax;
			} else if (counters[value - 1] > nextMax) {
				nextMax += 1;
			}
		}
		Arrays.sort(counters);
		for (int i = 0; i < counters.length; i++) {
			counters[i] += maxToadd;
		}
		return counters;
	}
}

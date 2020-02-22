package org.lmater;

public class MaxCounters {
	public int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		int nextMax = 0;
		int maxToadd = 0;
		for (int i = 0; i < A.length; i++) {
			int counterIndex = A[i];
			if (counterIndex == (N + 1)) {
				maxToadd = nextMax;
			} else if (counters[counterIndex - 1] < maxToadd) {
				counters[counterIndex - 1] = maxToadd + 1;
				nextMax += (counters[counterIndex - 1] > nextMax) ? 1 : 0;
			} else if (counters[counterIndex - 1] >= maxToadd) {
				counters[counterIndex - 1] += 1;
				nextMax += (counters[counterIndex - 1] > nextMax) ? 1 : 0;
			}
		}
		for (int i = 0; i < counters.length; i++) {
			if (counters[i] < maxToadd)
				counters[i] = maxToadd;
		}
		return counters;
	}
}

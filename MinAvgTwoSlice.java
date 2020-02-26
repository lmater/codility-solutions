package org.lmater;

public class MinAvgTwoSlice {

	public int solution(int[] A) {
		
		int index = 0, prefix = 0;
		double minAv = (double) (A[0] + A[1]) / 2;
		
		for (int i = 0; i < A.length - 1; i++) {
			minAv = Math.min(minAv, (double) (prefix + A[i] + A[i + 1]) / (i - index + 2));
			if (((double) (A[i] + A[i + 1]) / 2) < minAv) {
				index = i;
				prefix = A[index];
				minAv = (double) (A[index] + A[index + 1]) / 2;
				continue;
			}
			if (i < A.length - 2) {
				minAv = Math.min(minAv, (double) (prefix + A[i] + A[i + 1] + A[i + 2]) / (i - index + 3));
				if (((double) (A[i] + A[i + 1] + A[i + 2]) / 3) < minAv) {
					index = i;
					prefix = A[i];
					minAv = ((double) (A[index] + A[index + 1] + A[index + 2]) / 3);
					continue;
				}
			}
			prefix += A[i];
		}
		return index;
	}
}

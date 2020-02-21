package org.lmater;

public class TapeEquilibrium {
	public int solution(int[] A) {
		int rightSum = 0;
		for (int i = 1; i < A.length; i++) {
			rightSum += A[i];
		}
		int minDiff = (rightSum -= A[0]);
		for (int i = 1; i < (A.length - 1); i++) {
			if (Math.abs(minDiff) > Math.abs(rightSum -= 2 * A[i]))
				minDiff = rightSum;
		}
		return Math.abs(minDiff);
	}
}

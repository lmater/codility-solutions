package org.lmater;

public class CyclicRotation {

	public static int[] solution(int[] A, int K) {
		if (A == null)
			return null;
		int n = A.length;
		int[] Result = new int[n];
		for (int i = 0; i < n; i++) {
			Result[(i + K) % n] = A[i];
		}
		return Result;
	}
}

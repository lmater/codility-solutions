package org.lmater;

public class PassingCars {
	public int solution(int[] A) {

		int passingCars = 0, threshold = 1_000_000_001, prod = 0;

		for (int i = 0; passingCars < threshold && i < A.length; i++) {
			passingCars += (prod * A[i]);
			prod += (A[i] == 0) ? 1 : 0;

		}
		return passingCars > threshold ? -1 : passingCars;
	}
}

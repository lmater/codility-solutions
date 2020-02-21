package org.lmater;

import java.util.Arrays;

public class OddOccurrencesInArray {
	public static int solution(int[] A) {
		Arrays.sort(A);
		int checkValue = A[0];
		int checkCount = 1;
		for (int i = 1; i < A.length; i++) {
			int next = A[i];
			if (next == checkValue)
				checkCount++;
			else if (checkCount % 2 == 0) {
				checkCount = 1;
				checkValue = next;
			} else {
				return checkValue;
			}
		}
		return checkValue;
	}
}

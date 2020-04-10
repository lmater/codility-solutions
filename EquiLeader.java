package org.lmater;

import java.util.HashMap;
import java.util.Map;

public class EquiLeader {
	
	public int solution(int[] A) {

		int n = A.length;
		Map<Integer, Integer> upStock = new HashMap<Integer, Integer>();
		Map<Integer, Integer> downStock = new HashMap<Integer, Integer>();
		int number = 0;
		for (int i = 0; i < A.length; i++) {
			if (downStock.containsKey(A[i])) {
				int count = 1 + downStock.get(A[i]);
				downStock.put(A[i], count);
			} else {
				downStock.put(A[i], 1);
			}
		}
		int index = -1;
		int CountLeader = 0;

		for (int s = 0; s < (A.length - 1); s++) {

			int countUp = 1;
			if (upStock.containsKey(A[s])) {
				countUp = 1+upStock.get(A[s]);
				upStock.put(A[s], countUp);
			} else {
				upStock.put(A[s], 1);
			}

			if (CountLeader < countUp) {
				CountLeader = countUp;
				index = s;
			}

			int countDown = downStock.get(A[s]);
			if (downStock.containsKey(A[s])) {
				downStock.put(A[s], countDown - 1);
				if (CountLeader > ((s + 1) / 2) && downStock.get(A[index]) > ((n - s - 1) / 2)) {
					number++;
				}
			}
		}
		return number;
	}
}

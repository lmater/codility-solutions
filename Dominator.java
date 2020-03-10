package org.lmater;

import java.util.HashMap;
import java.util.Map;

public class Dominator {
	
	public int solution(int[] A) {		
		int n = A.length;
		Map<Integer, Integer> stock = new HashMap<Integer, Integer>();
		int index = -1;
		int CountLeader = 0;

		for (int i = 0; CountLeader <= (n / 2) && i < A.length; i++) {
			int count = 1;
			if (stock.containsKey(A[i])) {
				count += stock.get(A[i]);
				stock.put(A[i], count);
			} else {
				stock.put(A[i], 1);
			}
			if (CountLeader < count) {
				CountLeader = count;
				index = i;
			}
		}
		return (CountLeader > (n / 2)) ? index : -1;
	}
}

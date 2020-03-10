package org.lmater;

import java.util.HashMap;
import java.util.Map;

public class Dominator {
	public int solution(int[] A) {
		int index = -1;
		int n = A.length;
		int CountLeader = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			int count = 1;
			if (map.containsKey(A[i])) {
				count = map.get(A[i]);
				count++;
				map.put(A[i], count);
			} else {
				map.put(A[i], 1);
			}
			if (CountLeader < count) {
				CountLeader = count;
				index = i;
			}
			if (CountLeader > (n / 2))
				break;
//			System.out.println(map);
//			System.out.println(n / 2);
		}
		return (CountLeader > (n / 2)) ? index : -1;
	}
}

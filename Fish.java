package org.lmater;

import java.util.Stack;

public class Fish {
	
	public int solution(int[] A, int[] B) {

		int n = A.length;

		Stack<Integer> upstream = new Stack<Integer>();
		Stack<Integer> downstream = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			if (B[i] == 0) {
				
				while (!downstream.empty()) {
					if (downstream.peek() < A[i])
						downstream.pop();
					else
						break;
				}
				
				if (downstream.empty()) {
					upstream.push(A[i]);
				}
				
			} else {
				downstream.push(A[i]);
			}
		}
		
		return upstream.size() + downstream.size();
	}
}

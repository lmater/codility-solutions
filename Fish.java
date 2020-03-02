package org.lmater;

import java.util.Stack;

public class Fish {

	public int solution(int[] A, int[] B) {

		int n = A.length;
		int upStreamCount = 0;
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
					upStreamCount++;
				}

			} else {
				downstream.push(A[i]);
			}
		}

		return upStreamCount + downstream.size();
	}

}

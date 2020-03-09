package org.lmater;

import java.util.Stack;

public class StoneWall {

	public int solution(int[] H) {

		int minimumBlocks = 1;

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(H[0]);

		for (int i = 1; i < H.length; i++) {
			if (!stack.empty() && H[i] > stack.peek()) {
				minimumBlocks++;
				stack.push(H[i]);
			} else if (!stack.empty() && H[i] < stack.peek()) {
				minimumBlocks++;
				while (!stack.empty() && H[i] < stack.peek())
					stack.pop();
				if (!stack.empty() && H[i] == stack.peek())
					minimumBlocks--;
				else
					stack.push(H[i]);
			}
		}

		return minimumBlocks;
	}
}

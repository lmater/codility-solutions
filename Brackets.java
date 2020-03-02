package org.lmater;

import java.util.Stack;

public class Brackets {

	public int solution(String S) {

		char[] array = S.toCharArray();
		int n = array.length;

		Stack<Character> stack = new Stack<Character>();

		if (n % 2 != 0 || (n > 0 && isOpenedBracket(array[n - 1])))
			return 0;

		for (int i = 0; i < n; i++) {

			int m = stack.size();

			if (m > (n - i + 1))
				return 0;

			if (isOpenedBracket(array[i])) {
				stack.push(array[i]);
			} else {
				if (m == 0)
					return 0;
				else if (isOpenedClosedBracket(stack.peek(), array[i]))
					stack.pop();
				else
					return 0;
			}
		}
		return 1;
	}

	private boolean isOpenedBracket(char left) {
		if (left == '[' || left == '(' || left == '{')
			return true;
		return false;
	}

	private boolean isOpenedClosedBracket(char left, char right) {
		if (left == '[' && right == ']')
			return true;
		else if (left == '(' && right == ')')
			return true;
		else if (left == '{' && right == '}')
			return true;
		return false;
	}
}

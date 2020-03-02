package org.lmater;

import java.util.ArrayDeque;
import java.util.Deque;

public class Brackets {

	public int solution(String S) {

		Deque<Character> deque = new ArrayDeque<Character>();

		char[] array = S.toCharArray();
		int n = array.length;

		if (n % 2 != 0 || (n > 0 && isOpenedBracket(array[n - 1])))
			return 0;

		for (int i = 0; i < n; i++) {

			int m = deque.size();

			if (m > (n - i + 1))
				return 0;

			if (isOpenedBracket(array[i])) {
				deque.push(array[i]);
			} else {
				if (m == 0)
					return 0;
				else if (isOpenedClosedBracket(deque.peek(), array[i]))
					deque.pop();
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

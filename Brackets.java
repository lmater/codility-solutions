package org.lmater;

import java.util.ArrayDeque;
import java.util.Deque;

public class Brackets {

	public int solution(String S) {
				Deque<Character> queue = new ArrayDeque<Character>();
		String bracket;
		char[] array = S.toCharArray();
		int n = array.length;
		if (n % 2 != 0)
			return 0;

		if (array.length > 0)
			if (array[n - 1] == '(' || array[n - 1] == '{' || array[n - 1] == '[') {
				return 0;
			}
		for (int i = 0; i < n; i++) {
			Character front = queue.peek();
			bracket = ((front == null) ? "" + array[i] : front.toString() + "" + array[i]);
			if (queue.size() > (n - i + 1) || bracket.equals(")") || bracket.equals("}") || bracket.equals("]")
					|| bracket.equals("(}") || bracket.equals("(]") || bracket.equals("{]") || bracket.equals("[)")
					|| bracket.equals("{)") || bracket.equals("[}"))
				return 0;
			else if (bracket.equals("()") || bracket.equals("{}") || bracket.equals("[]"))
				queue.poll();
			else {
				queue.push(array[i]);
			}
		}
		return 1;
	}
}

package org.lmater;

import java.util.ArrayDeque;
import java.util.Deque;

public class Brackets {

	public int solution(String S) {
		Deque<Character> queue = new ArrayDeque<Character>();
		int bracket;
		char[] array = S.toCharArray();
		if (array.length % 2 != 0)
			return 0;
		String str = "";
		for (int i = 0; i < array.length; i++) {
//			System.out.println((int) array[i]);

			Character front = queue.peek();
			bracket = ((front == null) ? array[i] : front + array[i]);
			System.out.println(front + " " + array[i] + " " + bracket + " i=" + i + " queue.size()=" + queue.size());
			if (queue.size() > (array.length - i + 1) || bracket == 41 || bracket == 93 || bracket == 125
					|| bracket == 132 || bracket == 133 || bracket == 216 || bracket == 164 || bracket == 165)
				return 0;
			else if (bracket == 248 || bracket == 81 || bracket == 184)
				queue.poll();
			else {
				queue.push(array[i]);
			}
			str += array[i];
//			System.out.println(S);
//			System.out.println(str);
		}
//		System.out.println(str);

		// "(", "{", "[", "]", "}",")".
		return 1;
	}
}

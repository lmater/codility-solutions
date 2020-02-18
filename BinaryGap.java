package org.lmater;

public class BinaryGap {

	public static int solution(int N) {
		String str = Integer.toBinaryString(N);
		int currentGap = 0;
		int longestGap = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i == 0 && str.charAt(i) == '0')
				continue;
			if (str.charAt(i) == '1') {
				if (longestGap <= currentGap) {
					longestGap = currentGap;
					currentGap = 0;
				} else
					currentGap = 0;
			} else
				currentGap++;
		}
		return longestGap;
	}
}
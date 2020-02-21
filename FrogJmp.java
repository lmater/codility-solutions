package org.lmater;


public class FrogJmp {
	public static int solution(int X, int Y, int D) {
		return (Y - X) / D + ((Y - X) % D == 0 ? 0 : 1);
	}
}

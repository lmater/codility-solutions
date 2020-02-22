package org.lmater;

public class CountDiv {
	public int solution(int A, int B, int K) {
		return (B - A) / K + ((A % K == 0) ? 1 : ((B - A) % K + A % K) / K);
	}
}

package org.lmater;

public class GenomicRangeQuery {

	public int[] solution(String S, int[] P, int[] Q) {

		int[] nuclMinImpactFactor = new int[P.length];
		int[][] flatMap = new int[4][S.length()];
		int[] vertical = new int[4];

		flatMap[charToImpact(S.charAt(0)) - 1][0] = 1;

		for (int i = 1; i < S.length(); i++) {
			flatMap[charToImpact(S.charAt(i)) - 1][i] += 1;
			for (int j = 0; j < 4; j++) {
				flatMap[j][i] += flatMap[j][i - 1];
			}
		}

		for (int i = 0; i < P.length; i++) {
			for (int j = 0; j < 4; j++) {
				vertical[j] = flatMap[j][Q[i]] - ((P[i] != 0) ? flatMap[j][P[i] - 1] : 0);
			}
			nuclMinImpactFactor[i] = (vertical[0] > 0) ? 1 : (vertical[1] > 0) ? 2 : (vertical[2] > 0) ? 3 : 4;
		}

		return nuclMinImpactFactor;
	}

	public int charToImpact(Character s) {
		return (s.equals('A')) ? 1 : (s.equals('C')) ? 2 : (s.equals('G')) ? 3 : 4;
	}
}

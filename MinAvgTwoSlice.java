package org.lmater;

import java.util.stream.IntStream;

public class MinAvgTwoSlice {

	public int solution(int[] A) {
		int n = A.length;
		int index = 0;
		double minav = (double) IntStream.of(A).sum() / n;
		double[][] avarages = new double[n - 1][n - 1];
		double[] minAvarages = new double[n - 1];
		avarages[0][0] = minav;
		minAvarages[0] = minav;

		for (int i = 0; i < n - 2; i += 2) {
			for (int j = i + 1; j < n - 1; j++) {
				avarages[i][j] = (double) (avarages[i][j - 1] * (n - (j - 1)) - A[n - (j - i)]) / (n - j);
				avarages[i + 1][j] = (double) (avarages[i][j - 1] * (n - j + 1) - A[i]) / (n - j);
				if (minAvarages[i] > avarages[i][j]) {
					minAvarages[i] = avarages[i][j];
				}
				if (minAvarages[i + 1] >= avarages[i + 1][j] || j == (i + 1)) {
					minAvarages[i + 1] = avarages[i + 1][j];
				}
				if (minav > minAvarages[i]) {
					minav = minAvarages[i];
					index = i;
				}
				if (minav > minAvarages[i + 1]) {
					minav = minAvarages[i + 1];
					index = i + 1;
				}
			}

			if (i + 2 <= n - 2) {
				avarages[i + 2][i + 2] = (double) (avarages[i + 1][i + 1] * (n - (i + 1)) - A[i + 1]) / (n - (i + 2));

				minAvarages[i + 2] = avarages[i + 2][i + 2];
				if (minav > minAvarages[i + 2]) {
					minav = minAvarages[i + 2];
					index = i + 2;
				}
			}
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				System.out.print(avarages[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < n - 1; i++) {
			System.out.print(minAvarages[i] + "  ");

		}
		System.out.println();
		System.out.println();
		System.out.println("maxav " + minav + " index " + index);
		return index;
	}
}

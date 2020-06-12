package com.petarzlatev.codingame.medium;

import java.util.Arrays;
import java.util.Scanner;

class NetworkCabling {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();
			long maxX = 0, minX = 0, avgY = 0;
			long[] arrY = new long[N];
			long result = 0;
			for (int i = 0; i < N; i++) {
				int X = in.nextInt();
				int Y = in.nextInt();
				arrY[i] = Y;
				if (i == 0) {
					maxX = X;
					minX = X;
				} else {
					if (X > maxX) {
						maxX = X;
					}
					if (X < minX) {
						minX = X;
					}
				}
			}
			Arrays.sort(arrY);

			if (N % 2 > 0) {
				avgY = arrY[(int) (N / 2)];
			} else {
				avgY = arrY[(N / 2) - 1];
			}

			result = Math.abs(maxX - minX);

			for (int i = 0; i < N; i++) {
				if (arrY[i] > avgY) {
					result += Math.abs(arrY[i] - avgY);
				} else {
					result += Math.abs(avgY - arrY[i]);
				}
			}
			System.out.println(result);
		}
	}
}
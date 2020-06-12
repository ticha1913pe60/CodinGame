package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class Smooth {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();

			for (int i = 0; i < N; i++) {
				System.out.println(reduce(in.nextLong()) ? "VICTORY" : "DEFEAT");
			}
		}
	}

	private static boolean reduce(long nb) {
		nb = reduceBy(nb, 5);
		nb = reduceBy(nb, 3);
		nb = reduceBy(nb, 2);

		return nb == 1;
	}

	private static long reduceBy(long nb, int red) {
		while (nb % red == 0) {
			nb /= red;
		}

		return nb;
	}
}
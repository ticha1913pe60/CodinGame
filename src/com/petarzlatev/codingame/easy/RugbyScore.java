package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class RugbyScore {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int tries = 0, trans = 0, pens = 0;

		for (tries = 0; tries <= N / 5; ++tries) {
			for (trans = 0; tries >= trans; ++trans) {
				for (pens = 0; pens <= N / 3; ++pens) {
					if (tries * 5 + trans * 2 + pens * 3 == N) {
						System.out.println(tries + " " + trans + " " + pens);
					}
				}
			}
		}
	}
}
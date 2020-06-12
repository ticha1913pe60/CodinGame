package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class TheRiverOne {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			long r1 = in.nextLong();
			long r2 = in.nextLong();
			int i;
			String num;

			while (r1 != r2) {
				while (r1 < r2) {
					i = 0;
					num = String.valueOf(r1);
					while (i < num.length()) {
						r1 += Integer.parseInt(num.substring(i, i + 1).trim());
						i++;
					}
				}
				while (r1 > r2) {
					i = 0;
					num = String.valueOf(r2);
					while (i < num.length()) {
						r2 += Integer.parseInt(num.substring(i, i + 1).trim());
						i++;
					}
				}
			}
			System.out.println(r1);
		}
	}
}

package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class BankRobbers {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int R = in.nextInt();
			int V = in.nextInt();
			long temp = 0;
			long[] robbers = new long[R];
			for (int i = 0; i < V; i++) {
				int C = in.nextInt();
				int N = in.nextInt();
				temp = (long) Math.pow(10, N) * (long) Math.pow(5, C - N);

				if (i < R) {
					robbers[i] = temp;
				} else {
					robbers[getRobberIndex(robbers)] += temp;
				}
			}
			printBankRobberyTime(robbers);
		}
	}

	public static void printBankRobberyTime(long[] robbers) {
		long total = 0;

		for (int i = 0; i < robbers.length; i++) {
			if (i == 0 || total < robbers[i]) {
				total = robbers[i];
			}
		}
		System.out.println(total);

	}

	public static int getRobberIndex(long[] robbers) {
		int index = 0;
		long temp = 0;

		for (int i = 0; i < robbers.length; i++) {
			if (i == 0 || temp > robbers[i]) {
				temp = robbers[i];
				index = i;
			}
		}
		return index;
	}
}
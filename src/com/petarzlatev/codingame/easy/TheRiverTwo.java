package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class TheRiverTwo {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int r1 = in.nextInt();
			boolean meetingPoint = false;

			for (int i = r1 - 1; i > 0 && !meetingPoint; i--) {
				meetingPoint = getNextNumber(i) == r1;
			}

			System.out.println(meetingPoint ? "YES" : "NO");
		}
	}

	private static long getNextNumber(long number) {
		long nextNumber = number;

		while (number > 0) {
			nextNumber += number % 10;
			number -= number % 10;
			number /= 10;
		}

		return nextNumber;
	}
}
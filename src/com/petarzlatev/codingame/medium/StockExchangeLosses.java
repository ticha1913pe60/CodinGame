package com.petarzlatev.codingame.medium;

import java.util.Scanner;

class StockExchangeLosses {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt(), maxVal = 0, maxLoss = 0;
			for (int i = 0; i < n; i++) {
				int v = in.nextInt();
				if (i == 0 || maxVal < v) {
					maxVal = v;
				}
				if (i > 0 && (v - maxVal) < maxLoss) {
					maxLoss = v - maxVal;
				}
			}
			System.out.println(maxLoss);
		}
	}
}
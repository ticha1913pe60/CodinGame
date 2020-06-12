package com.petarzlatev.codingame.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CreditCardVerifier {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int result = 0;

			if (in.hasNextLine()) {
				in.nextLine();
			}
			for (int i = 0; i < n; i++) {
				String card = in.nextLine();
				result = calculateCard(card);
				System.out.println(result % 10 == 0 ? "YES" : "NO");
			}
		}
	}

	public static int calculateCard(String card) {
		int result = 0;
		List<Integer> cardNum = new ArrayList<Integer>();
		card = card.replaceAll("\\s", "");

		for (int i = 0; i < card.length(); i++) {
			cardNum.add(Integer.valueOf(card.substring(i, i + 1)));
		}

		for (int i = 0; i < cardNum.size(); i++) {
			if (i % 2 == 0) {
				result += cardNum.get(i) * 2 > 9 ? cardNum.get(i) * 2 - 9 : cardNum.get(i) * 2;
			} else {
				result += cardNum.get(i);
			}
		}

		return result;
	}
}
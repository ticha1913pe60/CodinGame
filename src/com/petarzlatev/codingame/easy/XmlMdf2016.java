package com.petarzlatev.codingame.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class XmlMdf2016 {
	private static HashMap<Character, Double> weight = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String sequence = in.nextLine();

			System.err.println(sequence);

			char[] charArray = sequence.toCharArray();
			int depth = 0;
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] == '-') {
					i++;
					weight.putIfAbsent(charArray[i], 0d);
					weight.put(charArray[i], weight.get(charArray[i]) + (1d / depth));
					depth--;
				} else {
					depth++;
				}
			}
		}
		Map.Entry<Character, Double> max = null;
		for (Map.Entry<Character, Double> entry : weight.entrySet()) {
			if (max == null || max.getValue() < entry.getValue()) {
				max = entry;
			}
		}

		System.out.println(max != null ? max.getKey() : null);
	}
}
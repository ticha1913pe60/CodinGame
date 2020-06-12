package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class ASCIIArt {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int L = in.nextInt();
			int H = in.nextInt();
			in.nextLine();
			String T = in.nextLine();
			char[] text = new char[T.length()];
			int ascii[] = new int[T.length()];
			String answer = "";

			text = T.toCharArray();
			for (int i = 0; i < text.length; i++) {
				text[i] = Character.toUpperCase(text[i]);
				ascii[i] = ((int) text[i]) - 64;
			}
			for (int i = 0; i < H; i++) {
				String ROW = in.nextLine();
				answer = "";
				for (int j = 0; j < ascii.length; j++) {
					if (ascii[j] < 1 || ascii[j] > 26) {
						answer += ROW.substring(ROW.length() - L, ROW.length());
					} else {
						answer += ROW.substring((ascii[j] - 1) * L, (ascii[j] - 1) * L + L);
					}
				}
				System.out.println(answer);
			}
		}
	}
}
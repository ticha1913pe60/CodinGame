package com.petarzlatev.codingame.medium;

import java.util.Arrays;
import java.util.Scanner;

class TelephoneNumbers {
	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();
			int nCount = 0, maxLen = 0;
			String[] phones = new String[N];
			for (int i = 0; i < N; i++) {
				String telephone = in.next();

				phones[i] = telephone;
			}
			Arrays.sort(phones);

			for (int i = 0; i < N; i++) {
				if (i == 0) {
					nCount = phones[i].length();
				} else {
					maxLen = Math.min(phones[i].length(), phones[i - 1].length());
					for (int j = 0; j < maxLen; j++) {
						if (!phones[i].substring(0, j + 1).equals(phones[i - 1].substring(0, j + 1))) {
							nCount += phones[i].length() - j;
							break;
						} else if (j == maxLen - 1) {
							nCount += phones[i].length() - (j + 1);
							break;
						}
					}
				}
			}
			System.out.println(nCount); // The number of elements (referencing a number) stored in the structure.
		}
	}
}
package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class ChuckNorris {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			String MESSAGE = in.nextLine();
			String answer = "";
			char currSymbol = ' ';
			char thisSymbol = ' ';
			int bInt;
			char[] bytes;
			System.err.println(MESSAGE);
			for (byte b : MESSAGE.getBytes()) {
				bInt = b;

				if (bInt - 64 >= 0) {
					answer = answer + "1";
					bInt = bInt - 64;
				} else {
					answer = answer + "0";
				}
				if (bInt - 32 >= 0) {
					answer = answer + "1";
					bInt = bInt - 32;
				} else {
					answer = answer + "0";
				}
				if (bInt - 16 >= 0) {
					answer = answer + "1";
					bInt = bInt - 16;
				} else {
					answer = answer + "0";
				}
				if (bInt - 8 >= 0) {
					answer = answer + "1";
					bInt = bInt - 8;
				} else {
					answer = answer + "0";
				}
				if (bInt - 4 >= 0) {
					answer = answer + "1";
					bInt = bInt - 4;
				} else {
					answer = answer + "0";
				}
				if (bInt - 2 >= 0) {
					answer = answer + "1";
					bInt = bInt - 2;
				} else {
					answer = answer + "0";
				}
				if (bInt == 1) {
					answer = answer + "1";
					bInt = bInt - 1;
				} else {
					answer = answer + "0";
				}
			}
			bytes = answer.toCharArray();

			for (int ii = 0; ii < bytes.length; ii++) {
				thisSymbol = bytes[ii];
				if (ii == 0) {
					currSymbol = thisSymbol;
					if (currSymbol == '1') {
						answer = "0 0";
					} else {
						answer = "00 0";
					}
				} else {
					if (currSymbol == thisSymbol) {
						answer += "0";
					} else {
						currSymbol = thisSymbol;
						if (currSymbol == '1') {
							answer += " 0 0";
						} else {
							answer += " 00 0";
						}
					}
				}
			}
			System.out.println(answer);
		}
	}
}
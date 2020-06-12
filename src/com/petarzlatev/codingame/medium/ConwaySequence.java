package com.petarzlatev.codingame.medium;

import java.util.Scanner;

class ConwaySequence {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int R = in.nextInt();
			int L = in.nextInt();
			int nCount = 0;
			String sequence = R + "&";
			String[] arrSeq = new String[L];
			String[] currRow = new String[1000];

			for (int i = 0; i < L; i++) {
				if (i == 0) {
					arrSeq[i] = Integer.toString(R);
				} else if (i == 1) {
					arrSeq[i] = "1 " + R;
				} else {
					arrSeq[i] = "";
				}
			}

			for (int i = 2; i < L; i++) {
				currRow = arrSeq[i - 1].split(" ");

				nCount = 1;
				for (int j = 1; j < currRow.length; j++) {
					if (!currRow[j].equals(currRow[j - 1])) {
						if (arrSeq[i].equals("")) {
							arrSeq[i] = nCount + " " + currRow[j - 1] + " ";
						} else {
							arrSeq[i] += nCount + " " + currRow[j - 1] + " ";
						}
						nCount = 1;
					} else {
						nCount++;
					}
				}
				if (arrSeq[i].equals("")) {
					arrSeq[i] = nCount + " " + currRow[currRow.length - 1] + " ";
				} else {
					arrSeq[i] += nCount + " " + currRow[currRow.length - 1] + " ";
				}
			}
			System.out.println(arrSeq[L - 1].trim());
		}
	}
}
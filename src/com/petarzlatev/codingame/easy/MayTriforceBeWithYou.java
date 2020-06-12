package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class MayTriforceBeWithYou {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int quarter = in.nextInt();
			int cut;
			String line;

			for (int i = 1; i <= 2 * quarter; i++) {
			    if (i == 1) {
			        line = ".";
			        cut = 1;
			    } else {
			        line = "";
			        cut = 0;
			    }

			    for (int n = 1; n <= 2 * quarter + i - cut - 1; n++) {
			        if (i <= quarter) {
			            if ((n + cut) <= (2 * quarter - i) || (n + cut) >= (2 * quarter + i)) {
			                line += " ";
			            } else {
			                line += "*";
			            }
			        } else {
			            if (((n + cut) <= (quarter - (i - quarter))) || ((n + cut) >= (quarter + (i - quarter))
			                    && ((n + cut) <= (3 * quarter - (i - quarter))))) {
			                line += " ";
			            } else {
			                line += "*";
			            }
			        }
			    }
			    System.out.println(line);
			}
		}
    }
}
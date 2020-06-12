package com.petarzlatev.codingame.easy;

import java.util.ArrayList;
import java.util.Scanner;

class BracketsExtremeEdition {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			String expression = in.next();
			String answer;
			int ii;
			ArrayList<String> open = new ArrayList<String>();

			ii = 0;
			answer = "true";
			while (ii < expression.length()) {
				if (expression.substring(ii, ii + 1).equals("{") || expression.substring(ii, ii + 1).equals("[")
						|| expression.substring(ii, ii + 1).equals("(") || expression.substring(ii, ii + 1).equals("}")
						|| expression.substring(ii, ii + 1).equals("]")
						|| expression.substring(ii, ii + 1).equals(")")) {
					if (expression.substring(ii, ii + 1).equals("{") || expression.substring(ii, ii + 1).equals("[")
							|| expression.substring(ii, ii + 1).equals("(")) {
						open.add(expression.substring(ii, ii + 1));
					} else {
						if ((expression.substring(ii, ii + 1).equals("}") && open.size() > 0
								&& open.get(open.size() - 1).equals("{"))
								|| (expression.substring(ii, ii + 1).equals("]") && open.size() > 0
										&& open.get(open.size() - 1).equals("["))
								|| (expression.substring(ii, ii + 1).equals(")") && open.size() > 0
										&& open.get(open.size() - 1).equals("("))) {
							open.remove(open.size() - 1);
						} else {
							answer = "false";
							break;
						}
					}
				}
				ii++;
			}
			if (open.size() > 0) {
				answer = "false";
			}
			System.out.println(answer);
		}
	}
}
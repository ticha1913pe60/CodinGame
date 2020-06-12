package com.petarzlatev.codingame.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ISBNCheckDigit {

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();
			int nAdd = 0;
			int nDigit = 0;
			boolean bContinue = true;
			List<String> listISBNs = new ArrayList<>();
			List<String> invalid = new ArrayList<>();
			if (in.hasNextLine()) {
				in.nextLine();
			}

			for (int i = 0; i < N; i++) {
				String ISBN = in.nextLine();
				listISBNs.add(ISBN);
			}

			for (int i = 0; i < listISBNs.size(); i++) {
				nAdd = 0;
				if (listISBNs.get(i).length() == 10 || listISBNs.get(i).length() == 13) {
					if (listISBNs.get(i).length() == 13) {
						bContinue = true;
						for (int n = 0; n < listISBNs.get(i).length(); n++) {
							if (!isNumeric(listISBNs.get(i).substring(n, n + 1))) {
								invalid.add(listISBNs.get(i));
								bContinue = false;
								break;
							} else if (n < listISBNs.get(i).length() - 1) {
								if (n % 2 == 0) {
									nAdd += Integer.parseInt(listISBNs.get(i).substring(n, n + 1));
								} else {
									nAdd += 3 * Integer.parseInt(listISBNs.get(i).substring(n, n + 1));
								}
							}
						}
						if (bContinue) {
							nDigit = 10 - nAdd % 10;
							if (nDigit == 10) {
								nDigit = 0;
							}
							if (nDigit != Integer.parseInt(
									listISBNs.get(i).substring(listISBNs.get(i).length() - 1, listISBNs.get(i).length()))) {
								invalid.add(listISBNs.get(i));
							}
						}
					} else {
						bContinue = true;
						for (int n = 0; n < listISBNs.get(i).length() - 1; n++) {
							if (!isNumeric(listISBNs.get(i).substring(n, n + 1))) {
								invalid.add(listISBNs.get(i));
								bContinue = false;
								break;
							} else if (n < listISBNs.get(i).length() - 1) {
								nAdd += (10 - n) * Integer.parseInt(listISBNs.get(i).substring(n, n + 1));
							}
						}
						if (bContinue) {
							nDigit = 11 - nAdd % 11;
							if (nDigit == 11) {
								nDigit = 0;
							}
							if (nDigit == 10 && !listISBNs.get(i)
									.substring(listISBNs.get(i).length() - 1, listISBNs.get(i).length()).equals("X")) {
								invalid.add(listISBNs.get(i));
							} else if (nDigit < 10 && (!isNumeric(
									listISBNs.get(i).substring(listISBNs.get(i).length() - 1, listISBNs.get(i).length()))
									|| !String.valueOf(nDigit).equals(listISBNs.get(i)
											.substring(listISBNs.get(i).length() - 1, listISBNs.get(i).length())))) {
								invalid.add(listISBNs.get(i));
							}
						}
					}
				} else {
					invalid.add(listISBNs.get(i));
				}
			}

			System.out.println(invalid.size() + " invalid:");

			for (int i = 0; i < invalid.size(); i++) {
				System.out.println(invalid.get(i));
			}
		}
	}
}
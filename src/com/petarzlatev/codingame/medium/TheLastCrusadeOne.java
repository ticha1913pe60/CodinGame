package com.petarzlatev.codingame.medium;

import java.util.Scanner;

class TheLastCrusadeOne {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int W = in.nextInt(); // number of columns.
			int H = in.nextInt(); // number of rows.
			String[][] roomsList = new String[H][W];
			in.nextLine();
			for (int i = 0; i < H; i++) {
				String LINE = in.nextLine(); // represents a line in the grid and contains W integers. Each integer
												// represents one room of a given type.
				roomsList[i] = LINE.split(" ");
			}
			int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first
									// mission, but must be read).

			// game loop
			while (true) {
				int XI = in.nextInt();
				int YI = in.nextInt();
				String POS = in.next();

				if (roomsList[YI][XI].equals("1")) {
					System.out.println(XI + " " + (YI + 1));
				}
				if (roomsList[YI][XI].equals("2")) {
					if (POS.equals("LEFT")) {
						System.out.println((XI + 1) + " " + YI);
					} else if (POS.equals("RIGHT")) {
						System.out.println((XI - 1) + " " + YI);
					}
				}
				if (roomsList[YI][XI].equals("3")) {
					System.out.println(XI + " " + (YI + 1));
				}
				if (roomsList[YI][XI].equals("4")) {
					if (POS.equals("TOP")) {
						System.out.println((XI - 1) + " " + YI);
					} else if (POS.equals("RIGHT")) {
						System.out.println(XI + " " + (YI + 1));
					}
				}
				if (roomsList[YI][XI].equals("5")) {
					if (POS.equals("TOP")) {
						System.out.println((XI + 1) + " " + YI);
					} else if (POS.equals("LEFT")) {
						System.out.println(XI + " " + (YI + 1));
					}
				}
				if (roomsList[YI][XI].equals("6")) {
					if (POS.equals("LEFT")) {
						System.out.println((XI + 1) + " " + YI);
					} else if (POS.equals("RIGHT")) {
						System.out.println((XI - 1) + " " + YI);
					}
				}
				if (roomsList[YI][XI].equals("7")) {
					System.out.println(XI + " " + (YI + 1));
				}
				if (roomsList[YI][XI].equals("8")) {
					System.out.println(XI + " " + (YI + 1));
				}
				if (roomsList[YI][XI].equals("9")) {
					System.out.println(XI + " " + (YI + 1));
				}
				if (roomsList[YI][XI].equals("10")) {
					System.out.println((XI - 1) + " " + YI);
				}
				if (roomsList[YI][XI].equals("11")) {
					System.out.println((XI + 1) + " " + YI);
				}
				if (roomsList[YI][XI].equals("12")) {
					System.out.println(XI + " " + (YI + 1));
				}
				if (roomsList[YI][XI].equals("13")) {
					System.out.println(XI + " " + (YI + 1));
				}
			}
		}
	}
}
package com.petarzlatev.codingame.medium;

import java.util.Scanner;

class ShadowsOfTheKnightOne {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int W = in.nextInt(); // width of the building.
			int H = in.nextInt(); // height of the building.
			int N = in.nextInt(); // maximum number of turns before game over.
			int X0 = in.nextInt();
			int Y0 = in.nextInt();
			int maxX = W - 1, minX = 0, maxY = H - 1, minY = 0, stepX = Math.max(1, W / 2), stepY = Math.max(1, H / 2);

			while (true) {
				String BOMBDIR = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR,
											// D, DL, L or UL)

				if (BOMBDIR.equals("U")) {
					maxY = Y0;
					stepY = Math.max(1, (int) Math.ceil(Math.abs((double) (maxY - minY)) / 2));
					Y0 = Math.max(0, Y0 - stepY);
				} else if (BOMBDIR.equals("UR")) {
					minX = X0;
					maxY = Y0;
					stepX = Math.max(1, (int) Math.ceil(Math.abs((double) (maxX - minX)) / 2));
					stepY = Math.max(1, (int) Math.ceil(Math.abs((double) (maxY - minY)) / 2));
					X0 = Math.min(W - 1, X0 + stepX);
					Y0 = Math.max(0, Y0 - stepY);
				} else if (BOMBDIR.equals("R")) {
					minX = X0;
					stepX = Math.max(1, (int) Math.ceil(Math.abs((double) (maxX - minX)) / 2));
					X0 = Math.min(W - 1, X0 + stepX);
				} else if (BOMBDIR.equals("DR")) {
					minX = X0;
					minY = Y0;
					stepX = Math.max(1, (int) Math.ceil(Math.abs((double) (maxX - minX)) / 2));
					stepY = Math.max(1, (int) Math.ceil(Math.abs((double) (maxY - minY)) / 2));
					X0 = Math.min(W - 1, X0 + stepX);
					Y0 = Math.min(H - 1, Y0 + stepY);
				} else if (BOMBDIR.equals("D")) {
					minY = Y0;
					stepY = Math.max(1, (int) Math.ceil(Math.abs((double) (maxY - minY)) / 2));
					Y0 = Math.min(H - 1, Y0 + stepY);
				} else if (BOMBDIR.equals("DL")) {
					maxX = X0;
					minY = Y0;
					stepX = Math.max(1, (int) Math.ceil(Math.abs((double) (maxX - minX)) / 2));
					stepY = Math.max(1, (int) Math.ceil(Math.abs((double) (maxY - minY)) / 2));
					X0 = Math.max(0, X0 - stepX);
					Y0 = Math.min(H - 1, Y0 + stepY);
				} else if (BOMBDIR.equals("L")) {
					maxX = X0;
					stepX = Math.max(1, (int) Math.ceil(Math.abs((double) (maxX - minX)) / 2));
					X0 = Math.max(0, X0 - stepX);
				} else if (BOMBDIR.equals("UL")) {
					maxX = X0;
					maxY = Y0;
					stepX = Math.max(1, (int) Math.ceil(Math.abs((double) (maxX - minX)) / 2));
					stepY = Math.max(1, (int) Math.ceil(Math.abs((double) (maxY - minY)) / 2));
					X0 = Math.max(0, X0 - stepX);
					Y0 = Math.max(0, Y0 - stepY);
				}
				System.out.println(X0 + " " + Y0);
			}
		}
	}
}
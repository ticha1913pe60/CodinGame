package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class MarsLanderEpisodeOne {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
			int maxY = 0;

			for (int i = 0; i < surfaceN; i++) {
				int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
				int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a
											// sequential fashion, you form the surface of Mars.
			}

			// game loop
			while (true) {
				int X = in.nextInt();
				int Y = in.nextInt();
				int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
				int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
				int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
				int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
				int power = in.nextInt(); // the thrust power (0 to 4).

				if (maxY < Y) {
					maxY = Y;
				}

				if (Y > maxY * 0.92) {
					System.out.println("0 1");
				} else if (Y > maxY * 0.82) {
					System.out.println("0 2");
				} else if (Y > maxY * 0.68) {
					System.out.println("0 3");
				} else {
					System.out.println("0 4");
				}
			}
		}
	}

}
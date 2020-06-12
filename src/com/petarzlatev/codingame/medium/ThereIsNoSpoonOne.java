package com.petarzlatev.codingame.medium;

import java.util.Scanner;

class ThereIsNoSpoonOne {
	public static int getRightNodeHeight(char[][] map, int height, int width) {
		int result = -1;

		for (int j = width + 1; j < map[height].length; j++) {
			if (map[height][j] == '0') {
				result = height;
				break;
			}
		}

		return result;
	}

	public static int getRightNodeWidth(char[][] map, int height, int width) {
		int result = -1;

		for (int j = width + 1; j < map[height].length; j++) {
			if (map[height][j] == '0') {
				result = j;
				break;
			}
		}

		return result;
	}

	public static int getBottomNodeHeight(char[][] map, int height, int width) {
		int result = -1;

		for (int i = height + 1; i < map.length; i++) {
			if (map[i][width] == '0') {
				result = i;
				break;
			}
		}

		return result;
	}

	public static int getBottomNodeWidth(char[][] map, int height, int width) {
		int result = -1;

		for (int i = height + 1; i < map.length; i++) {
			if (map[i][width] == '0') {
				result = width;
				break;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int width = in.nextInt(); // the number of cells on the X axis
			int height = in.nextInt(); // the number of cells on the Y axis
			char[][] map = new char[height][width];
			char[] widths = new char[width];
			in.nextLine();
			for (int i = 0; i < height; i++) {
				String line = in.nextLine(); // width characters, each either 0 or .
				widths = line.toCharArray();
				for (int j = 0; j < width; j++) {
					map[i][j] = widths[j];
				}
			}

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (map[i][j] == '0') {
						System.out.println(j + " " + i + " " + getRightNodeWidth(map, i, j) + " "
								+ getRightNodeHeight(map, i, j) + " " + getBottomNodeWidth(map, i, j) + " "
								+ getBottomNodeHeight(map, i, j) + " ");
					}
				}
			}
		}
	}
}
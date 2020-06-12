package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class SudokuValidator {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			boolean check = true;
			int[][] rows = new int[9][9];
			int[][] cols = new int[9][9];
			int[][] grid = new int[9][9];

			for (int i = 0; i < 9 && check; i++) {
				for (int j = 0; j < 9 && check; j++) {
					int n = in.nextInt();
					grid[i][j] = n;
					check = rows[i][n - 1] == 0;
					rows[i][n - 1] = 1;
					if (check) {
						check = cols[n - 1][j] == 0;
						cols[n - 1][j] = 1;
					}
				}
			}

			if (check) {
				check = checkGrid(0, 0, grid) && checkGrid(0, 3, grid) && checkGrid(0, 6, grid) && checkGrid(3, 0, grid)
						&& checkGrid(3, 3, grid) && checkGrid(3, 6, grid) && checkGrid(6, 0, grid) && checkGrid(6, 3, grid)
						&& checkGrid(6, 6, grid);
			}

			System.out.println(check ? "true" : "false");
		}
	}

	public static boolean checkGrid(int from, int to, int[][] grid) {
		int[] values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		boolean check = true;

		for (int i = from; i < from + 3 && check; i++) {
			for (int j = to; j < to + 3 && check; j++) {
				check = values[grid[i][j] - 1] != 0;
				values[grid[i][j] - 1] = 0;
			}
		}

		return check;
	}
}
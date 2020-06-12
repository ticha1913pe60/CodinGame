package com.petarzlatev.codingame.medium;

import java.util.Scanner;

class BenderOne {
	public static String[] getDirection(Boolean lStraight, String[][] elements, int currX, int currY) {
		String[] result = new String[3];
		String direction = " ";

		if (lStraight) {
			if (!elements[currX + 1][currY].equals("#") && !elements[currX + 1][currY].equals("X")) {
				currX++;
				direction = "SOUTH";
			} else if (!elements[currX][currY + 1].equals("#") && !elements[currX][currY + 1].equals("X")) {
				currY++;
				direction = "EAST";
			} else if (!elements[currX - 1][currY].equals("#") && !elements[currX - 1][currY].equals("X")) {
				currX--;
				direction = "NORTH";
			} else if (!elements[currX][currY - 1].equals("#") && !elements[currX][currY - 1].equals("X")) {
				currY--;
				direction = "WEST";
			}
		} else {
			if (!elements[currX][currY - 1].equals("#") && !elements[currX][currY - 1].equals("X")) {
				currY--;
				direction = "WEST";
			} else if (!elements[currX - 1][currY].equals("#") && !elements[currX - 1][currY].equals("X")) {
				currX--;
				direction = "NORTH";
			} else if (!elements[currX][currY + 1].equals("#") && !elements[currX][currY + 1].equals("X")) {
				currY++;
				direction = "EAST";
			} else if (!elements[currX + 1][currY].equals("#") && !elements[currX + 1][currY].equals("X")) {
				currX++;
				direction = "SOUTH";
			}
		}
		result[0] = direction;
		result[1] = Integer.toString(currX);
		result[2] = Integer.toString(currY);

		return result;
	}

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int L = in.nextInt();
			int C = in.nextInt();
			int nMoves = 0, nCount = 0;
			int currX = 0, currY = 0;
			int nextX = 0, nextY = 0;
			int tel1X = 0, tel1Y = 0, tel2X = 0, tel2Y = 0;
			String direction = "INIT";
			String[][] elements = new String[L][C];
			String[] moves = new String[L * C];
			String[] result = new String[3];
			Boolean lStraight = true, lBreaker = false, lNotTeleport = true;
			in.nextLine();
			for (int i = 0; i < L; i++) {
				String row = in.nextLine();

				elements[i] = row.split("");
			}

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < C; j++) {
					System.err.print(elements[i][j]);
					if (elements[i][j].equals("@")) {
						currX = i;
						currY = j;
					} else if (elements[i][j].equals("T")) {
						if (tel1X == 0 && tel1Y == 0) {
							tel1X = i;
							tel1Y = j;
						} else {
							tel2X = i;
							tel2Y = j;
						}
					}
				}
				System.err.println("");
			}

			while (nMoves < (L * C)) {
				nCount++;
				if (direction.equals("INIT")) {
					direction = "SOUTH";
				}

				if (direction.equals("SOUTH")) {
					nextX = currX + 1;
					nextY = currY;
				} else if (direction.equals("EAST")) {
					nextX = currX;
					nextY = currY + 1;
				} else if (direction.equals("NORTH")) {
					nextX = currX - 1;
					nextY = currY;
				} else if (direction.equals("WEST")) {
					nextX = currX;
					nextY = currY - 1;
				}

				if (lNotTeleport && elements[currX][currY].equals("T")) {
					if (currX == tel1X && currY == tel1Y) {
						currX = tel2X;
						currY = tel2Y;
					} else {
						currX = tel1X;
						currY = tel1Y;
					}
					lNotTeleport = false;
				} else if (elements[currX][currY].equals("B")) {
					lBreaker = !lBreaker;
					if (lBreaker && elements[nextX][nextY].equals("X")) {
						elements[nextX][nextY] = " ";
					}
					if (!elements[nextX][nextY].equals("#") && !elements[nextX][nextY].equals("X")) {
						currX = nextX;
						currY = nextY;
					} else {
						result = getDirection(lStraight, elements, currX, currY);
						direction = result[0];
						currX = Integer.parseInt(result[1]);
						currY = Integer.parseInt(result[2]);
					}
				} else if (lBreaker && elements[nextX][nextY].equals("X")) {
					elements[nextX][nextY] = " ";
					if (elements[currX][currY].equals("I")) {
						lStraight = !lStraight;
					}
					currX = nextX;
					currY = nextY;
				} else if ((elements[currX][currY].equals(" ") || elements[currX][currY].equals("@")
						|| elements[currX][currY].equals("I") || elements[currX][currY].equals("T"))
						&& (!elements[nextX][nextY].equals("#") && (lBreaker || !elements[nextX][nextY].equals("X")))) {
					if (elements[currX][currY].equals("I")) {
						lStraight = !lStraight;
					} else if (elements[currX][currY].equals("T")) {
						lNotTeleport = true;
					}
					currX = nextX;
					currY = nextY;
				} else if (elements[currX][currY].equals("S") && !elements[currX + 1][currY].equals("#")
						&& (lBreaker || !elements[currX + 1][currY].equals("X"))) {
					currX++;
					direction = "SOUTH";
					if (lBreaker && elements[nextX][nextY].equals("X")) {
						elements[nextX][nextY] = " ";
					}
				} else if (elements[currX][currY].equals("E") && !elements[currX][currY + 1].equals("#")
						&& (lBreaker || !elements[currX][currY + 1].equals("X"))) {
					currY++;
					direction = "EAST";
					if (lBreaker && elements[nextX][nextY].equals("X")) {
						elements[nextX][nextY] = " ";
					}
				} else if (elements[currX][currY].equals("N") && !elements[currX - 1][currY].equals("#")
						&& (lBreaker || !elements[currX - 1][currY].equals("X"))) {
					currX--;
					direction = "NORTH";
					if (lBreaker && elements[nextX][nextY].equals("X")) {
						elements[nextX][nextY] = " ";
					}
				} else if (elements[currX][currY].equals("W") && !elements[currX][currY - 1].equals("#")
						&& (lBreaker || !elements[currX][currY - 1].equals("X"))) {
					currY--;
					direction = "WEST";
					if (lBreaker && elements[nextX][nextY].equals("X")) {
						elements[nextX][nextY] = " ";
					}
				} else {
					if (elements[currX][currY].equals("I")) {
						lStraight = !lStraight;
					} else if (elements[currX][currY].equals("T")) {
						lNotTeleport = true;
					}
					result = getDirection(lStraight, elements, currX, currY);
					direction = result[0];
					currX = Integer.parseInt(result[1]);
					currY = Integer.parseInt(result[2]);
				}
				if (!elements[currX][currY].equals("T") || lNotTeleport) {
					moves[nMoves] = direction;
				}
				if (elements[currX][currY].equals("$")) {
					break;
				}
				nMoves++;
			}
			if (nMoves == (L * C)) {
				System.out.println("LOOP");
			} else {
				for (int i = 0; i < moves.length; i++) {
					if (moves[i] != null && moves[i].length() > 0) {
						System.out.println(moves[i]);
					}
				}
			}
		}
	}
}
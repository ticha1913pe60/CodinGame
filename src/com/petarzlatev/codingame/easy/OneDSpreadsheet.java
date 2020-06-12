package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class OneDSpreadsheet {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();
			int result;
			int index1;
			int index2;
			String rows[][] = new String[N][4];
			String operation;
			String arg1;
			String arg2;
			for (int i = 0; i < N; i++) {
				operation = in.next();
				arg1 = in.next();
				arg2 = in.next();
				rows[i][0] = operation;
				rows[i][1] = arg1;
				rows[i][2] = arg2;
				rows[i][3] = "0";
			}
			for (int ii = 0; ii < N; ii++) {
				for (int i = 0; i < N; i++) {
					operation = rows[i][0];
					arg1 = rows[i][1];
					arg2 = rows[i][2];
					if (operation.equals("VALUE") && arg2.equals("_")) {
						if (arg1.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							result = Integer.parseInt(rows[index1][3]);
						} else {
							result = Integer.parseInt(arg1);
						}
					} else if (operation.equals("ADD")) {
						if (arg1.substring(0, 1).equals("$") && arg2.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(rows[index1][3]) + Integer.parseInt(rows[index2][3]);
						} else if (arg1.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							result = Integer.parseInt(rows[index1][3]) + Integer.parseInt(arg2);
						} else if (arg2.substring(0, 1).equals("$")) {
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(arg1) + Integer.parseInt(rows[index2][3]);
						} else {
							result = Integer.parseInt(arg1) + Integer.parseInt(arg2);
						}
					} else if (operation.equals("SUB")) {
						if (arg1.substring(0, 1).equals("$") && arg2.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(rows[index1][3]) - Integer.parseInt(rows[index2][3]);
						} else if (arg1.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							result = Integer.parseInt(rows[index1][3]) - Integer.parseInt(arg2);
						} else if (arg2.substring(0, 1).equals("$")) {
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(arg1) - Integer.parseInt(rows[index2][3]);
						} else {
							result = Integer.parseInt(arg1) - Integer.parseInt(arg2);
						}
					} else if (operation.equals("MULT")) {
						if (arg1.substring(0, 1).equals("$") && arg2.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(rows[index1][3]) * Integer.parseInt(rows[index2][3]);
						} else if (arg1.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							result = Integer.parseInt(rows[index1][3]) * Integer.parseInt(arg2);
						} else if (arg2.substring(0, 1).equals("$")) {
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(arg1) * Integer.parseInt(rows[index2][3]);
						} else {
							result = Integer.parseInt(arg1) * Integer.parseInt(arg2);
						}
					} else {
						result = 0;
					}
					rows[i][3] = Integer.toString(result);
				}

				for (int i = 0; i < N; i++) {
					operation = rows[i][0];
					arg1 = rows[i][1];
					arg2 = rows[i][2];
					if (operation.equals("VALUE") && arg2.equals("_")) {
						if (arg1.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							result = Integer.parseInt(rows[index1][3]);
						} else {
							result = Integer.parseInt(arg1);
						}
					} else if (operation.equals("ADD")) {
						if (arg1.substring(0, 1).equals("$") && arg2.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(rows[index1][3]) + Integer.parseInt(rows[index2][3]);
						} else if (arg1.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							result = Integer.parseInt(rows[index1][3]) + Integer.parseInt(arg2);
						} else if (arg2.substring(0, 1).equals("$")) {
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(arg1) + Integer.parseInt(rows[index2][3]);
						} else {
							result = Integer.parseInt(arg1) + Integer.parseInt(arg2);
						}
					} else if (operation.equals("SUB")) {
						if (arg1.substring(0, 1).equals("$") && arg2.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(rows[index1][3]) - Integer.parseInt(rows[index2][3]);
						} else if (arg1.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							result = Integer.parseInt(rows[index1][3]) - Integer.parseInt(arg2);
						} else if (arg2.substring(0, 1).equals("$")) {
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(arg1) - Integer.parseInt(rows[index2][3]);
						} else {
							result = Integer.parseInt(arg1) - Integer.parseInt(arg2);
						}
					} else if (operation.equals("MULT")) {
						if (arg1.substring(0, 1).equals("$") && arg2.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(rows[index1][3]) * Integer.parseInt(rows[index2][3]);
						} else if (arg1.substring(0, 1).equals("$")) {
							index1 = Integer.parseInt(arg1.substring(1));
							result = Integer.parseInt(rows[index1][3]) * Integer.parseInt(arg2);
						} else if (arg2.substring(0, 1).equals("$")) {
							index2 = Integer.parseInt(arg2.substring(1));
							result = Integer.parseInt(arg1) * Integer.parseInt(rows[index2][3]);
						} else {
							result = Integer.parseInt(arg1) * Integer.parseInt(arg2);
						}
					} else {
						result = 0;
					}
					rows[i][3] = Integer.toString(result);
				}
			}
			for (int i = 0; i < N; i++) {
				System.out.println(rows[i][3]);
			}
		}
	}
}
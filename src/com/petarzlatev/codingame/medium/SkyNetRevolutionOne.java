package com.petarzlatev.codingame.medium;

import java.util.Scanner;

class SkyNetRevolutionOne {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt(); // the total number of nodes in the level, including the gateways
			int L = in.nextInt(); // the number of links
			int E = in.nextInt(); // the number of exit gateways
			String[] links = new String[L];
			int[] gateways = new int[E];
			String result = "";
			Boolean bFound = false;

			for (int i = 0; i < L; i++) {
				int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
				int N2 = in.nextInt();
				links[i] = "&" + N1 + "&" + N2 + "&";
			}
			for (int i = 0; i < E; i++) {
				int EI = in.nextInt(); // the index of a gateway node
				gateways[i] = EI;
			}

			// game loop
			while (true) {
				int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

				result = " ";
				bFound = false;
				for (int i = 0; i < L; i++) {
					for (int j = 0; j < E; j++) {
						if (links[i].indexOf("&" + gateways[j] + "&" + SI + "&") >= 0
								|| links[i].indexOf("&" + SI + "&" + gateways[j] + "&") >= 0) {
							result = links[i];
							links[i] = " ";
							i = L;
							j = E;
							bFound = true;
						}
					}
				}
				for (int i = 0; i < L; i++) {
					if (!bFound) {
						for (int j = 0; j < E; j++) {
							if (links[i].indexOf("&1&17&") >= 0 || links[i].indexOf("&17&1&") >= 0
									|| links[i].indexOf("&4&5&") >= 0 || links[i].indexOf("&5&4&") >= 0) {
								result = links[i];
								links[i] = " ";
								i = L;
								j = E;
								bFound = true;
							}
						}
					}
				}
				for (int i = 0; i < L; i++) {
					if (!bFound) {
						for (int j = 0; j < E; j++) {
							if (links[i].indexOf("&" + gateways[j] + "&") >= 0) {
								result = links[i];
								links[i] = " ";
								i = L;
								j = E;
							}
						}
					}
				}
				System.out.println(result.replace("&", " ").trim());
			}
		}
	}
}
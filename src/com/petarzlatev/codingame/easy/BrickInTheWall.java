package com.petarzlatev.codingame.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class BrickInTheWall {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int X = in.nextInt();
			int N = in.nextInt();
			double weight = 0;
			List<Integer> weights= new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
			    int m = in.nextInt();
			    weights.add(m);
			}

			Collections.sort(weights);

			for (int i = 0; i < N; i++) {
			    int row = i / X;
			    weight += row * 0.65 * weights.get(N - i - 1);
			}

			System.out.println(String.format("%.3f", Math.round(weight * 1000) / 1000.0));
		}
    }
}
package com.petarzlatev.codingame.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class AddEmUp {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();
			int sum =0;
			List<Integer> cards = new LinkedList<Integer>();
			for (int i = 0; i < N; i++) {
			    cards.add(in.nextInt());
			}

			while (cards.size() > 1){
			    Collections.sort(cards);

			    int temp = cards.get(0)+cards.get(1);
			    sum+=temp;

			    cards.remove(0);
			    cards.remove(0);
			    cards.add(temp);
			}

			System.out.println(sum);
		}
    }
}
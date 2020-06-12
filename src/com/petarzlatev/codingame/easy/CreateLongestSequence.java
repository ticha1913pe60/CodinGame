package com.petarzlatev.codingame.easy;

import java.util.*;

class CreateLongestSequence {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			String[] b = in.nextLine().split("0");
			
			int maxOne = 1;
			for (int idx = 0; idx+1 < b.length; idx += 1) {
			    maxOne = Math.max(maxOne, b[idx].length() + b[idx+1].length() + 1);
			}
			
			System.out.println(maxOne);
		}        
    }
}
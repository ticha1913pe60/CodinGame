package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class GhostLegs {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int W = in.nextInt();
			int H = in.nextInt();
			int currColl;
			String letter="";
			String outcome="";
			String[] symbols = new String[H];

			if (in.hasNextLine()) {
			    in.nextLine();
			}
			for (int i = 0; i < H; i++) {
			    symbols[i]=in.nextLine();
			}
			for (int i = 0; i < W; i += 3){
			    currColl = i;
			    letter   = symbols[0].substring(currColl,currColl+1);
			    outcome  = symbols[H-1].substring(currColl,currColl+1);
			    for (int ii = 1; ii < H; ii++){
			        if(currColl < W - 1 && symbols[ii].substring(currColl+1,currColl+2).equals("-")){
			            currColl+=3;
			        }
			        else if(currColl > 0 && symbols[ii].substring(currColl-2,currColl-1).equals("-")){
			            currColl-=3;
			        }
			        outcome=symbols[H-1].substring(currColl,currColl+1);
			    }
			    System.out.println(letter+outcome);
			}
		}
    }
}
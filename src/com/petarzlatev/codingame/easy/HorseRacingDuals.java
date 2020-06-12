package com.petarzlatev.codingame.easy;

import java.util.Arrays;
import java.util.Scanner;

class HorseRacingDuals {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();
			int [] strength= new int[N];
			int answer=0;
			for (int i = 0; i < N; i++) {
			    int pi = in.nextInt();
			    strength[i]=pi;
			}
			Arrays.sort(strength);
			for (int i = 0; i < N; i++) {
			    if(i==1 || (i>1 && (strength[i]-strength[i-1])<answer)){
			        answer = strength[i]-strength[i-1];
			    }
			}
			System.out.println(answer);
		}
    }
}
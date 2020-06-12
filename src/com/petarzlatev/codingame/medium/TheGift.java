package com.petarzlatev.codingame.medium;

import java.util.Arrays;
import java.util.Scanner;

class TheGift {
    public static void printResult(int [] amnPayed){
        for (int i = 0; i < amnPayed.length; i++) {
            System.out.println(amnPayed[i]);
        }
    }
    
    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();
			int C = in.nextInt();
			int wholeB = 0;
			int avg = C/N;
			int nCountPayed=0;
			int [] budget = new int [N];
			int [] amnPayed = new int [N];
			Boolean bContinue = true;
			for (int i = 0; i < budget.length; i++) {
			    int B = in.nextInt();
			    wholeB+=B;
			    budget[i]=B;
			}
			if(wholeB<C){
			    System.out.println("IMPOSSIBLE");
			}
			else{
			    while(bContinue && N>0){
			        avg = C/N;
			        bContinue=false;
			        for (int i = 0; i < budget.length; i++) {
			            if(budget[i]>-1){                        
			                if(avg>=budget[i]){
			                    amnPayed[nCountPayed]=budget[i];
			                    nCountPayed++;
			                    N--;
			                    C-=budget[i];
			                    budget[i]=-1;
			                    bContinue=true;
			                }
			            }
			        }
			    }
			    if(N>0){
			        avg=C/N;
			        for (int i = 0; i < budget.length; i++) {
			            if(budget[i]>-1){
			                amnPayed[nCountPayed]=(int)avg;
			                nCountPayed++;
			                C-=avg;
			                N--;
			            }
			            if((nCountPayed == budget.length) && i == budget.length - 1 && C!=0){
			                amnPayed[nCountPayed-1] += C;
			            }
			            if(N>0){
			                avg=C/N;
			            }
			        }
			    }
			    Arrays.sort(amnPayed);
			    printResult(amnPayed);
			}
		}
    }
}
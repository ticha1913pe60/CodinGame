package com.petarzlatev.codingame.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UnitFractions {
    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			long n = in.nextInt();
			List<Integer> deliteli = new ArrayList<>();
			
			for(int i=1;i<n;i++){  
			    if(n%i==0){
			        System.out.println("1/"+n+" = 1/"+n*(n+i)/i+" + 1/"+(n+i));
			        deliteli.add(i);
			    }
			    else if(deliteli.size() > 0){
			        for(int ii=1;ii<deliteli.size();ii++){
			            if(i%deliteli.get(ii)==0 && n%(i/deliteli.get(ii))==0 && n%deliteli.get(ii)==0){
			                System.out.println("1/"+n+" = 1/"+n*(n+i)/i+" + 1/"+(n+i));
			                break;
			            }
			        }
			    }
			}
			System.out.println("1/"+n+" = 1/"+(n*2)+" + 1/"+(n*2));
		}
    }
}
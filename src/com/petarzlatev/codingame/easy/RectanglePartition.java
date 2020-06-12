package com.petarzlatev.codingame.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			List <Integer> arrCountX = new ArrayList <>();
			List <Integer> arrCountY = new ArrayList <>();
			List <Integer> arrCountXLines = new ArrayList <>();
			List <Integer> arrCountYLines = new ArrayList <>();
			int nCount=0;
			int w = in.nextInt();
			int h = in.nextInt();
			int countX = in.nextInt();
			int countY = in.nextInt();
			for (int i = 0; i < countX; i++) {
			    int x = in.nextInt();
			    arrCountX.add(x);
			}
			arrCountX.add(w);
			Collections.sort(arrCountX);
			for (int i = 0; i < countY; i++) {
			    int y = in.nextInt();
			    arrCountY.add(y);
			}
			arrCountY.add(h);
			Collections.sort(arrCountY);
			for(int ii=arrCountX.size()-1;ii>=0;ii--){
			    arrCountXLines.add(arrCountX.get(ii));
			    for(int i=0;i<ii;i++){
			        arrCountXLines.add(arrCountX.get(ii)-arrCountX.get(i));
			    }
			}
			Collections.sort(arrCountXLines);
			for(int ii=arrCountY.size()-1;ii>=0;ii--){
			    arrCountYLines.add(arrCountY.get(ii));
			    for(int i=0;i<ii;i++){
			        arrCountYLines.add(arrCountY.get(ii)-arrCountY.get(i));
			    }
			}
			Collections.sort(arrCountYLines);
			for(int i=0;i<arrCountXLines.size();i++){
			    for(int ii=0;ii<arrCountYLines.size();ii++){
			        if(arrCountXLines.get(i).equals(arrCountYLines.get(ii))){
			            nCount++;
			        }
			        else if(arrCountXLines.get(i) < arrCountYLines.get(ii)){
			            break;
			        }
			    }
			}
			System.out.println(nCount);
		}
    }
}
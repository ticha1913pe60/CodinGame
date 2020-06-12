package com.petarzlatev.codingame.medium;

import java.util.Scanner;

class MayanCalculations {
    public static int calcNumber(String num1Line, String[][] alphabet, String[][] indexes, int i, int H  ){
        int number=0;

        if(i%H==0){
            for (int j = 0; j < 20; j++) {
                if(num1Line.equals(alphabet[j][i%H])){
                    indexes[j][0]=j+"";
                    indexes[j][1]="T";
                }
                else{
                    indexes[j][0]=" ";
                    indexes[j][1]="F";
                }
            }
        }
        else{
            for (int j=0; j < 20; j++){
            if((indexes[j][1].equals("T")) && !alphabet[Integer.parseInt(indexes[j][0])][i%H].equals(num1Line)){
                    indexes[j][1]="F";
                }
            }
        }
        
        for (int j=0; j < 20; j++){
            if(indexes[j][1].equals("T")){
                number=Integer.parseInt(indexes[j][0]);
            }
        }

        return number;
    }

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int L = in.nextInt();
			int H = in.nextInt();
			int num1=0, num2=0;
			String[][] alphabet = new String[20][H];
			String[][] indexes = new String[20][2];
			String result="";
			
			for (int i = 0; i < H; i++) {
			    String numeral = in.next();
			    
			    for(int j = 0; j < 20; j++) {
			        alphabet[j][i]=numeral.substring(j*L,(j+1)*L);    
			    }
			}
			int S1 = in.nextInt();
			for (int i = 0; i < S1; i++) {
			    String num1Line = in.next();
			    int numDummy;
			    
			    numDummy=calcNumber(num1Line, alphabet, indexes, i, H);
			    
			    if(H==1 || (i>0 && (i+1)%H==0)){
			        num1+=numDummy*Math.pow(20,Math.floor((S1-i-1)/H));
			    }
			}
			    
			int S2 = in.nextInt();
			for (int i = 0; i < S2; i++) {
			    String num2Line = in.next();
			    int numDummy;

			    numDummy=calcNumber(num2Line, alphabet, indexes, i, H);

			    if(H==1 || (i>0 && (i+1)%H==0)){
			        num2+=numDummy*Math.pow(20,Math.floor((S2-i-1)/H));
			    }
			}
			String operation = in.next();

			if(operation.equals("+")){
			    if((long) num1*num2>Math.pow(2,31)){
			        result=Long.toString( (long) num1+num2,20);    
			    }
			    else{
			        result=Integer.toString( num1+num2,20);    
			    }
			}
			else if(operation.equals("-")){
			    result=Integer.toString( num1-num2,20);    
			}
			else if(operation.equals("*")){
			    if((long) num1*num2>Math.pow(2,31)){
			        result=Long.toString( (long) num1*num2,20);    
			    }
			    else{
			        result=Integer.toString( num1*num2,20);    
			    }
			}
			else if(operation.equals("/")){
			    if(num2>0){
			        result=Integer.toString( num1/num2,20);
			    }
			    else{
			        result="0";
			    }
			}
			String[] arrResult = new String[result.length()];
			arrResult=result.split("");
			for(int i=0; i<arrResult.length; i++){
			    if(arrResult[i].equals("a")){
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[10][j]);       
			        }
			    }
			    else if(arrResult[i].equals("b")){
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[11][j]);       
			        }
			    }
			    else if(arrResult[i].equals("c")){
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[12][j]);       
			        }
			    }
			    else if(arrResult[i].equals("d")){
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[13][j]);       
			        }
			    }
			    else if(arrResult[i].equals("e")){
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[14][j]);       
			        }
			    }
			    else if(arrResult[i].equals("f")){
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[15][j]);       
			        }
			    }
			    else if(arrResult[i].equals("g")){
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[16][j]);       
			        }
			    }
			    else if(arrResult[i].equals("h")){
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[17][j]);       
			        }
			    }
			    else if(arrResult[i].equals("i")){
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[18][j]);       
			        }
			    }
			    else if(arrResult[i].equals("j")){
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[19][j]);       
			        }
			    }
			    else{
			        for(int j=0; j<H; j++){
			            System.out.println(alphabet[Integer.parseInt(arrResult[i])][j]);       
			        }
			    }
			}
		}
    }
}
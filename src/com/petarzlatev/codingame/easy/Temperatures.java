package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class Temperatures {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt(); // the number of temperatures to analyse
			in.nextLine();
			String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
			int result = 0;
			int curTemp = 0;
			String[] temp = temps.split(" ");
			
			for(int ii=0; ii<n; ii++){
			    curTemp=Integer.parseInt(temp[ii]);
			    if(ii==0 || Math.abs(curTemp)<Math.abs(result) || (Math.abs(curTemp)==Math.abs(result) && curTemp>0)){
			        result = curTemp;
			    }
			}
			System.out.println(result);
		}
    }
}
package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class Defibrillators {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			String LON = in.next();
			String LAT = in.next();
			String[] defibs;
			String answer="";
			double distance=0, currDist=0;
			double x;
			double y;
			int N = in.nextInt();
			in.nextLine();
			LON=LON.replace(",",".");
			LAT=LAT.replace(",",".");
			for (int i = 0; i < N; i++) {
			    String DEFIB = in.nextLine();
			    DEFIB=DEFIB.replace(",",".");
			    defibs=DEFIB.split(";");
			    defibs[4]=defibs[4].replace(",",".");
			    defibs[5]=defibs[5].replace(",",".");
			    x=(Float.parseFloat(LON)-Float.parseFloat(defibs[4]))*Math.cos((Double.parseDouble(LAT)+Double.parseDouble(defibs[5]))/2);
			    y=(Float.parseFloat(LAT)-Float.parseFloat(defibs[5]));
			    distance=Math.sqrt((x*x)+(y*y))*6371;
			    if(i==0 || currDist>distance){
			        currDist=distance;
			        answer=defibs[1];
			    }
			}
			System.out.println(answer);
		}
    }
}
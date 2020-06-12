package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class MIMEType {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt(); // Number of elements which make up the association table.
			int Q = in.nextInt(); // Number Q of file names to be analyzed.
			String[] extArray = new String[N];
			String[] mtArray = new String[N];
			String result="";
			int indexOf=0;
			for (int i = 0; i < N; i++) {
			    String EXT = in.next(); // file extension
			    String MT = in.next(); // MIME type.
			    in.nextLine();
			    extArray[i]=EXT.toUpperCase();
			    mtArray[i]=MT;
			}
			for (int i = 0; i < Q; i++) {
			    String FNAME = in.nextLine(); // One file name per line.
			    indexOf=FNAME.lastIndexOf(".");
			    if(indexOf>-1){
			        FNAME=(FNAME.substring(indexOf+1)).toUpperCase();
			    }
			    else{
			        FNAME="";
			    }
			    for (int j = 0; j < N; j++) {
			        if(FNAME.equals(extArray[j])){
			            result=mtArray[j];
			            break;
			        }
			        else{
			            result="UNKNOWN";
			        }
			    }
			    System.out.println(result);
			}
		}
    }
}
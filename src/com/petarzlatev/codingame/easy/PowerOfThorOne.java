package com.petarzlatev.codingame.easy;

import java.util.Scanner;

class PowerOfThorOne {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int lightX = in.nextInt(); // the X position of the light of power
			int lightY = in.nextInt(); // the Y position of the light of power
			int initialTX = in.nextInt(); // Thor's starting X position
			int initialTY = in.nextInt(); // Thor's starting Y position
			String moveDirection;
			// game loop
			while ( true ) {
			    int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
			    moveDirection="";
			    // Write an action using System.out.println()
			    // To debug: System.err.println("Debug messages...");
			    if(lightX>initialTX){
			        if(lightY>initialTY){
			           moveDirection = "SE";
			           initialTX++;
			           initialTY++;
			        }
			        else if(lightY<initialTY){
			           moveDirection = "NE";
			           initialTX++;
			           initialTY--;
			        }
			        else{
			            moveDirection = "E";
			           initialTX++;
			        }
			    }
			    else if((lightX<initialTX)){
			        if(lightY>initialTY){
			           moveDirection = "SW"; 
			           initialTX--;
			           initialTY++;
			        }
			        else if(lightY<initialTY){
			            moveDirection = "NW";
			           initialTX--;
			           initialTY--;
			        }
			        else{
			            moveDirection = "W";
			           initialTX--;
			        }
			    }
			    else{
			        if(lightY>initialTY){
			           moveDirection = "S"; 
			           initialTY++;
			        }
			        else if(lightY<initialTY){
			           moveDirection = "N";
			           initialTY--;
			        }                
			    }
			    remainingTurns--;
			    System.out.println(moveDirection); // A single line providing the move to be made: N NE E SE S SW W or NW
			}
		}
    }
}
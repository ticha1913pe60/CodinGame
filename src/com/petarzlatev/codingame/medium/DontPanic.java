package com.petarzlatev.codingame.medium;

import java.util.Scanner;

class DontPanic {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int nbFloors = in.nextInt(); // number of floors
			int width = in.nextInt(); // width of the area
			int nbRounds = in.nextInt(); // maximum number of rounds
			int exitFloor = in.nextInt(); // floor on which the exit is found
			int exitPos = in.nextInt(); // position of the exit on its floor
			int nbTotalClones = in.nextInt(); // number of generated clones
			int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
			int nbElevators = in.nextInt(); // number of elevators
			int [] elevPos = new int [nbFloors];

			for (int i = 0; i < nbElevators; i++) {
			    int elevatorFloor = in.nextInt(); // floor on which this elevator is found
			    int elevatorPos = in.nextInt(); // position of the elevator on its floor
			    
			    elevPos[elevatorFloor]=elevatorPos;
			}
			while (true) {
			    int cloneFloor = in.nextInt(); // floor of the leading clone
			    int clonePos = in.nextInt(); // position of the leading clone on its floor
			    String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

			    if( (!direction.equals("NONE")) &&
			        ( ( cloneFloor!=exitFloor && clonePos-elevPos[cloneFloor] > 0 && direction.equals("RIGHT") ) ||
			          ( cloneFloor!=exitFloor && clonePos-elevPos[cloneFloor] < 0 && direction.equals("LEFT") ) ||
			          ( cloneFloor==exitFloor && clonePos-exitPos > 1 && direction.equals("RIGHT") ) ||
			          ( cloneFloor==exitFloor && clonePos-exitPos < 1 && direction.equals("LEFT") ) ) ){
			        System.out.println("BLOCK"); // action: WAIT or BLOCK
			    }
			    else{
			        System.out.println("WAIT"); // action: WAIT or BLOCK
			    }
			}
		}
    }
}
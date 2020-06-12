package com.petarzlatev.codingame.easy;

import static java.util.Collections.reverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class EnigmaMachine {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			String operation = in.nextLine();
			int pseudoRandomNumber = in.nextInt();
			int index;
			List<String> rotors = new ArrayList<String>();

			if (in.hasNextLine()) {
				in.nextLine();
			}

			for (int i = 0; i < 3; i++) {
				rotors.add(in.nextLine());
			}

			String message = in.nextLine();

			char[] messageToArray = message.toCharArray();

			char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

			if (operation.equals("ENCODE")) {
				for (int i = 0; i < messageToArray.length; i++) {
					index = Arrays.binarySearch(alphabet, messageToArray[i]);
					messageToArray[i] = alphabet[(index + pseudoRandomNumber + i) % 26];
				}
			}

			if (operation.equals("DECODE")) {
				reverse(rotors);
			}

			for (String rot : rotors) {
				char[] rotor = rot.toCharArray();

				for (int i = 0; i < messageToArray.length; i++) {
					if (operation.equals("ENCODE")) {
						index = Arrays.binarySearch(alphabet, messageToArray[i]);
						messageToArray[i] = rotor[index];
					} else if (operation.equals("DECODE")) {
						index = rot.indexOf(messageToArray[i]);
						messageToArray[i] = alphabet[index];
					}
				}
			}

			if (operation.equals("DECODE")) {
				for (int i = 0; i < messageToArray.length; i++) {
					index = Arrays.binarySearch(alphabet, messageToArray[i]);
					int theIndex = (index - pseudoRandomNumber - i) % 26;
					messageToArray[i] = alphabet[theIndex >= 0 ? theIndex : theIndex + 26];
				}
			}

			System.out.println(String.valueOf(messageToArray));
		}
	}
}
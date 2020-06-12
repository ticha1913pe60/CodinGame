package com.petarzlatev.codingame.easy;

import java.math.BigInteger;
import java.util.Scanner;

class HappyNumbers {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();
			if (in.hasNextLine()) {
			    in.nextLine();
			}
			for (int i = 0; i < N; i++) {
			    String num = in.nextLine();
			    BigInteger result = new BigInteger(num);

			    while (BigInteger.valueOf(1).compareTo(result) != 0 &&
			           BigInteger.valueOf(4).compareTo(result) != 0) {
			        result = isHappyNumber(result);
			    }

			    // Happy number always ends with 1
			    if (BigInteger.valueOf(1).compareTo(result) == 0)
			        System.out.println(num + " :)");
			    // Unhappy number ends in a cycle of repeating numbers which contains 4
			    else if (BigInteger.valueOf(4).compareTo(result) == 0)
			        System.out.println(num + " :(");
			}
		}
    }

    // isHappyNumber() will determine whether a number is happy or not
    public static BigInteger isHappyNumber(BigInteger num) {
        BigInteger rem = new BigInteger("0"), sum = new BigInteger("0");

        // Calculates the sum of squares of digits
        while (BigInteger.ZERO.compareTo(num) < 0 ) {
            rem = num.remainder(new BigInteger("10"));
            sum = sum.add(rem.multiply(rem));
            num = num.divide(new BigInteger("10"));
        }
        return sum;
    }

}
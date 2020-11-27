package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner card = new Scanner(System.in);
        int checkSum = 0;
        boolean everyOther = false;
        long number;

        System.out.print("Please enter a credit card number: ");
        number = card.nextLong();

        String cardNumber = String.valueOf(number);

        if ((cardNumber.length() != 13) && (cardNumber.length() != 15) && (cardNumber.length() != 16)) {
            System.out.println("Credit Card Number: " + number);
            System.out.println("INVALID");
        } else {
            for (int i = cardNumber.length() - 1; i >= 0; i--) {
                int digits = cardNumber.charAt(i) - '0';

                if (everyOther) {
                    digits = digits * 2;
                }
                checkSum += digits / 10;
                checkSum += digits % 10;

                everyOther = !everyOther;
            }
            boolean valid = checkSum % 10 == 0;

            if (!valid) {
                System.out.println("Credit Card Number: " + number);
                System.out.println("INVALID");
            } else if ((cardNumber.startsWith("34") && cardNumber.length() == 15) ||
                    (cardNumber.startsWith("37") && cardNumber.length() == 15)) {
                System.out.println("Credit Card Number: " + number);
                System.out.println("American Express");
            } else if ((cardNumber.startsWith("51") && cardNumber.length() == 16) ||
                    (cardNumber.startsWith("52") && cardNumber.length() == 16) ||
                    (cardNumber.startsWith("53") && cardNumber.length() == 16) ||
                    (cardNumber.startsWith("54") && cardNumber.length() == 16) ||
                    (cardNumber.startsWith("55") && cardNumber.length() == 16)) {
                System.out.println("Credit Card Number: " + number);
                System.out.println("MasterCard");
            } else if ((cardNumber.startsWith("4") && cardNumber.length() == 13) ||
                    (cardNumber.startsWith("4") && cardNumber.length() == 16)) {
                System.out.println("Credit Card Number: " + number);
                System.out.println("VISA");
            } else {
                System.out.println("Credit Card Number: " + number);
                System.out.println("INVALID");
            }
        }

    }
}


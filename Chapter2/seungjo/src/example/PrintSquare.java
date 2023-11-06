package example;

import example.textio.TextIO;

public class PrintSquare {

    public static void main(String[] args) {

        int userInput;
        int square;

        System.out.print("Please type a number: ");
        userInput = TextIO.getInt();
        square = userInput * userInput;

        System.out.println("The number that you entered was " + userInput);
        System.out.println("The square of that number is " + square);
        System.out.println();
    }
}

package Chapter2.damho;

import java.util.Scanner;

public class Exam2_6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String inputString;
        String firstName;
        String lastName;
        int blankIndex;
        int firstNameLength;
        int lastNameLength;
        String initial = "";

        System.out.println("Please enter your first name and last name, separated by a space.");
        inputString = s.nextLine();
        blankIndex = inputString.indexOf(" ");
        firstName = inputString.substring(0, blankIndex);
        lastName = inputString.substring(blankIndex + 1);
        firstNameLength = firstName.length();
        lastNameLength = lastName.length();
        initial += firstName.substring(0, 1).toUpperCase();
        initial += lastName.substring(0, 1).toUpperCase();
        System.out.println("Your first name is " + firstName + ", which has " + firstNameLength + " characters");
        System.out.println("Your last name is " + lastName + ", which has " + lastNameLength + " characters");
        System.out.println("Your initials are " + initial);
        s.close();
    }
}

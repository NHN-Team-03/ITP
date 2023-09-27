package Chapter2.jaehun.exercise;

import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String firstName, lastName;
        int emptyIndex;

        System.out.println("Please enter your first name and last name, separated by a space.");
        System.out.print("? ");
        name = scanner.nextLine();
        emptyIndex = name.indexOf(" ");
        firstName = name.substring(0, emptyIndex);
        lastName = name.substring(emptyIndex+1);

        System.out.println("Your first name is " + firstName + ", witch has " + firstName.length() + " characters");
        System.out.println("Your last name is " + lastName + ", witch has " + lastName.length() + " characters");
        System.out.println("Your initials are " + firstName.charAt(0) + lastName.charAt(0));

        scanner.close();
    }
}

package exercise;

import example.textio.TextIO;
public class Exercise6 {
    public static void main(String[] args) {
        System.out.println("Please enter your first name and last name, separeated by a space.");
        System.out.print("? ");
        String name = TextIO.getln();

        int separeated = name.indexOf(" ");
        String firstName = name.substring(0, separeated);
        String secondName = name.substring(separeated + 1, name.length());
        System.out.println("Your first name is " + firstName + ", which has " + firstName.length() + " characters");
        System.out.println("Your last name is " + secondName + ", which has " + secondName.length() + " charactxers");
        System.out.println("Your initials are " + firstName.substring(0, 1) + secondName.substring(0, 1));
    }
}

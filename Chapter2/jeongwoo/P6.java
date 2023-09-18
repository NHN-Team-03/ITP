package Ch2;

import Ch2.TextIO;

public class P6 {
    public static void main(String[] args) {
        System.out.println("Please enter your first name and last name, separated by a space");
        System.out.print("?");
        String name = TextIO.getln();
        int index = name.indexOf(' ');

        String firstname = name.substring(0, index);
        String lastname = name.substring(index + 1,name.length());
        System.out.println("Your first name is " + firstname + ", which has " + firstname.length() + " characters");
        System.out.println("Your last name is " + lastname + ", which has " + lastname.length() + " characters");
        System.out.println("Your initials are " + firstname.charAt(0) + lastname.charAt(0));

    }
}

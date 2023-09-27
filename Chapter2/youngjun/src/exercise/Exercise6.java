package Chapter2.youngjun;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        System.out.println("Please enter your first name and last name, separated by a space.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int black = name.indexOf(" ");
        String firstname = name.substring(0, black);
        String lastname = name.substring(black+1);
        System.out.println(name);
        System.out.println(firstname + firstname.length());
        System.out.println(lastname + lastname.length());
        System.out.println(firstname.charAt(0) + ""+lastname.charAt(0));
    }
}

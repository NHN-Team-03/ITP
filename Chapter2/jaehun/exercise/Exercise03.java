package Chapter2.jaehun.exercise;

import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;

        
        System.out.print("Enter a name : ");

        name = scanner.nextLine();

        System.out.println("Hello, " + name.toUpperCase());

        scanner.close();

    }
}

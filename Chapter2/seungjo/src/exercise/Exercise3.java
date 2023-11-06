package exercise;

import java.util.Scanner;

public class Exercise3 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("What's your name?: ");
        String name = sc.nextLine();

        System.out.println("Hello, " + name.toUpperCase() + ", nice to meet you!");


    }

}

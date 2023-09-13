package Chapter2.damho;

import java.util.Scanner;

public class Exam2_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("What is your name? ");
        String inputName = s.next();
        String inputNameUpperCase = inputName.toUpperCase();
        System.out.println("Hello, " + inputNameUpperCase + ", nice to meet you!");
        s.close();
    }   
}

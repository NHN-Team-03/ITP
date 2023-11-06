package Chapter2.damho;

import java.util.Scanner;

public class Exam2_4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int quarter;
        int dime;
        int nickel;
        int penny;
        int cent = 0;
        double dollar;

        System.out.print("Enter your number of quarter : ");
        quarter = s.nextInt();
        System.out.print("Enter your number of dime : ");
        dime = s.nextInt();
        System.out.print("Enter your number of nickel : ");
        nickel = s.nextInt();
        System.out.print("Enter your number of penny : ");
        penny = s.nextInt();
        cent += quarter * 25;
        cent += dime * 10;
        cent += nickel * 5;
        cent += penny;
        dollar = (double) cent / 100;
        System.out.println("your change is " + dollar + "dollars");
        s.close();
    }
}

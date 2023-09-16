package example;

import java.util.Scanner;

public class ComputeAverage2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str;
        double number;
        double total;
        double avg;
        int count;
        total = 0;
        count = 0;
        System.out.println("Enter your numbers, press return to end.");

        while (true) {
            System.out.print("? ");
            str = sc.nextLine();
            if (str.equals("")) {
                break;
            }
            try {
                number = Double.parseDouble(str);

                total = total + number;
                count = count + 1;
            } catch (NumberFormatException e) {
                System.out.println("Not a legal number! Try again.");
            }
        }
        avg = total / count;
        System.out.printf("The average of %d numbers is %1.6g%n", count, avg);
    }
}

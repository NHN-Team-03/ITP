import java.util.Scanner;

public class ComputeAverage {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int inputNumber;
        int sum;
        int count;
        double average;

        sum = 0;
        count = 0;

        System.out.println("Enter your first positive integer: ");
        inputNumber = sc.nextInt();

        while (inputNumber != 0) {
            sum += inputNumber;
            count++;
            System.out.println("Enter your next positive integer, or 0 to end: ");
            inputNumber = sc.nextInt();
        }

        if (count == 0) {
            System.out.println("You didn't enter any data!");
        }
        else {
            average = ((double)sum) / count;
            System.out.println();
            System.out.println("You entered " + count + " positive integers.");
            System.out.printf("Their average is %1.3f\n", average);
        }
    }
}

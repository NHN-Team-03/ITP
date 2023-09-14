import java.util.Scanner;

public class Interest3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double principle;
        double rate;

        System.out.print("Enter the initial investment: ");
        principle = sc.nextDouble();

        System.out.println();
        System.out.println("Enter the annual interest rate.");
        System.out.print("Enter a decimal, not a percentage: ");
        rate = sc.nextDouble();

        int years;

        years = 0;
        while(years < 5) {
            double interest;
            interest = principle * rate;
            principle = principle + interest;
            years = years + 1;
            System.out.print("The value of the investment after ");
            System.out.print(years);
            System.out.print(" years is $");
            System.out.printf("%1.2f", principle);
            System.out.println();
        }
    }
}

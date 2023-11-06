package example;

import java.util.Scanner;

public class LengthConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double measurement;
        String units;

        double inches, feet, yards, miles;

        StringBuilder sb = new StringBuilder();
        sb.append("Enter measurements in inches, feet, yards, or miles.")
                .append("\nForexample:  1 inch    17 feet    2.73 miles")
                .append("\nYou can use abbreviations:   in   ft   yd   mi")
                .append("\nI will convert your input into the other units of measure.");
        System.out.println(sb.toString());

        while (true) {
            System.out.print("Enter your measurement, or 0 to end: ");
            measurement = sc.nextDouble();
            if (measurement == 0)
                break;
            sc.nextLine();
            units = sc.nextLine();
            units = units.toLowerCase();

            if (units.equals("inch") || units.equals("incehs") || units.equals("in")) {
                inches = measurement;
            }
            else if (units.equals("foot") || units.equals("feet") || units.equals("ft")) {
                inches = measurement * 12;
            }
            else if (units.equals("mile") || units.equals("miles") || units.equals("mi")) {
                inches = measurement * 12 * 5280;
            }
            else {
                System.out.println("Sorry, but I don't undertand \"" + units + "\".");
                continue;
            }

            feet = inches / 12;
            yards = inches / 36;
            miles = inches / (12 * 5280);

            System.out.println();
            System.out.println("That's equivalent to:");
            System.out.printf("%14.5g inches%n", inches);
            System.out.printf("%14.5g feet%n", feet);
            System.out.printf("%14.5g yards%n", yards);
            System.out.printf("%14.5g miles%n", miles);
            System.out.println();
        }

        System.out.println();
        System.out.println("OK! Bye for now.");
    }
}

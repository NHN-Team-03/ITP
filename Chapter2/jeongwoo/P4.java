package Ch2;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("How many quarter : ");
        int quarter = s.nextInt();
        System.out.print("How many dime : ");
        int dime = s.nextInt();
                System.out.print("How many nickel : ");
        int nickel = s.nextInt();
                System.out.print("How many penny : ");
        int penny = s.nextInt();
        

        
        System.out.println("You can change " + (quarter * 25 + dime * 10 + nickel * 5 + penny) / 100 + "$");

        s.close();
    }
}

package Ch2;

import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("How many have eggs : ");
        int eggs = s.nextInt();

        System.out.println("Your number of eggs is " + eggs/144 +" gross, " + (eggs % 144) / 12 + " dozen, and " + (eggs % 144 % 12));
        s.close();
    }
}

package Ch2;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();

        System.out.println("Hello," + name.toUpperCase()+",nice to meet you!");
        s.close();
    }
}

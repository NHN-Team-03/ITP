package Chapter4.youngjun.src.exercise;

import java.util.Scanner;

/**
 * Exercise1
 */
public class Exercise1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        prinitCapitalized(str);
    }

    private static void prinitCapitalized(String str) {

        for (int j = 0; j < str.length(); j++) {
            if (Character.isLetter(str.charAt(j))) {
                System.out.print(str.charAt(j));
            }
            else if(j < (str.length() - 2)){
                System.out.print(" " + Character.toUpperCase(str.charAt(j+1)));     
                j+=1;
            }
            else {
                System.out.print(str.charAt(j));
            }
        }
    }
}
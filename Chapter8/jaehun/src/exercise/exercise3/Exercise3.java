package exercise.exercise3;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("로마 숫자나 아라비아 숫자를 입력하세요: ");

            String number = scanner.nextLine();

            if (number.equals("")) {
                break;
            }

            try {
                if (Character.isDigit(number.charAt(0))) {
                    System.out.println(new RomanNumeral(Integer.valueOf(number)).toString());
                } else {
                    System.out.println(new RomanNumeral(number).toInt());
                }
            } catch (NumberFormatException exception) {
                System.out.println(exception.getMessage());
            }
        }

        scanner.close();
    }
}

package exercise.exercise3;

import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input;
        while (true) {

            System.out.print("로마 숫자나 정수를 입력하세요: ");
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("종료합니다.");
                break;
            }

            input = input.toUpperCase();
            try {
                if (65 <= input.charAt(0) && input.charAt(0) <= 90) {
                    // 로마 숫자를 입력한 경우
                    RomanNumeralConverter convert = new RomanNumeralConverter(input);
                } else {
                    // 정수를 입력한 경우
                    int number = Integer.parseInt(input);
                    RomanNumeralConverter convert = new RomanNumeralConverter(number);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


        }

    }
}

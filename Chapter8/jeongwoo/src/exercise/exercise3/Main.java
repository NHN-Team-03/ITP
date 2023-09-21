package exercise.exercise3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 아라비아 -> 로마
        System.out.print("아라비아 숫자 입력 > ");
        int inputArabic = scanner.nextInt();
        RomanNumerals romanNumerals1 = new RomanNumerals(inputArabic);
        System.out.println("로마 표기법 : " + romanNumerals1.toString());

        scanner.nextLine(); // 버퍼 비우기

        System.out.print("로마 숫자 입력 > ");
        String inputRoman = scanner.nextLine();
        RomanNumerals romanNumerals2 = new RomanNumerals(inputRoman);
        System.out.println("아라비아 표기법 : " + romanNumerals2.toInt());
        scanner.close();
    }
}

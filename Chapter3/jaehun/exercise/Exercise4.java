package Chapter3.jaehun.exercise;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.print("텍스트를 입력하세요: ");
        input = scanner.nextLine();

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' ') {
                System.out.println();
            }

            if(Character.isLetter(input.charAt(i))) {
                System.out.print(input.charAt(i));
            }
        }

        scanner.close();
    }
}

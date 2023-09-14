package Chapter3.damho;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char ch;

        System.out.print("문장을 입력해주세요 : ");
        String inputString = s.nextLine();
        for (int i = 0; i < inputString.length(); i++) {
            ch = inputString.charAt(i);
            if (ch == ' ') {
                System.out.println();
            } else if (Character.isLetter(ch)) {
                System.out.print(ch);
            }
        }
    }
}

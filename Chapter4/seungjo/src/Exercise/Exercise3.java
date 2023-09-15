package Exercise;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");

        int num = sc.nextInt();
        int totalCount = 0;

        try {
            totalCount = rollDice(num);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println(totalCount + "번 굴려서 같은 수 " + num + "이(가) 나왔습니다.");
    }

    public static int rollDice(int num) {
        if (num < 2 || num > 12) {
            throw new IllegalArgumentException(num + "은 나올 수 없는 수입니다.");
        }
        
        int count = 0;

        while (true) {
            int firstDice = (int)(Math.random() * 6 + 1);
            int secondDice = (int) (Math.random() * 6 + 1);

            if (num == (firstDice + secondDice)) {
                return count;
            }

            count++;
        }
    }
}

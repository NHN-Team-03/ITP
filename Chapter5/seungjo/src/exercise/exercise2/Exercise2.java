package exercise.exercise2;

import java.util.Scanner;

/**
 * 예제 2번 클래스.
 */
public class Exercise2 {

    /**
     * 예제 2번 클래스의 Main Method.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StatCalc calc;
        calc = new StatCalc();

        double num = 0;

        while (true) {
            System.out.print("Enter the number (exit: 0): ");

            num = sc.nextDouble();
            if (num == 0) {
                break;
            }

            calc.enter(num);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Count: " + calc.getCount())
                .append("\nMean: " + calc.getMean())
                .append("\nStandard Deviataion: " + calc.getStandardDeviation())
                .append("\nSum: " + calc.getSum())
                .append("\nMax: " + calc.getMax())
                .append("\nMin: " + calc.getMin());

        System.out.println(sb.toString());
    }
}

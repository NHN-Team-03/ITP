package exercise;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        StatCalc calc = new StatCalc();

        double item = 1;
        while (item != 0) {
            System.out.print("값 입력 : ");
            item = scanner.nextDouble();
            calc.enter(item);
        }

        stringBuilder.append("your data\n");
        stringBuilder.append("Count : " + calc.getCount() + "\n");
        stringBuilder.append("Sum : " + calc.getSum() + "\n");
        stringBuilder.append("Min : " + calc.getMin() + "\n");
        stringBuilder.append("Max : " + calc.getMax() + "\n");
        stringBuilder.append("Avg : " + calc.getMean() + "\n");
        stringBuilder.append("Standard Deviation : " + calc.getStandarDeviation() + "\n");

        System.out.println(stringBuilder);

        scanner.close();
    }
}



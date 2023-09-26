package exercise.exercise2;

import java.util.Scanner;
import java.util.Set;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = null;

        StringBuilder builder = new StringBuilder();
        System.out.println("Input\n--------------------------");
        builder.append("Input\n--------------------------\n");
        while (true) {
            line = scanner.nextLine();
            if (line.equals("x") || line.equals("X")) {
                break;
            }
            Set<Integer> a = null;
            try {
                a = SetCalculator.calc(line);
            } catch (IllegalArgumentException exception) {
                builder.append(line + " : " + exception.getMessage());
                continue;
            }
            builder.append(line + "->");
            builder.append("\t");
            builder.append(a);
            builder.append("\n");
        }

        System.out.println(builder);
        scanner.close();
    }
}

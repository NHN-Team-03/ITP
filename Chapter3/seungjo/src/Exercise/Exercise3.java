package Exercise;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        double num1;
        char op;
        double num2;
        

        while (true) {
            num1 = sc.nextDouble();
            if (num1 == 0) {
                break;
            }
            op = sc.next().charAt(0);
            num2 = sc.nextDouble();

            double result = 0;
            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            System.out.println(result);
        }

        sc.close();

    }
}

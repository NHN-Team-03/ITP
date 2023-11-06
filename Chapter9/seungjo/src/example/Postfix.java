package example;

import java.util.Stack;

public class Postfix {

    private static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                // TODO: 피연산자인 경우 Stack에 push
                stack.push(Integer.parseInt(token));
            } else {
                // TODO: 연산자일 경우 스택에서 피연사자를 pop한 후 해당 연산을 진행
                int firstNumber = stack.pop();
                int secondNumber = stack.pop();
                int result = operation(firstNumber, secondNumber, token);

                System.out.println(result);
                // TODO: 결과를 다시 스택에 push
                stack.push(result);
            }
        }

        // TODO: 마지막에 남은 값이 결과값
        return stack.pop();
    }

    private static int operation(int firstNumber, int secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return  firstNumber / secondNumber;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String expression = "3 4 * 2 5 * +";

        int result = evaluatePostfix(expression);
        System.out.println("Postfix Expression Result: " + result);
    }

}

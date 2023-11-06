package exercise.exercise6;

import java.util.Scanner;

public class Exercise6 {

    abstract private static class ExpNode {
        abstract double value(double xValue);

        abstract void printStackCommands();
    }

    private static class ConstNode extends ExpNode {
        double number;

        ConstNode(double val) {
            number = val;
        }

        double value(double xValue) {
            return number;
        }

        void printStackCommands() {
            System.out.println("  Push " + number);
        }
    }

    private static class BinOpNode extends ExpNode {
        char op;
        ExpNode left;
        ExpNode right;

        BinOpNode(char op, ExpNode left, ExpNode right) {
            if (!(op == '+' || op == '-' || op == '*' || op == '/')) {
                throw new IllegalArgumentException("잘못된 연산자입니다.");
            }
            if (left == null || right == null) {
                throw new IllegalArgumentException("피연산자의 개수가 맞지 않습니다.");
            }

            this.op = op;
            this.left = left;
            this.right = right;
        }

        double value(double xValue) {
            double x = left.value(xValue);
            double y = right.value(xValue);

            switch (op) {
                case '+':
                    return x + y;
                case '-':
                    return x - y;
                case '*':
                    return x * y;
                case '/':
                    if (y == 0) {
                        throw new ArithmeticException("0으로 나눌 수 없습니다.");
                    } else {
                        return x / y;
                    }
                default:
                    return Double.NaN;
            }
        }

        void printStackCommands() {
            left.printStackCommands();
            right.printStackCommands();
            System.out.println("  Operator " + op);
        }
    }

    private static class UnaryMinusNode extends ExpNode {
        ExpNode operand;

        UnaryMinusNode(ExpNode operand) {
            if (operand == null) {
                throw new IllegalArgumentException("값이 존재하지 않습니다.");
            }
            this.operand = operand;
        }

        double value(double xValue) {
            double neg = operand.value(xValue);
            return -neg;
        }

        void printStackCommands() {
            operand.printStackCommands();
            System.out.println("  Unary minus");
        }
    }


    private static class VariableNode extends ExpNode {
        VariableNode() {
        }

        double value(double xValue) {
            return xValue;
        }

        void printStackCommands() {
            System.out.println("  Push X");
        }
    }


    // ---------------------------------------------------------------


    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    }

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        while (true) {
            System.out.println("표현식(expression)을 입력하세요. (종료: 엔터)");

            String expression = sc.nextLine();
            if (expression.isEmpty()) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try {
                expression = expression.trim().replace(" ", "");
                ExpNode exp = expressionTree(expression);

                System.out.println("Value at x = 0 : " + exp.value(0));
                System.out.println("Value at x = 1 : " + exp.value(1));
                System.out.println("Value at x = 2 : " + exp.value(2));
                System.out.println("Value at x = 3 : " + exp.value(3));

                exp.printStackCommands();

            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ParseError e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private static ExpNode expressionTree(String expression) throws ParseError {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("표현식이 존재하지 않습니다.");
        }

        if (expression.charAt(0) == '(') {
            int pos = branketPos(expression);
            return expressionTree(expression.substring(1, pos));
        }

        int opPos = findOperator(expression);
        if (opPos == -1) {
            return buildSimpleExpression(expression);
        }

        char op = expression.charAt(opPos);
        String leftExp = expression.substring(0, opPos);
        String rightExp = expression.substring(opPos + 1);

        return new BinOpNode(op, expressionTree(leftExp), expressionTree(rightExp));
    }

    private static int branketPos(String expression) throws ParseError {
        for (int i = 1; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ')') {
                return i;
            }
        }
        throw new ParseError("괄호가 닫히지 않았습니다.");
    }

    private static ExpNode buildSimpleExpression(String expression) throws ParseError {
        if (expression.equals("x") || expression.equals("X")) {
            return new VariableNode();
        }

        double num = 0;
        if (expression.startsWith("-")) {
            return new UnaryMinusNode(buildSimpleExpression(expression.substring(1)));
        } else {
            try {
                num = Double.parseDouble(expression);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return new ConstNode(num);
    }

    private static int findOperator(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                return i;
            }
        }
        return -1;
    }
}

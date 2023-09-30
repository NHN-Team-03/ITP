package exercise.exercise7;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise7 {

    private static class StandardFunction {
        Functions functionCode;
        StandardFunction(Functions code) {
            this.functionCode = code;
        }

        double evaluate(double x) {
            return switch (functionCode) {
                case SIN -> Math.sin(x);
                case COS -> Math.cos(x);
                case TAN -> Math.tan(x);
                case ABS -> Math.abs(x);
                case SQRT -> Math.sqrt(x);
                default -> Math.log(x);
            };
        }
    }

    private static HashMap<String, Object> symbolTable;

    public static void main(String[] args) {
        symbolTable = new HashMap<>();

        symbolTable.put("sin", new StandardFunction(Functions.SIN));
        symbolTable.put("cos", new StandardFunction(Functions.COS));
        symbolTable.put("tan", new StandardFunction(Functions.TAN));
        symbolTable.put("abs", new StandardFunction(Functions.ABS));
        symbolTable.put("sqrt", new StandardFunction(Functions.SQRT));
        symbolTable.put("log", new StandardFunction(Functions.LOG));

        System.out.println("\n\nEnter commands; press return to end.");
        System.out.println("Commands must have the form:\n");
        System.out.println("      print <expression>");
        System.out.println("  or");
        System.out.println("      let <variable> = <expression>");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("? ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("종료합니다.");
                break;
            }

            try {
                if (input.contains("print")) {
                    doPrintCommand(input.replaceAll("print ", ""));
                } else if (input.contains("let")) {
                    doLetCommand(input.replaceAll("let ", ""));
                } else {
                    throw new ParseError("print, let을 입력해주세요.");
                }
            } catch (ParseError e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
        }
    }

    public static void doLetCommand(String input) throws ParseError {
        input = input.trim();
        input = input.replaceAll(" ", "");
        if (!(input.contains("="))) {
            throw new ParseError("해당 문자열에 '='가 빠졌습니다.");
        }


        String[] tokens = input.split("=");
        if (tokens.length != 2) {
            throw new ParseError("해당 문자열에 '='가 두 개 이상 있습니다.");
        }

        double val = expressionValue(tokens[1]);
        symbolTable.put(tokens[0], val);
    }

    private static void doPrintCommand(String input) throws ParseError {
        // sin(3*x-7) + log(sqrt(y))를 입력했다고 가정해보자
        input = input.trim();
        input = input.replaceAll(" ", "");

        double val = expressionValue(input);

        System.out.println("Value is " + val);

    }

    private static double expressionValue(String expression) throws ParseError {

        boolean negative = false;

        if (expression.charAt(0) == '-') {
            negative = true;
            expression = expression.substring(1);
        }

        // 정규표현식을 사용하여 +, -의 위치 찾기
        Matcher matcher = findOperator("[+-]", expression);

        // TODO: 문자열 내의 연산자 (+ , -)의 위치를 찾고 char op에 저장하기
        StringTokenizer st = new StringTokenizer(expression, "+-");
        double val = termValue(st.nextToken());
        while (matcher.find()) {
            int position = matcher.start();
            char op = expression.charAt(position);
            double nextVal = termValue(st.nextToken());

            switch (op) {
                case '+' -> val += nextVal;
                case '-' -> val -= nextVal;
            }
        }


        return negative ? -val : val;
    }

    private static double termValue(String term) throws ParseError {

        Matcher matcher = findOperator("[*/]", term);

        StringTokenizer st = new StringTokenizer(term, "*/");
        double val = factorValue(st.nextToken());

        while (matcher.find()) {
            int position = matcher.start();
            char op = term.charAt(position);
            double nextVal = factorValue(st.nextToken());

            switch (op) {
                case '*' -> val *= nextVal;
                case '/' -> val /= nextVal;
            }
        }

        return val;
    }

    private static double factorValue(String factor) throws ParseError {

        Matcher matcher = findOperator("^", factor);

        double val = primaryValue(factor);
        if (factor.contains("^")) {
            StringTokenizer st = new StringTokenizer(factor, "^");
            while (matcher.find()) {
                double nextVal = primaryValue(st.nextToken());
                val = Math.pow(val, nextVal);
                if (Double.isNaN(val)) {
                    throw new ParseError("0보다 작은 수의 제곱근은 구할 수 없습니다.");
                }
            }
        }


        return val;
    }

    private static double primaryValue(String primary) throws ParseError {

        // TODO: primary가 숫자인 경우
        if (Character.isDigit(primary.charAt(0))) {
            return Double.parseDouble(primary);
        }

        // TODO: primary가 문자인 경우
        else if (Character.isLetter(primary.charAt(0))) {
            String word;

            // TODO: '('가 온 경우 '('의 위치를 찾고 ')'의 위치를 찾아서 다시 expressionValue로 보내기
            if (primary.contains("(")) {
                int left = primary.indexOf('('); // 첫 번째 '('의 위치를 찾음
                int right = primary.lastIndexOf(')'); // 가장 오른쪽 ')'의 위치를 찾음
                word = primary.substring(0, left); // 외부 함수 이름 추출
                String innerExpression = primary.substring(left + 1, right); // 내부 함수 부분 추출
                double val = expressionValue(innerExpression); // 내부 함수를 계산

                // HashMap에 저장된 함수인지 확인
                if (symbolTable.containsKey(word)) {
                    Object func = symbolTable.get(word);
                    if (func instanceof StandardFunction) {
                        StandardFunction function = (StandardFunction) func;
                        return function.evaluate(val);
                    }
                } else {
                    throw new ParseError("해당 함수가 정의되지 않았습니다.");
                }
            } else {
                // TODO: primary가 변수인 경우
                if (symbolTable.get(primary) != null) {
                    Object val = symbolTable.get(primary);
                    if (val instanceof Double) {
                        return (Double) val;
                    } else {
                        throw new ParseError("해당 문자는 정의되지 않은 변수입니다.");
                    }
                } else {
                    throw new ParseError("해당 문자는 정의되지 않은 변수입니다.");
                }

            }
        } else {
            throw new ParseError("잘못된 입력입니다.");
        }

        return 0;
    }


    private static Matcher findOperator(String match, String term) {
        Pattern pattern = Pattern.compile(match);
        Matcher matcher = pattern.matcher(term);
        return matcher;
    }

}

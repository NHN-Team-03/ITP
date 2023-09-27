package exercise.exercise7;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class StandardFunction {

    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    }

    private static HashMap<String, Double> symbolTable;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer stringTokenizer;
        String input;
        symbolTable = new HashMap<>();

        symbolTable.put("pi", Math.PI);
        symbolTable.put("e", Math.E);

        System.out.println("\n\nEnter commands; press return to end.");
        System.out.println("Commands must have the form:\n");
        System.out.println("      print <expression>");
        System.out.println("  or");
        System.out.println("      let <variable> = <expression>");

        while (true) {
            System.out.print("\n?");
            input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            try {
                stringTokenizer = new StringTokenizer(input);
                String command = stringTokenizer.nextToken();
                if (command.equals("print")) {
                    doPrintCommand(stringTokenizer);
                } else if (command.equals("let")) {
                    doLetCommand(stringTokenizer);
                } else {
                    throw new StandardFunction.ParseError("Command must begin with 'print' or 'let'.");
                }
            } catch (StandardFunction.ParseError e) {
                System.out.println("\n*** Error in input:    " + e.getMessage());
            }
        }

        System.out.println("\n\nDone.");
    }

    private static void doLetCommand(StringTokenizer stringTokenizer) throws ParseError {

        if (!stringTokenizer.hasMoreTokens()) {
            throw new StandardFunction.ParseError("Error Please write <variable> = <expression>");
        }
        String variable = stringTokenizer.nextToken();
        String equalSign = stringTokenizer.nextToken();

        if (!equalSign.equals("=")) {
            throw new StandardFunction.ParseError("Error Please write <variable> = <expression>");
        }

        double value = expressionValue(stringTokenizer);

        symbolTable.put(variable, value);
    }

    private static void doPrintCommand(StringTokenizer stringTokenizer) throws ParseError {
        if (!stringTokenizer.hasMoreTokens()) {
            throw new StandardFunction.ParseError("<expression>");
        }

        double value = expressionValue(stringTokenizer);
        System.out.println("Value is " + value);
    }

    private static double expressionValue(StringTokenizer stringTokenizer) throws ParseError {

        String result = stringTokenizer.nextToken();
        double value;
        value = eachVariableValue(result, stringTokenizer);

        while (stringTokenizer.hasMoreTokens()) {
            String op = stringTokenizer.nextToken();
            switch (op) {
                case "*" -> {
                    value *= eachVariableValue(stringTokenizer.nextToken(), stringTokenizer);
                }
                case "-" -> {
                    value -= eachVariableValue(stringTokenizer.nextToken(), stringTokenizer);
                }
                case "+" -> {
                    value += eachVariableValue(stringTokenizer.nextToken(), stringTokenizer);
                }
                case "/" -> {
                    value /= eachVariableValue(stringTokenizer.nextToken(), stringTokenizer);
                }
                default -> {
                    throw new StandardFunction.ParseError("지원하지 않는 연산자");
                }
            }
        }

        return value;
    }

    private static String[] mathFunction = new String[] {"sin", "cos", "tan", "abs", "sqrt", "log"};

    private static double eachVariableValue(String result, StringTokenizer stringTokenizer) throws ParseError {

        // 음수 체크
        boolean nagative = false;
        if (result.charAt(0) == '-') {
            nagative = true;
            result = result.substring(1, result.length());
        }

        // 수학 함수 체크
        boolean isMathFunction = Arrays.stream(mathFunction).anyMatch(result::contains);
        double value = 0.0;
        if (isMathFunction) {
            try{
                if((result.charAt(3) != '(') || (result.charAt(result.length()-1) != ')')){
                    throw new StandardFunction.ParseError("ex ) sin(value)");
                }
                value = eachVariableValue(result.substring(4,result.length()-1),stringTokenizer);
            }catch (NumberFormatException e){}
            value = value / 180.0 * Math.PI;
            switch (result.substring(0,3)) {
                case "sin" -> value = Math.sin(value);
                case "cos" -> value = Math.cos(value);
                case "tan" -> value = Math.tan(value);
                case "abs" -> value = Math.abs(value);
                case "sqrt" -> value = Math.sqrt(value);
                case "log" -> value = Math.log(value);
            }
        } else {
            String regExp = "^[a-zA-Z가-힣]*$";

            // 변수 체크
            if (result.matches(regExp)) {
                if(!symbolTable.containsKey(result)){
                    throw new StandardFunction.ParseError("선언되지 않는 변수 사 ");
                }
                value = symbolTable.get(result);
            } else {
                value = Double.parseDouble(result);
            }
        }


        return nagative ? value * -1 : value;
    }


}
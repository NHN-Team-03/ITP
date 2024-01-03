package exercise.exercise2;

import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SetCalculator {
    private SetCalculator() {
    }

    static Set<Integer> calc(String inputString) {
        int indexOfOperator;
        char operator;

        indexOfOperator = getIndexOfOperator(inputString);
        if (indexOfOperator == -1) {
            throw new IllegalArgumentException("+, -, * 중 하나의 연산자를 입력해주세요.");
        }

        operator = inputString.charAt(indexOfOperator);

        String left = inputString.substring(0, indexOfOperator);
        String right = inputString.substring(indexOfOperator + 1, inputString.length());

        Set<Integer> a = makeSet(left);
        Set<Integer> b = makeSet(right);

        switch (operator) {
            case '+':
                a.addAll(b);
                break;
            case '-':
                a.removeAll(b);
                break;
            case '*':
                a.retainAll(b);
                break;
            default:
                break;
        }

        return a;
    }

    private static int getIndexOfOperator(String inputString) {
        int indexOfOperator;
        if ((indexOfOperator = inputString.indexOf("+", 0)) != -1) {
            return indexOfOperator;
        }
        if ((indexOfOperator = inputString.indexOf("-", 0)) != -1) {
            return indexOfOperator;
        }
        if ((indexOfOperator = inputString.indexOf("*", 0)) != -1) {
            return indexOfOperator;
        }
        return indexOfOperator;
    }

    private static Set<Integer> makeSet(String inputString) {
        String trimedString = inputString.trim();
        Set<Integer> set = new TreeSet<>();
        if (trimedString.charAt(0) != '[' || trimedString.charAt(trimedString.length() - 1) != ']') {
            throw new IllegalArgumentException("[, ]로 묶어서 입력해주세요.");
        }

        trimedString = trimedString.substring(1, trimedString.length() - 1);
        StringTokenizer token = new StringTokenizer(trimedString, ",");
        while (token.hasMoreTokens()) {
            String target = token.nextToken().trim();
            int n = Integer.parseInt(target, 10);
            set.add(n);
        }

        return set;
    }
}

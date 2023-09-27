package exercise.exercise2;

import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Calculator {
    private TreeSet<Integer> left;
    private TreeSet<Integer> right;
    private TreeSet<Integer> result;
    private String op;

    public Calculator(String answer) {
        if (answer == null) {
            throw new IllegalArgumentException("들어온 입력이 null 입니다.");
        }

        operator(answer);
    }

    private void operator(String answer) {
        if(answer.indexOf("+") >= 0) {
            op = "+";
        } else if(answer.indexOf("-") >= 0) {
            op = "-";
        } else if(answer.indexOf("*") >= 0) {
            op = "*";
        }

        left = setData(answer.substring(0, answer.indexOf(op) - 1));
        right = setData(answer.substring(answer.indexOf(op) + 1, answer.length()));

        result();
    }

    private void result() {
        switch (op) {
            case "+":
                left.addAll(right);
                break;
            case "-":
                left.removeAll(right);
                break;
            case "*":
                left.retainAll(right);
                break;
            default:
                throw new IllegalArgumentException("계산식에 연산자가 존재하지 않습니다.");
        }
    }

    private TreeSet<Integer> setData(String data) {
        TreeSet<Integer> set = new TreeSet<>();
        data = data.substring(data.indexOf("[")+1, data.indexOf("]"));
        StringTokenizer st = new StringTokenizer(data, ",");
        while(st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken().trim()));
        }

        return set;
    }

    private void add(TreeSet<Integer> set, String setData) {
        for(char c : setData.toCharArray()) {
            if(Character.isDigit(c)) {
                set.add(Integer.parseInt(Character.toString(c)));
            }
        }
    }

    public String toString() {
        return left.toString();
    }


}

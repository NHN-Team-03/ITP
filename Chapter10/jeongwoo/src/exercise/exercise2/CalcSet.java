package exercise.exercise2;

import com.sun.source.tree.Tree;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CalcSet {
    TreeSet<Integer> A, B;
    String op;

    public CalcSet(String data) {
        A = new TreeSet<Integer>();
        B = new TreeSet<Integer>();
        initData(data);
    }

    private void initData(String data) {
        StringTokenizer stringTokenizer = new StringTokenizer(data);
        boolean turnTrigger = false;
        String token;
        String regExr = "^[0-9]+$";

        try {
            while (stringTokenizer.hasMoreTokens()) {

                token = stringTokenizer.nextToken();
                if (!token.matches(regExr)) {
                    op = token;
                    turnTrigger = true;
                    continue;
                }

                if (!turnTrigger) {
                    A.add(Integer.parseInt(token));
                    continue;
                }

                B.add(Integer.parseInt(token));
            }
        } catch (NumberFormatException exception) {
            System.out.println("잘못된 값이 포함되어 있습니다.");
        }

    }

    public void printResult() {
        TreeSet<Integer> resultSet = new TreeSet<>(A);
        calc(resultSet);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(A);
        stringBuilder.append(" " + op + " ");
        stringBuilder.append(B);
        stringBuilder.append("         \t" + resultSet);
        System.out.println(stringBuilder);
    }

    private void calc(TreeSet<Integer> resultSet) {
        switch (op) {
            case "+":
                reduce(new Plus(),B, resultSet);
                break;
            case "*":
                reduce(new Muilty(),B, resultSet);
                break;
            case "-":
                reduce(new Minus(),B, resultSet);
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자");
        }
    }

    private void reduce(SetOperator operator, Set<Integer> B, TreeSet<Integer> resultSet){
        operator.apply(B,resultSet);
    }
}

package exercise.exercise2;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("집합을 입력하세요.(종료: Enter)");
            String line = sc.nextLine();

            if (line.isEmpty()) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            StringTokenizer st = new StringTokenizer(line, "+*-");
            int index = line.indexOf("]");
            char operator = line.charAt(index + 2);
            computeSet(st.nextToken(), operator, st.nextToken());
        }
    }

    public static void computeSet(String first, char operator, String second) {
        TreeSet<Integer> firstSet = createSet(first);
        TreeSet<Integer> secondSet = createSet(second);

        switch (operator) {
            case '+':
                firstSet.addAll(secondSet);
                System.out.println(firstSet);
                break;
            case '-':
                firstSet.removeAll(secondSet);
                System.out.println(firstSet);
                break;
            case '*':
                firstSet.retainAll(secondSet);
                System.out.println(firstSet);
                break;
        }
    }

    private static TreeSet<Integer> createSet(String input) {

        TreeSet<Integer> tree = new TreeSet<>();
        input = input.replace("[", "");
        input = input.replace("]", "");
        StringTokenizer st = new StringTokenizer(input, ", ");
        int[] arr = new int[st.countTokens()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            tree.add(arr[i]);
        }

        return tree;
    }


}

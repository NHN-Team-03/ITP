package Chapter10.yongjun.src.exercise.exercise2;

import java.util.Scanner;
import java.util.TreeSet;

public class exercise2 {
    public static void main(String[] args) {

        String first;
        String second;
        String operation;
        Scanner scanner = new Scanner(System.in);
        System.out.println("첫번째 집합 입력");
        first = scanner.nextLine().trim();
        System.out.println("연산자 입력");
        operation = scanner.nextLine().trim();
        System.out.println("두번째 집합 입력");
        second = scanner.nextLine().trim();

        clac(first, second, operation);
    }

    private static void clac(String firstInput, String secondInput, String operation) {
        int[] first = stringToNum(firstInput);
        int[] second = stringToNum(secondInput);

        char oper = operation.charAt(0);
        switch (oper) {
            case '+':
                System.out.println(union(first, second));
                break;
            case '-':
                System.out.println(difference(first, second));
                break;
            case '*':
                System.out.println(intersection(first, second));
                break;
            default:
                throw new IllegalArgumentException("long operatioin");

        }
    }

    private static TreeSet intersection(int[] first, int[] second) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        TreeSet<Integer> diffSet = difference(first,second);
        for (Integer num : first) {
            treeSet.add(num);
        }
        treeSet.removeAll(diffSet);


        return treeSet;
    }

    private static TreeSet<Integer> difference(int[] first, int[] second) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (Integer num : first) {
            treeSet.add(num);
        }
        for (Integer num : second) {

            treeSet.remove(num);

        }
        return treeSet;
    }

    private static TreeSet<Integer> union(int[] first, int[] second) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (Integer num : first) {
            treeSet.add(num);
        }
        for (Integer num : second) {
            treeSet.add(num);
        }
        return treeSet;
    }

    private static int[] stringToNum(String input) {
        String[] splitString = input.split(",");
        int[] number = new int[splitString.length];
        for (int i = 0; i < splitString.length; i++) {
            number[i] = Integer.parseInt(splitString[i].trim());

        }
        return number;
    }
}

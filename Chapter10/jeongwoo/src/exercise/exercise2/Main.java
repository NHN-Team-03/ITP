package exercise.exercise2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calcSetTest();
    }

    private static void calcSetTest() {
        Scanner scanner = new Scanner(System.in);
        List<CalcSet> calcSetList = new LinkedList<>();

        /*
        1 2 3 + 3 5 7
        10 9 8 7 * 2 4 6 8
        5 10 15 20 - 0 10 20
         */

        String input;
        while (true) {
            System.out.println("집합 연산 집합 순으로 입력하세요. ex) 1 2 3 + 3 4 5");
            System.out.print("(종료시 엔터) >> ");
            input = scanner.nextLine();
            if(input.isEmpty()){
                break;
            }
            calcSetList.add(new CalcSet(input));
        }

        System.out.println("종료합니다.\n");
        System.out.println("Input                        \t\tOutput");
        System.out.println("-----------------------------\t\t------------------------");
        for (CalcSet data : calcSetList) {
            data.printResult();
        }

        scanner.close();
    }
}

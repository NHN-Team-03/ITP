package Exercise;

import java.util.Scanner;

public class Exercise8 {

    // TODO: 퀴즈 생성 메서드, 퀴즈 관리 메서드, 퀴즈 채점 메서드
    // int[] 자료형인 전역 변수 3개를 사용하여 배열 참조
    // int[] 변수 = new int[10]
    // 첫 번째 값, 두 번째 값, 사용자의 입력 값

    private static int[] firstNumber = new int[10];
    private static int[] secondNumber = new int[10];
    private static int[] userNumber = new int[10];

    public static void createQuiz() {

        System.out.println("덧셈 퀴즈를 시작합니다.");
        System.out.println("-----------------------\n");

        for (int i = 0; i < 10; i++) {
            administerQuiz(i);
        }
    }

    private static void administerQuiz(int index) {
        Scanner sc = new Scanner(System.in);

        firstNumber[index] = (int) (Math.random() * 100 + 1);
        secondNumber[index] = (int) (Math.random() * 100 + 1);
        System.out.print(firstNumber[index] + " + " + secondNumber[index] + " = ");
        userNumber[index] = sc.nextInt();
    }

    private static void totalQuizScore() {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (firstNumber[i] + secondNumber[i] == userNumber[i]) {
                total += 10;
            }
        }
        System.out.println("당신의 총 점수는 " + total + "점 입니다.");

    }
    public static void main(String[] args) {

        createQuiz();
        totalQuizScore();

    }


}

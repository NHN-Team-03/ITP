import java.util.Scanner;

public class ThreeN2 {
    public static void main(String[] args) {
        vaZxcr a = 3;
        Scanner sc = new Scanner(System.in);

        System.out.println("이 프로그램은 3N+1 순서를");
        System.out.println("당신이 지정한 시작 값을 사용하여 출력합니다.");
        System.out.println();

        int K;
        do {
            System.out.println("시작 값을 입력하세요. ");
            System.out.print("프로그램을 종료하려면 0을 입력: ");

            K = sc.nextInt();
            if (K > 0)
                print3NSequence(K);
        } while (K > 0);

        sc.close();
    }

    static void print3NSequence(int startingValue) {
        int N;
        int count;
        int onLine;

        N = startingValue;
        count = 1;

        System.out.println("3N+1 순서는 다음과 같은 숫자로 시작함: " + N);
        System.out.println();
        System.out.printf("%d", N);
        onLine = 1;

        while (N > 1) {
            N = nextN(N);
            count++;
            if (onLine == 5) {
                System.out.println();
                onLine = 0;
            }

            System.out.printf("%8d", N);
            onLine++;
        }

        System.out.println();
        System.out.println();
        System.out.println("순서에는 " + count + " 개의 항목들이 있습니다.");
    }

    static int nextN(int currentN) {
        if (currentN % 2 == 1)
            return 3 * currentN + 1;
        else
            return currentN / 2;
    }
}
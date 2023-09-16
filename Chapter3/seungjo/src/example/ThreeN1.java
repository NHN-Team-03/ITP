package example;

import java.util.Scanner;

public class ThreeN1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N;
        int counter;

        System.out.print("순서의 시작점: ");
        N = sc.nextInt();
        while(N <= 0) {
            System.out.print("순서의 시작점은 반드시 양수여야 합니다. 다시 입력하세요: ");
            N = sc.nextInt();
        }

        counter = 0;
        while (N != 1) {
            if (N % 2 ==0)
                N = N / 2;
            else
                N = 3 * N + 1;
            System.out.println(N);
            counter = counter + 1;
        }

        System.out.println();
        System.out.print("순서에는 ");
        System.out.print(counter);
        System.out.println(" 개의 항목이 있습니다.");
    }
}

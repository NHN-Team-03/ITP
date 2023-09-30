package Chapter3.jaehun.exercise;

public class Exercise6 {
    public static void main(String[] args) {
        int count, maxCount;
        int max;
        int[] countNumber;

        count = 0;
        maxCount = 0;
        max = 1;
        countNumber = new int[10001];
        for(int i = 1; i < countNumber.length; i++) {
            count = 0;
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    count++;
                }
            }

            countNumber[i] = count;

            if(count >= maxCount) {
                max = i;
                maxCount = count;
            }
        }

        System.out.println("1부터 10000까지의 정수 중에서");
        System.out.println("최대 약수의 수는 " + maxCount + " 입니다.");
        System.out.println("약수가 가장 많은 수는 다음과 같습니다.");

        for(int i = 1; i < countNumber.length; i++) {
            if(countNumber[i] == maxCount) {
                System.out.println(i);
            }
        }
    }
}

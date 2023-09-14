package Chapter3.jaehun.exercise;

public class Exercise2 {
    public static void main(String[] args) {
        int count;
        int previousCount;
        int max;

        previousCount = 0;
        max = 1;
        for(int i = 1; i <= 10000; i++) {
            count = 0;
            for(int j = 1; j < i; j++) {
                if(i % j == 0) {
                    count++;
                }
            }

            if(count >= previousCount) {
                max = i;
                previousCount = count;
            }
        }

        System.out.println(max);
    }
}

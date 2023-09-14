package Chapter3.jaehun.exercise;

public class Exercise2 {
    public static void main(String[] args) {
        int count, previousCount;
        int max;

        count = 0;
        previousCount = 0;
        max = 1;
        for(int i = 1; i <= 10000; i++) {
            for(int j = 1; j < 1; j++) {
                if(i % j == 0) {
                    count++;
                }
            }
        }
    }
}

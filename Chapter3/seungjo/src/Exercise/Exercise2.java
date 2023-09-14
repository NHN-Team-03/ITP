package Exercise;

public class Exercise2 {
    public static void main(String[] args) {
    
        int max = Integer.MIN_VALUE;
        int number = 0;
        for (int i = 2; i <= 10000; i++){
            
            int count = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            
            max = Math.max(max, count);
            if (max == count) {
                number = i;
            }
        }

        System.out.println(number);
        System.out.println(max);
    }
}

package Exercise;

public class Exercise6 {
    public static void main(String[] args) {
    
        int max = Integer.MIN_VALUE;
        int[] number = new int[10001];
        for (int i = 2; i <= 10000; i++){
            
            int count = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            number[i] = count;
            max = Math.max(max, count);
        }

        System.out.println("1과 10000 사이의 정수 중에서,");
        System.out.println("약수의 최대 개수는 " + max);
        System.out.println("이러한 약수의 개수를 가진 숫자들은: ");
        for (int i = 0; i < number.length; i++) {
            if (number[i] == max) {
                System.out.println("    " + i);
            }
        }
    }
}

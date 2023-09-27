package Chapter3.damho;

public class Exercise06 {
    public static void main(String[] args) {
        int[] numberOfDivisor = new int[10001];
        for (int i = 1; i < numberOfDivisor.length; i++) {
            numberOfDivisor[i] = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    numberOfDivisor[i]++;
                }
            }
        }

        int maxCountNumberOfDivisor = numberOfDivisor[1];

        for (int i = 2; i < numberOfDivisor.length; i++) {
            if (maxCountNumberOfDivisor < numberOfDivisor[i]) {
                maxCountNumberOfDivisor = numberOfDivisor[i];
            }
        }
        System.out.println("1과 10000 사이의 정ㅇ수 중에서, ");
        System.out.println("약수의 최대 객수는 " + maxCountNumberOfDivisor);
        System.out.println("이러한 약수의 갯수를 가진 숫자들은:");
        for (int i = 1; i < numberOfDivisor.length; i++) {
            if(numberOfDivisor[i] == maxCountNumberOfDivisor) {
                System.out.println(i);
            }
        }

    }
}

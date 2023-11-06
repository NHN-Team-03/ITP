package Chapter3.damho;

public class Exercise02 {
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

        int maxNumberOfDivisor = 1;
        int maxCountNumberOfDivisor = numberOfDivisor[1];

        for (int i = 2; i < numberOfDivisor.length; i++) {
            if (maxCountNumberOfDivisor < numberOfDivisor[i]) {
                maxCountNumberOfDivisor = numberOfDivisor[i];
                maxNumberOfDivisor = i;
            }
        }
        System.out.println("가장 많은 약수를 가지는 수는 " + maxNumberOfDivisor + " 이고, 약수의 개수는 " + maxCountNumberOfDivisor);
    }
}

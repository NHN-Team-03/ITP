package Chapter4.youngjun.src.exercise;

public class Exercise4 {
    public static void main(String[] args) {
        double[] result = new double[11];
        for (int i = 2; i < 13; i++) {
            for (int j = 0; j < 10000; j++) {
                result[i-2] += (Exercise3.dice(i)/10000.0);
            }
        }

        System.out.println("주사위의 총합       평균 굴림 횟수");
        System.out.println("===========================");
        for (int i = 0; i < result.length; i++) {
            System.out.print(i+2+"              ");
            System.out.println(result[i]);
        }
    }
}

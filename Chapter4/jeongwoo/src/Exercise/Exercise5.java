package Exercise;

public class Exercise5 {

    private static double[] TESE_CASE = { 6.0, 8.0, 4.0, 2.0 };
    private static double TEST_CASE_AVG = 5.0;
    private static double TEST_CASE_MIN = 2.0;
    private static double TEST_CASE_MAX = 8.0;
    private static double TEST_CASE_SUM = 20.0;

    public static void main(String[] args) {
        System.out.println("avg Test : " + (avgValue.apply(TESE_CASE) == TEST_CASE_AVG));
        System.out.println("min Test : " + (minValue.apply(TESE_CASE) == TEST_CASE_MIN));
        System.out.println("max Test : " + (maxValue.apply(TESE_CASE) == TEST_CASE_MAX));
        System.out.println("sum Test : " + (sumValue.apply(TESE_CASE) == TEST_CASE_SUM));

    }

    public static final ArrayProcessor counter(double value) {
        return array -> {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value)
                    count++;
            }
            return count;
        };
    }

    public static final ArrayProcessor maxValue = array -> {
        double max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    };

    public static final ArrayProcessor minValue = array -> {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    };

    public static final ArrayProcessor sumValue = array -> {
        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    };

    public static final ArrayProcessor avgValue = array -> {
        double avg = 0.0;
        for (int i = 0; i < array.length; i++) {
            avg += array[i];
        }
        return avg / (double) array.length;
    };

    public static ArrayProcessor getAvgvalue() {
        return avgValue;
    }
}

interface ArrayProcessor {
    double apply(double[] array);

}
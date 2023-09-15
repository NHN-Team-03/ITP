package Chapter4.damho.src.Exercise;

public class Exercise5 {
    public static final ArrayProcessor maxValue = array -> {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    };

    public static final ArrayProcessor minValue = array -> {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    };

    public static final ArrayProcessor sumOfArray = array -> {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    };

    public static final ArrayProcessor averageOfArray = array -> sumOfArray.apply(array) / array.length;

    public static ArrayProcessor counter(double value) {
        return array -> {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value) {
                    count++;
                }
            }
            return count;
        };
    }

    public static void main(String[] args) {
        double[] firstList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] secondList = { 17.0, 3.14, 17.0, -3.4, 17.0, 42.0, 29.2, 3.14 };

        System.out.println("Sum of first list (should be 55): "
                + sumOfArray.apply(firstList));
        System.out.println("Average of first list (should be 5.5): "
                + averageOfArray.apply(firstList));
        System.out.println("Minimum of second list (should be -3.4): "
                + minValue.apply(secondList));
        System.out.println("Maximum of second list (should be 42.0): "
                + maxValue.apply(secondList));

        System.out.println();

        System.out.println("Count of 17.0 in second list (should be 3): "
                + counter(17.0).apply(secondList));
        System.out.println("Count of 20.0 in second list (should be 0): "
                + counter(20.0).apply(secondList));
        System.out.println("Count of 5.0 in first list (should be 1): "
                + counter(5.0).apply(firstList));
    }
}

interface ArrayProcessor {
    double apply(double[] array);
}
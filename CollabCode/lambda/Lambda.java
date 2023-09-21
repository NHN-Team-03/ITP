package CollabCode.lambda;

public class Lambda {

    public static ArrayProcessor counter(double value) {
        return x -> {
            int count = 0;
            for (double number : x) {
                if (value == number) {
                    count++;
                }
            }
            return count;
        };
    }

    public static ArrayProcessor max = array -> {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
        }
        return max;
    };

    public static ArrayProcessor min = array -> {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i])
                min = array[i];
        }
        return min;
    };

    public static ArrayProcessor sum = array -> {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    };

    public static ArrayProcessor avg = array -> {
        return sum.apply(array) / array.length;
    };

    public static void main(String[] args) {
        double[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };

        System.out.println(counter(5).apply(array));
        
        System.out.println(max.apply(array));
        System.out.println(min.apply(array));
        System.out.println(sum.apply(array));
        System.out.println(avg.apply(array));
    }
}

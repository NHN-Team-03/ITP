package Chapter4.jaehun.src.exercise;

public class Exercise5 {
    public static final ArrayProcessor maxValue = (array) -> {
        double max = array[0];
        for(double val : array) {
            if(max < val) {
                max = val;
            }
        }
        return max;
    };

    public static final ArrayProcessor minValue = (array) -> {
        double min = array[0];
        for(double val : array) {
            if(min > val) {
                min = val;
            }
        }

        return min;
    };

    public static final ArrayProcessor sumValue = (array) -> {
        double sum = 0;
        for(double val : array) {
            sum += val;
        }

        return sum;
    };

    public static final ArrayProcessor avgValue = (array) -> {
        double sum = 0;
        for(double val : array) {
            sum += val;
        }

        return sum / array.length;
    };

    public static ArrayProcessor counter(double value) {
        return (array) -> {
            int count = 0;
            for(double val : array) {
                if(value == val) {
                    count++;
                }
            }

            return count;
        };
    }

    
    public static void main(String[] args) {
    }
}

interface ArrayProcessor {
    double apply(double[] array);
}


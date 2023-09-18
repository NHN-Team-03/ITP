package CollabCode.binaryOperator;

public class Mathx {

    public static double sum(double... numbers) {
        return reduce((x, y) -> x + y, 0, numbers);
    }

    public static double sub(double... numbers) {
        return reduce((x, y) -> x - y, numbers[0], makeArray(numbers));
    }

    public static double mul(double... numbers) {
        return reduce((x, y) -> x * y, 1, numbers);

    }

    public static double div(double... numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
        }
        return reduce((x, y) -> x / y, numbers[0], makeArray(numbers));
    }

    private static double reduce(BinaryOperation binaryOperation, double init, double... numbers) {
        double result = init;
        for (double number : numbers) {
            result = binaryOperation.apply(result, number);
        }

        return result;
    }

    private static double[] makeArray(double... numbers) {
        double[] arr = new double[numbers.length - 1];

        for (int i = 1; i < numbers.length; i++) {
            arr[i - 1] = numbers[i];
        }

        return arr;
    }

}

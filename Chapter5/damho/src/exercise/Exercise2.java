package exercise;

import java.util.Scanner;

public class Exercise2 {
    private static void addDataToStatCalc(StatCalc calc) {
        Scanner s = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        double inputData;

        while (true) {
            System.out.print("double형 데이터를 입력하세요.(종료는 0을 입력해주세요.) : ");
            try {
                inputData = s.nextDouble();
            } catch (NumberFormatException e) {
                System.out.println("double형으로 변환할 수 없는 데이터가 입력되었습니다.\n프로그램을 종료합니다.");
                s.close();
                return;
            }

            if (inputData == 0) {
                break;
            }

            calc.enter(inputData);
        }
        calc.printCalc();
        s.close();
    }

    public static void main(String[] args) {
        StatCalc calc;
        calc = new StatCalc();
        addDataToStatCalc(calc);
    }
}

/**
 * An object of class StatCalc can be used to compute several simple statistics
 * for a set of numbers. Numbers are entered into the dataset using
 * the enter(double) method. Methods are provided to return the following
 * statistics for the set of numbers that have been entered: The number
 * of items, the sum of the items, the average, and the standard deviation
 */

class StatCalc {

    private int count; // Number of numbers that have been entered.
    private double sum; // The sum of all the items that have been entered.
    private double squareSum; // The sum of the squares of all the items.
    private double max = Double.MIN_VALUE;
    private double min = Double.MAX_VALUE;

    /**
     * Add a number to the dataset. The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num) {
        count++;
        sum += num;
        squareSum += num * num;
        if (this.max < num) {
            max = num;
        }
        if (this.min > num) {
            min = num;
        }
    }

    /**
     * Return the number of items that have been entered into the dataset.
     */
    public int getCount() {
        return count;
    }

    /**
     * Return the sum of all the numbers that have been entered.
     */
    public double getSum() {
        return sum;
    }

    /**
     * Return the average of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getMean() {
        return sum / count;
    }

    /**
     * Return the standard deviation of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getStandardDeviation() {
        double mean = getMean();
        return Math.sqrt(squareSum / count - mean * mean);
    }

    public double getMax() {
        return this.max;
    }

    public double getMin() {
        return this.min;
    }

    public void printCalc() {
        StringBuilder builder = new StringBuilder();
        builder.append("Data들의 개수 : " + this.getCount() + "\n"
                + "Data들의 합 : " + this.getSum() + "\n"
                + "Data들 중 최대값 : " + this.getMax() + "\n"
                + "Data들 중 최소값 : " + this.getMin() + "\n"
                + "Data들의 평균 : " + this.getMean() + "\n"
                + "Data들의 표준편차 : " + this.getStandardDeviation() + "\n");
        System.out.println(builder.toString());
    }

} // end class StatCalc
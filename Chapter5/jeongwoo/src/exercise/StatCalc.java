package exercise;

public class StatCalc {
    private int count;
    private double sum;
    private double squareSum;
    private double max = Double.NEGATIVE_INFINITY; // 음의 무한대
    private double min = Double.POSITIVE_INFINITY; // 양의 무한대

    // 항목을 데이터 세트에 추가
    public void enter(double item) {
        count++;
        this.sum += item;
        squareSum += item * item;
        max = max < item ? item : max;
        min = min > item ? item : min;
    }

    // 데이터 세트에 추가된 항목 수
    public int getCount() {
        return this.count;
    }

    // 데이터세트에 추가된 모든 항목의 합계를 반환
    public double getSum() {
        return this.sum;
    }

    // 모든 항목의 평균을 반환하는 함수입니다.
    public double getMean() {
        return sum / count;
    }

    // 항목의 표준편차를 반환하는 함수입니다.
    public double getStandarDeviation() {
        double mean = getMean();
        return Math.sqrt(this.squareSum / this.count - mean * mean);
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return max;
    }
}

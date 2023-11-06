package exercise;

public class StatCalc {

    private int count;
    private double max;
    private double min;
    private double sum;
    private double squareSum;  

    public void enter(double num) {
        if(num > max) {
            max = num;
        }

        if(num < min) {
            min = num;
        }

        count++;
        sum += num;
        squareSum += num*num;
    }

    public int getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getMax() {
        if(this.getCount() == 0) {
            throw new IllegalArgumentException("갯수가 0입니다.");
        }
        return max;
    }

    public double getMin() {
        if(this.getCount() == 0) {
            throw new IllegalArgumentException("갯수가 0입니다.");
        }
        return min;
    }

    public double getMean() {
        if(this.getCount() == 0) {
            throw new IllegalArgumentException("갯수가 0입니다.");
        }
        return sum / count;  
    }

    public double getStandardDeviation() {  
        double mean = getMean();
        return Math.sqrt( squareSum/count - mean*mean );
    }

    public String toString() {
        return "입력 갯수 : " + getCount() + "\nSum : " + getSum() + "\nMean : " + getMean() +
         "\nStandardDeviation : " + getStandardDeviation() + "\nMax : " + getMax() + "\nMin : " + getMin(); 
    }

} 
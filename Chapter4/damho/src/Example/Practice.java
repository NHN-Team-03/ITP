package Chapter4.damho.src.Example;

public class Practice {
    static void print3NSequence(int startingValue) {
        if (startingValue <= 0) {
            throw new IllegalArgumentException("startingValue가 0보다 작거나 같습니다.");
        }
        int count;
        int n = startingValue;

        count = 1;
        System.out.print(n + " ");
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            count++;
            System.out.print(n + " ");
        }
        System.out.println("이 안에는 " + count + "개의 숫자가 있습니다.");
    }

    public static void main(String[] args) {
        print3NSequence(5);
    }
}

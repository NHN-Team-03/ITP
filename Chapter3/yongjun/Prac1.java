package Chapter3.yongjun;

public class Prac1 {
    public static void main(String[] args) {
        int count = 0;
        int snake = 0;
        while (snake != 1) {
            count++;
            if (((int)(Math.random() * 6 + 1) == 1) && ((int) (Math.random() * 6 + 1) == 1)) {
                snake++;
            }
        }
        System.out.println(count);
    }
}

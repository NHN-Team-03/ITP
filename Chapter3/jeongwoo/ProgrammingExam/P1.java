public class P1 {
    public static void main(String[] args) {

        int first = 0;
        int second = 0;
        int count = 0;
        while(first != 1 && second != 1){
            first = (int) (Math.random() * 6 + 1);
            second = (int) (Math.random() * 6 + 1);
            count++;
        }

        System.out.println("주사위 굴린 횟수 : " + count);
    }
}
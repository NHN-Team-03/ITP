package exercise;

public class Exercise7_3 {

    public static void main(String[] args) {

        boolean[] check = new boolean[365];

        int count = 0;
        while(true) {
            int birthday = (int) (Math.random() * 365);
            check[birthday] = true;

            boolean end = false;
            for (int i = 0; i < check.length; i++) {
                if (check[i] == true) {
                    end = true;
                } else {
                    end = false;
                    break;
                }
            }
            count++;

            if (end) {
                break;
            }
        }

        System.out.println(count);
    }

}

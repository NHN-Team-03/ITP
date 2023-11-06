package exercise;

public class Exercise7_2 {
    
    public static void main(String[] args) {
        
        boolean[] check = new boolean[365];

        for (int i = 0; i < check.length; i++) {
            int birthday = (int) (Math.random() * 365);
            check[birthday] = true;
        }

        int count = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i] == true) {
                count++;
            }
        }
        
        System.out.println(365 - count);

    }
}

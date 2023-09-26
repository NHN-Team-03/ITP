package exercise;

public class Exercise7_1 {

    public static void main(String[] args) {
        
        int[] year = new int[365];
        int count = 0;

        while (true) {
            int birthday = (int)(Math.random() * 365);

            year[birthday]++;
            
            if (year[birthday] > 2) {
                break;
            }

            count++;
        }

        System.out.println(count + "번 돌아갔다.");
    }
    
}

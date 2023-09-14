package Exercise;

public class Exercise1 {
    public static void main(String[] args) {
        int dice1 = 0;
        int dice2 = 0;

        int count = 0;
        while (dice1 != 1 || dice2 != 1) {
            dice1 = (int)(Math.random() * 6 + 1);
            dice2 = (int)(Math.random() * 6 + 1);
            count++;
            // System.out.println(dice1 + " " + dice2);
        }
        System.out.println("The number of rolls : " + count);
    }
}

package Chapter3.jaehun.exercise;

public class Exercise1 {
    public static void main(String[] args) {
        int diceNumber1, diceNumber2;
        int count;

        count = 0;
        while(true) {
            diceNumber1 = (int)(Math.random() * 6) + 1;
            diceNumber2 = (int)(Math.random() * 6) + 1;

            if(diceNumber1 == 1 && diceNumber2 == 1) {
                break;
            }

            count++;
        }
        
        System.out.println("주사위를 굴린 횟수 : " + count);
    }
}
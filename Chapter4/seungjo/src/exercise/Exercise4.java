package exercise;

public class Exercise4 {
    public static void main(String[] args) {
        int num = 10000;
        rollDice(num);
    }

    public static void rollDice(int num) {

        int[] dice = new int[13];
        for (int i = 0; i < num; i++) {
            int firstDice = (int) (Math.random() * 6 + 1);
            int secondDice = (int) (Math.random() * 6 + 1);

            int sum = firstDice + secondDice;
            dice[sum]++;
        }

        System.out.println("   주사위 총합         평균 굴림 횟수");
        System.out.println(" --------------     -----------------");
        for (int i = 2; i < dice.length; i++) {
            System.out.println("\t " + i + "\t\t" + ((float)num / (float)dice[i]));
        }

    }

}

package Chapter2.jaehun.exercise;

public class Exercise02 {
    public static void main(String[] args) {
        int firstDice;
        int secondDice;

        firstDice = (int)(Math.random() * 6) + 1;
        secondDice = (int)(Math.random() * 6) + 1;

        System.out.println("The First die comes up " + firstDice);
        System.out.println("The second die comes up " + secondDice);
        System.out.println("Your total roll is " + (firstDice + secondDice));
    }
}

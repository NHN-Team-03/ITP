package exercise;

public class Exercise2 {
    public static void main(String[] args) {
        int first = (int) (Math.random() * 6) + 1;
        int second = (int) (Math.random() * 6) + 1;

        System.out.println("The first die comes up " + first);
        System.out.println("The second die comes up " + second);
        System.out.println("Your total roll is " + (first + second));
    }   
}

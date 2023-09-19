package exercise.exercise1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 ~ 500 까지의 수들");
        System.out.println(makeRandomNumberList(20, 500));
    }

    public static ArrayList<Integer> makeRandomNumberList(int size, int maxValue) {
        if(size > maxValue){
            throw new IllegalArgumentException("Size가 maxValue보다 클수는 없습니다.");
        }

        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < size) {
            int randomNumber = (int) (Math.random() * maxValue) + 1;
            if (numbers.indexOf(randomNumber) == -1) {
                numbers.add(randomNumber);
            }
        }


        return numbers;
    }

}

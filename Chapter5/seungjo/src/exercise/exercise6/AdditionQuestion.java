package exercise.exercise6;

import java.util.Random;

/**
 * 더하기 문제를 출제하는 클래스.
 */
public class AdditionQuestion {

    private Random random = new Random();

    private int firstNumber;
    private int secondNumber; // The numbers in the problem.

    public AdditionQuestion() { // constructor
        firstNumber = random.nextInt(50) + 1;
        secondNumber = random.nextInt(50) + 1;
    }

    public String getQuestion() {
        return "What is " + firstNumber + " + " + secondNumber + " ?";
    }

    public int getCorrectAnswer() {
        return firstNumber + secondNumber;
    }

}

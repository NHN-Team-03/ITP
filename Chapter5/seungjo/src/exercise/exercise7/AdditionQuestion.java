package exercise.exercise7;

import java.util.Random;

/**
 * 더하기 문제를 출제하는 클래스.
 */
public class AdditionQuestion implements IntQuestion {
    private Random random = new Random();
    private int firstNumber;
    private int secondNumber;

    /**
     * 더하기 문제를 출제하는 클래스의 생성자.
     */
    public AdditionQuestion() {
        this.firstNumber = random.nextInt() * 50 + 1;
        this.secondNumber = random.nextInt() * 50 + 1;

    }

    @Override
    public String getQuestion() {
        return "What is " + firstNumber + " + " + secondNumber + " ? ";

    }

    @Override
    public int getCorrectAnswer() {
        return this.firstNumber + this.secondNumber;
    }

}

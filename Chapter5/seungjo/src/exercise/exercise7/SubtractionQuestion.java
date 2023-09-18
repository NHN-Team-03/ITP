package exercise.exercise7;

import java.util.Random;

/**
 * IntQuestion을 상속하는 빼기 문제 클래스.
 */
public class SubtractionQuestion implements IntQuestion {
    private Random random = new Random();
    private int firstNumber;
    private int secondNumber;


    /**
     * 빼기 문제를 생성하는 클래스의 생성자.
     */
    public SubtractionQuestion() {
        this.firstNumber = random.nextInt(50) + 1;
        this.secondNumber = random.nextInt(50) + 1;

        if (secondNumber > firstNumber) {
            int temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }
    }

    @Override
    public String getQuestion() {
        return "What is " + firstNumber + " - " + secondNumber + " ? ";
    }

    @Override
    public int getCorrectAnswer() {
        return this.firstNumber - this.secondNumber;
    }

}

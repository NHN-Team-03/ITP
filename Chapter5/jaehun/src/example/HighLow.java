package example;

import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gamesPlayed = 0;
        int sumOfScores = 0;

        double averageScore;

        boolean playAgain;

        do {
            int scoreThisGame;
            scoreThisGame = play();
            sumOfScores += scoreThisGame;
            gamesPlayed++;
            System.out.print("Play again? ");
            playAgain = scanner.nextBoolean();
        } while (playAgain);

        averageScore = ((double) sumOfScores) / gamesPlayed;
    }

    private static int play() {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        Card currentCard;

        Card nextCard;

        int correctGuesses;

        char guess;

        deck.shuffle();

        correctGuesses = 0;
        currentCard = deck.dealCard();
        System.out.println(currentCard);

        while (true) {
            System.out.println("High? Low?");

            do {
                guess = scanner.nextLine().charAt(0);
                if (guess != 'H' && guess != 'L') {
                    System.out.println("다시 입력해 주새요.");
                }
            } while (guess != 'H' && guess != 'L');

            nextCard = deck.dealCard();
            System.out.println(nextCard);

            if (nextCard.getValue() == currentCard.getValue()) {
                System.out.println("졌습니다.");
                break;
            } else if (nextCard.getValue() > currentCard.getValue()) {
                if (guess == 'H') {
                    System.out.println("예측이 맞았습니다.");
                    correctGuesses++;
                } else {
                    System.out.println("졌습니다.");
                    break;
                }
            } else {
                if (guess == 'L') {
                    System.out.println("예측이 맞았습니다.");
                    correctGuesses++;
                } else {
                    System.out.println("졌습니다.");
                    break;
                }
            }

            currentCard = nextCard;
            System.out.println();
            System.out.println(currentCard);
        }

        System.out.println();
        System.out.println("게임 종료");
        
        return correctGuesses;
    }
}

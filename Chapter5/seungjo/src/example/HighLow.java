package example;

import example.textio.TextIO;

/**
 * 이 프로그램은 사용자가 하이로우(HighLow)라는 간단한 카드 게임을 할 수
 * 있도록 하며, 이는 main() 루틴의 시작에 있는 출력문에 설명되어 있다.
 * 사용자가 여러 번의 게임을 한 뒤에는, 사용자의 평균 점수가
 * 보고될 것이다.
 */
public class HighLow {


    public static void main(String[] args) {

        System.out.println("이 프로그램은 간단한 카드 게임, 하이로우(HighLow)를");
        System.out.println("당신이 할 수 있도록 합니다. 카드는 덱에서 뽑힐 것입니다.");
        System.out.println("다음 카드가 더 높은지(higher) 낮은지(lower)를");
        System.out.println("예상해야 합니다. 게임의 점수는 틀린 예상을 하기");
        System.out.println("전까지 이루어진 정확한 예상의 횟수입니다.");
        System.out.println();

        int gamesPlayed = 0;     // 사용자가 플레이 한 게임의 횟수.
        int sumOfScores = 0;     // 플레이 된 모든 게임의 점수들의 합
        double averageScore;     // 평균 점수, sumOfScores를
        //      gamesPlayed로 나누어 계산.
        boolean playAgain;       // 사용자가 다른 게임을 하길 원하는지
        //   여부에 대한 응답을 기록

        do {
            int scoreThisGame;        // 한 번의 게임에 대한 점수.
            scoreThisGame = play();   // 게임을 실행하고 점수를 얻음.
            sumOfScores += scoreThisGame;
            gamesPlayed++;
            System.out.print("게임을 다시 합니까? ");
            playAgain = TextIO.getlnBoolean();
        } while (playAgain);

        averageScore = ((double)sumOfScores) / gamesPlayed;

        System.out.println();
        System.out.println("당신은 " + gamesPlayed + " 번의 게임을 하였습니다.");
        System.out.printf("당신의 평균 점수는 %1.3f.\n", averageScore);

    }  // main() 종료


    /**
     * 사용자가 하이로우(HighLow) 게임 한 번을 하도록 하며 해당
     * 게임의 득점을 반환한다. 점수는 사용자가 맞게
     * 추측한 횟수를 의미한다.
     */
    private static int play() {

        Deck deck = new Deck();  // 새로운 카드의 덱을 얻고
        //   변수 deck에 이에 대한 참조를 저장한다.

        Card currentCard;  // 사용자가 보는 현재의 카드.

        Card nextCard;   // 덱에 있는 다음 차례의 카드. 사용자는
        //    이것이 현재의 카드보다 높은지 아니면
        //    낮은지를 예측하려 할 것이다.

        int correctGuesses ;  // 사용자가 한 정확한 예측의 횟수.
        //   게임의 끝에 이르면 이는 사용자의
        //   점수가 될 것이다.

        char guess;   // 사용자의 추측. 다음 차례의 카드가 높다면 'H',
        //   다음 차례의 카드가 낮다면 'L'이 된다.

        deck.shuffle();  // 게임을 시작하기 전에 덱을 무작위한 순서로
        //    뒤섞는다.

        correctGuesses = 0;
        currentCard = deck.dealCard();
        System.out.println("첫 번째 카드는 " + currentCard);

        while (true) {  // 사용자의 예측이 틀리면 루프를 종료.

            /* 사용자의 예측 'H' 또는 'L'('h' 또는 'l'도 가능)을 얻는다. */

            System.out.print("다음 차례의 카드는 높을까요 (H) 아니면 낮을까요 (L)?  ");
            do {
                guess = TextIO.getlnChar();
                guess = Character.toUpperCase(guess);
                if (guess != 'H' && guess != 'L')
                    System.out.print("H 또는 L로 대답해주세요:  ");
            } while (guess != 'H' && guess != 'L');

            /* 다음 차례의 카드를 얻어서 사용자에게 보여준다. */

            nextCard = deck.dealCard();
            System.out.println("다음 차례의 카드는 " + nextCard);

            /* 사용자의 예측을 얻는다. */

            if (nextCard.getValue() == currentCard.getValue()) {
                System.out.println("이전의 카드와 그 값이 일치합니다.");
                System.out.println("동률로 게임을 졌습니다. 유감이네요!");
                break;  // 게임 종료.
            }
            else if (nextCard.getValue() > currentCard.getValue()) {
                if (guess == 'H') {
                    System.out.println("예측이 맞았습니다.");
                    correctGuesses++;
                }
                else {
                    System.out.println("예측이 틀렸습니다.");
                    break;  // 게임 종료.
                }
            }
            else {  // nextCard is lower
                if (guess == 'L') {
                    System.out.println("예측이 맞았습니다.");
                    correctGuesses++;
                }
                else {
                    System.out.println("예측이 틀렸습니다.");
                    break;  // 게임 종료.
                }
            }

         /* 루프의 다음 번 반복을 설정하기 위하여, nextCard는
            currentCard가 된다. currentCard는 사용자가 보는 카드가 되어야 하며, 사용자가 예측을 한 후 nextCard는 덱의 다음 카드로 설정될 것이기 때문이다. */

            currentCard = nextCard;
            System.out.println();
            System.out.println("카드는 " + currentCard);

        } // while 루프 종료

        System.out.println();
        System.out.println("게임이 끝났습니다.");
        System.out.println("당신은 " + correctGuesses
                + " 번의 맞는 예측을 하였습니다.");
        System.out.println();

        return correctGuesses;

    }  // play() 종료


} // 클래스 HighLow 종료


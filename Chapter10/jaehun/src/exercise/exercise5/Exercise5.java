package exercise.exercise5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise5 {
    private static class ScoreInfo {
        String lastName;
        String firstName;
        int score;

        ScoreInfo(String lastName, String firstName, int score) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.score = score;
        }

        public String getName() {
            return lastName + " " + firstName;
        }

        public String toString() {
            return "[" + lastName + " " + firstName + "]" + " " + score;
        }
    }

    private static ScoreInfo[] scoreData = new ScoreInfo[] {
            new ScoreInfo("Smith", "John", 70),
            new ScoreInfo("Doe", "Mary", 85),
            new ScoreInfo("Page", "Alice", 82),
            new ScoreInfo("Cooper", "Jill", 97),
            new ScoreInfo("Flintstone", "Fred", 66),
            new ScoreInfo("Rubble", "Barney", 80),
            new ScoreInfo("Smith", "Judy", 48),
            new ScoreInfo("Dean", "James", 90),
            new ScoreInfo("Russ", "Joe", 55),
            new ScoreInfo("Wolfe", "Bill", 73),
            new ScoreInfo("Dart", "Mary", 54),
            new ScoreInfo("Rogers", "Chris", 78),
            new ScoreInfo("Toole", "Pat", 51),
            new ScoreInfo("Khan", "Omar", 93),
            new ScoreInfo("Smith", "Ann", 95)
    };

    public static void main(String[] args) {
        // ScoreData의 학생 수 출력
        long count = Arrays.stream(scoreData)
                .count();

        System.out.println(count);
        System.out.println(scoreData.length);

        // 모든 학생의 평균 점수 출력
        double avg = Arrays.stream(scoreData)
                        .mapToDouble(x -> (double)x.score)
                        .average()
                        .getAsDouble();

        System.out.println(avg);
        
        // A(90점 이상)학점을 받은 학생 출력
        Arrays.stream(scoreData)
                .filter(s -> s.score >= 90)
                .forEach(x -> System.out.println(x));

        // 70점 미만인 학생들을 가지는 list 생성
        List<String> list = Arrays.stream(scoreData)
                .filter(s -> s.score < 70)
                .map(s -> s.getName())
                .collect(Collectors.toList());

        // 출력
        list.stream()
                .forEach(x -> System.out.println(x));

        // firstName 으로 정렬 후 출력
        Arrays.stream(scoreData)
                .sorted((x, y) -> x.firstName.compareTo(y.firstName))
                .forEach(x -> System.out.println(x));

        // lastName 으로 정렬 후 출력
        Arrays.stream(scoreData)
                .sorted((x, y) -> x.lastName.compareTo(y.lastName))
                .forEach(x -> System.out.println(x));

        // score로 정렬 후 출력
        Arrays.stream(scoreData)
                .sorted((x, y) -> x.score - y.score)
                .forEach(x -> System.out.println(x));
    }
}

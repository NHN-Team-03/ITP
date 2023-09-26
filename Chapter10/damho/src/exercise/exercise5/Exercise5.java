package exercise.exercise5;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Exercise5 {
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

    private static void printList(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        long count = Arrays.stream(scoreData).parallel().count();
        System.out.println("count : " + count);

        double average = Arrays.stream(scoreData).parallel()
                .mapToDouble(x -> x.getScore())
                .average()
                .getAsDouble();
        System.out.println("average : " + average);

        long countGradeA = Arrays.stream(scoreData).parallel()
                .filter(x -> x.getScore() >= 90).count();
        System.out.println("A 이상 받은 사람 수 : " + countGradeA);

        List<String> list = Arrays.stream(scoreData).parallel()
                .filter(x -> x.getScore() < 70)
                .map(x -> (x.getFirstName() + " " + x.getLastName()))
                .collect(Collectors.toList());
        printList(list);

        System.out.println("\n성으로 정렬 : ");
        Arrays.stream(scoreData) // sort 할 때 .parallel() 하면 안되는 것 같음.
                .sorted((x, y) -> x.getLastName().compareTo(y.getLastName()))
                .forEach(x -> System.out.printf("%s, %s: %d%n", x.getLastName(),
                        x.getFirstName(), x.getScore()));

        System.out.println("\n점수로 정렬 : ");
        Arrays.stream(scoreData)
        .sorted((x, y) -> x.getScore() - y.getScore())
        .forEach(x -> System.out.printf("%s, %s: %d%n", x.getLastName(), x.getFirstName(), x.getScore()));
    }
}

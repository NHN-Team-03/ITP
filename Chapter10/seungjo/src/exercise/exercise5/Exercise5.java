package exercise.exercise5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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


    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("length: ")
                .append(Arrays.stream(scoreData).count())
                .append("\n");

        double avg = Arrays.stream(scoreData).parallel()
                .mapToInt(ScoreInfo::score)
                .average()
                .getAsDouble();
        sb.append("Average grade: ").append((float) avg).append("\n");

        long aGradeCount = Arrays.stream(scoreData).parallel()
                .filter(s -> s.score() >= 90)
                .count();
        sb.append("A grade student count: ")
                .append(aGradeCount).append("\n");

        List<String> failingStudents =
                Arrays.stream(scoreData)
                        .filter(s -> (s.score() < 70))
                        .map(s -> s.lastName() + s.firstName() + ", ")
                        .collect(Collectors.toList());

        sb.append("Failing Students: ");
        failingStudents.forEach(name -> sb.append(name));
        sb.append("\n\n");

        String sortByLastName = Arrays.stream(scoreData)
                .sorted((s1, s2) -> s1.lastName().compareTo(s2.lastName()))
                .map(s -> s.lastName() + "," +  s.firstName() + ": " + s.score() + "\n")
                .collect(Collectors.joining());

        sb.append("[Sort By Last Name] \n").append(sortByLastName).append("\n\n");

        String sortByScore = Arrays.stream(scoreData)
                .sorted((s1, s2) -> s1.score() - s2.score())
                .map(s -> s.lastName() + "," +  s.firstName() + ": " + s.score() + "\n")
                .collect(Collectors.joining());

        sb.append("[Sort By Score]\n").append(sortByScore);

        System.out.println(sb);

    }

}

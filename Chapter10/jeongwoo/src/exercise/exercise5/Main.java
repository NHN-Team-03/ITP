package exercise.exercise5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    /*
     * 학생 수를 인쇄합니다( scoreData.length를 사용하지 않음 ).
     * 모든 학생의 평균 점수를 출력하세요.
     * A를 받은 학생의 수(90점 이상)를 출력하세요.
     * Collect() 스트림 작업을 사용하여 점수가 70점 미만인 학생의 이름이 포함된 List<String>을 만듭니다 .
     * 이름은 이름 뒤에 성의 형식이어야 합니다.
     * 이전 작업에서 생성된 목록 의 이름을 인쇄합니다.
     * 성순으로 정렬하여 학생의 이름과 점수를 인쇄합니다.
     * 점수순으로 정렬하여 학생의 이름과 점수를 인쇄합니다.
     */

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

    private record ScoreInfo(
            String lastName,
            String firstName,
            int score) {
    };

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        long length = Arrays.stream(scoreData)
                .parallel().count();
        stringBuilder.append("length : " + length + "\n\n");

        double avg = Arrays.stream(scoreData)
                .parallel()
                .mapToInt(s -> s.score)
                .average()
                .getAsDouble();
        stringBuilder.append("avg : " + avg + "\n\n");

        long scoreACount = Arrays.stream(scoreData)
                .parallel()
                .filter(s -> s.score >= 90)
                .count();
        stringBuilder.append("A를 받은 학생 수 : " + scoreACount + "\n\n");

        List<String> underTheC = Arrays.stream(scoreData)
                .parallel()
                .filter(s -> s.score < 70)
                .map(x -> x.lastName + " " + x.firstName + " : " + x.score)
                .collect(Collectors.toList());
        stringBuilder.append("70점 아래 학생 리스트\n");
        for (String person : underTheC) {
            stringBuilder.append(person + "\n");
        }
        stringBuilder.append("\n");

        stringBuilder.append("이름 순 정렬 리스트\n");
        Arrays.stream(scoreData)
                .sorted((o1, o2) -> o1.lastName.compareTo(o2.lastName))
                .forEach(x -> stringBuilder.append(x.lastName + " " + x.firstName + " : " + x.score + "\n"));

        stringBuilder.append("\n");

        stringBuilder.append("성적 순 정렬 리스트\n");
        Arrays.stream(scoreData)
                .sorted((o1, o2) -> o1.score - o2.score)
                .forEach(x -> stringBuilder.append(x.lastName + " " + x.firstName + " : " + x.score + "\n"));

        System.out.println(stringBuilder);
    }
}

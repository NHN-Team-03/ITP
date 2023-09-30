package example;

import java.util.ArrayList;
import java.util.List;

public class StreamAPI {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("durian");

        int lengthSum = 0;
        for (String str : stringList) {
            lengthSum += str.length();
        }
        double average = (double) lengthSum / stringList.size();
        System.out.println("평균 길이: " + average);


        // Stream API를 사용해보자
        int lenSum = stringList.parallelStream()
                .mapToInt(str -> str.length())
                .sum();
        double avg = (double) lenSum / stringList.size();
        System.out.println("[Stream] 평균 길이: " + avg);
    }
}

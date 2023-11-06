package example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("apple", "사과");
        map.put("banana", "바나나");
        map.put("cherry", "체리");
        map.put("durian", "두리안");

        // lambda expression
        System.out.println("[Lambda Expression]");
        map.forEach((key, value) -> {
            System.out.println("[key] " + key + " [value] " + value);
        });


        // Stream API
        System.out.println("\n[Stream API]");
        map.entrySet().stream().forEach(entry -> {
            System.out.println("[key] " + entry.getKey() + " [value] " + entry.getValue());
        });

        // Strema API - 오름차순
        System.out.println("\n[Stream API - 오름차순]");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
            System.out.println("[key] " + entry.getKey() + " [value] " + entry.getValue());
        });

        // Stream API - 내림차순
        System.out.println("\n[Stream API - 내림차순]");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Collections.reverseOrder())).forEach(entry -> {
            System.out.println("[key] " + entry.getKey() + " [value] " + entry.getValue());
        });
    }
}

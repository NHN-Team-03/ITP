package exercise.exercise3;

public class Main {
    public static void main(String[] args) {
        CustomHashMap<String,String> map = new CustomHashMap<>();
        map.put("hi", "hi");
        map.put("hi1", "hi2");
        map.put("hi3", "hi3");
        map.put("hi3", "hi4");
        map.put("hi1", "hi3");

        map.remove("hi1");


    }
}

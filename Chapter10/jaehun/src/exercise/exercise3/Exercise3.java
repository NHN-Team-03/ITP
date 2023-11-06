package exercise.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        HashTable table = new HashTable();

        table.put("1", "1");
        table.put("2", "1");
        table.put("3", "1");
        table.put("4", "1");
        table.put("5", "1");
        table.put("6", "1");
        System.out.println(table.size());
        table.remove("1");
        System.out.println(table.size());
    }
}

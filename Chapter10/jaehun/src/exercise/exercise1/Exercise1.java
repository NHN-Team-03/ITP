package exercise.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("a", "000-0000-0000");
        phoneDirectory.add("b", "111-1111-1111");
        phoneDirectory.add("c", "222-2222-2222");
        phoneDirectory.add("d", "333-3333-3333");
        phoneDirectory.add("e", "444-4444-4444");
        
        phoneDirectory.printDirectory();

        System.out.println(phoneDirectory.get("c"));
    }
}
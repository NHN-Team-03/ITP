package exercise.exercise1;

/**
 * Exercise1
 */
public class Exercise1 {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        
        phoneDirectory.putPhoneEntry("a", "01000000000");
        phoneDirectory.putPhoneEntry("b", "010-1234-5678");
        phoneDirectory.putPhoneEntry("c", "01023456789");
        phoneDirectory.putPhoneEntry("d", "010-3456-7890");
        phoneDirectory.putPhoneEntry("e", "abcde");

        phoneDirectory.printPhoneEntry();
    }
}
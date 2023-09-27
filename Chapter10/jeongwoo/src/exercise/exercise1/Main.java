package exercise.exercise1;

public class Main {
    public static void main(String[] args) {
        phoneDirectoryTest();
    }

    public static void phoneDirectoryTest(){
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.putNumber("용준", "010-7000-0003");
        phoneDirectory.putNumber("승조", "010-0004-0002");
        phoneDirectory.putNumber("담호", "010-0005-0001");
        phoneDirectory.putNumber("재훈", "010-0000-0000");

        phoneDirectory.printPhoneDirectory();
    }
}

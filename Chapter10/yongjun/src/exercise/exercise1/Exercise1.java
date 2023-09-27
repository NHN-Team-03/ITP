package Chapter10.yongjun.src.exercise.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.putNumber("ad", "21313");
        phoneDirectory.putNumber("sd", "435");
        phoneDirectory.putNumber("ht4", "613");
        phoneDirectory.putNumber("rty", "71313");
        phoneDirectory.putNumber("nhgn", "11313");
        System.out.println(phoneDirectory.getNumber("ad"));
        System.out.println(phoneDirectory.getNumber("sd"));
        System.out.println(phoneDirectory.getNumber("ht4"));
        System.out.println(phoneDirectory.getNumber("af"));
    }
}

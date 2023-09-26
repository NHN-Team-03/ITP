package exercise.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        PhoneDirectoryWithTreeMap directory = new PhoneDirectoryWithTreeMap();

        directory.putNumber("승조","010-2717-8134");
        directory.putNumber("정우", "010-1111-2313");
        directory.putNumber( "용준", "010-1235-3431");
        directory.putNumber("담호", "010-4123-3235");
        directory.putNumber("재훈", "010-6456-6546");

        System.out.println("승조의 번호: " + directory.getNumber("승조"));
        System.out.println("정우의 번호: " + directory.getNumber("정우"));
        System.out.println();

        directory.print();

    }

}

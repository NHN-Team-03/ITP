package Ch5.src.test;

public class Test {
    public static void main(String[] args) {
        final Student stu = new Student();
        System.out.println("hello?");
        

        System.out.println(stu.name);
    }
}

class Student {
    public String name;
    public double test1, test2, test3;

    public double getAverage() {
        return (test1 + test2 + test3) / 3;
    }
}
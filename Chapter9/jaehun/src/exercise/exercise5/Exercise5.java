package Chapter9.jaehun.src.exercise.exercise5;

public class Exercise5 {
    public static void main(String[] args) {
        BinarySortTree bst = new BinarySortTree();
        for (int i = 0; i < 1024; i++) {
            bst.insert(((int) (Math.random() * 10000)) + 1);
        }

        bst.printDepth();
    }
}

package exercise.exercise4;

public class Main {
    public static void main(String[] args) {
        binaryTreeTest();
    }

    public static void binaryTreeTest() {
        BinaryTree tree = new BinaryTree();
        tree.put("4");
        tree.put("3");
        tree.put("1");
        tree.put("5");
        tree.put("7");
        tree.put("7");
    }
}

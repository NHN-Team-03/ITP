package exercise.exercise5;

public class Main {
    public static void main(String[] args) {
        SortTreeTest();
    }

    public static void SortTreeTest() {
        SortTree tree = new SortTree();
        tree.put(4.0);
        tree.put(3.0);
        tree.put(1.0);
        tree.put(5.0);
        tree.put(7.0);
        tree.put(6.0);
        System.out.println(tree.maxDepth(tree.getRoot(),0));
        System.out.println(tree.countLeaf(tree.getRoot()));
    }
}


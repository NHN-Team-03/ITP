package exercise.exercise4;

public class exercise4 {
    public static void main(String[] args) {
        IntTreeNode.insertIntNode(4);
        IntTreeNode.insertIntNode(2);
        IntTreeNode.insertIntNode(1);
        IntTreeNode.insertIntNode(3);
        IntTreeNode.insertIntNode(6);
        IntTreeNode.insertIntNode(5);
        IntTreeNode.insertIntNode(7);

        System.out.println("TreeNode 오름차순으로 출력 : ");
        IntTreeNode.printIntTreeNode(IntTreeNode.root);

        System.out.println("\nTreeNode level order로 출력");
        IntTreeNode.printLevelOrder();

    }
}

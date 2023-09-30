package exercise.exercise4;

public class IntTreeNode {
    private IntTreeNode() {
    }

    public static IntNode root = null;

    public static void insertIntNode(int item) {
        if (root == null) {
            root = new IntNode(item);
            return;
        }

        IntNode runner = root;
        while (runner != null) {
            if (runner.item >= item) {
                if (runner.left == null) {
                    runner.left = new IntNode(item);
                    return;
                } else {
                    runner = runner.left;
                }
            } else {
                if (runner.right == null) {
                    runner.right = new IntNode(item);
                    return;
                } else {
                    runner = runner.right;
                }
            }
        }
    }

    public static void printLevelOrder() {
        Queue.enqueue(root);
        IntNode dequeueNode;
        while (!Queue.isEmpty()) {
            dequeueNode = Queue.dequeue();

            System.out.println(dequeueNode.item);

            if (dequeueNode.left != null) {
                Queue.enqueue(dequeueNode.left);
            }
            if (dequeueNode.right != null) {
                Queue.enqueue(dequeueNode.right);
            }
        }

    }

    public static void printIntTreeNode(IntNode root) {
        if (root == null) {
            return;
        }
        IntNode runner = root;
        printIntTreeNode(runner.left);
        System.out.println(root.item);
        printIntTreeNode(runner.right);
    }
}

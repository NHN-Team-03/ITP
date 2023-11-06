package Chapter9.jaehun.src.exercise.exercise4;

public class Tree {
    private TreeNode root;

    public void insert(String item) {
        if (root == null) {
            root = new TreeNode(item);
            return;
        }

        TreeNode runner = root;
        while (runner != null) {
            if (item.compareTo(runner.item) < 0) {
                if (runner.left == null) {
                    runner.left = new TreeNode(item);
                    return;
                } else {
                    runner = runner.left;
                }
            } else {
                if (runner.right == null) {
                    runner.right = new TreeNode(item);
                    return;
                } else {
                    runner = runner.right;
                }
            }
        }
    }

    public void printTree() {
        TreeQueue queue = new TreeQueue();

        queue.enqueue(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            System.out.println(node.item);
            if(node.left != null) {
                queue.enqueue(node.left);
            }
            if(node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }



}

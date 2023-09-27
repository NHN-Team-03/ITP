package Chapter9.jaehun.src.exercise.exercise5;

public class BinarySortTree {
    private class TreeNode {
        int item;
        TreeNode left;
        TreeNode right;

        TreeNode(int item) {
            this.item = item;
        }
    }

    private TreeNode root;
    private int depth;

    public BinarySortTree() {
        this.depth = 0;
    }

    public void insert(int item) {
        TreeNode newNode = new TreeNode(item);
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode runner = root;
        while (runner != null) {
            if (runner.item < newNode.item) {
                if (runner.right == null) {
                    runner.right = newNode;
                    return;
                }

                runner = runner.right;
            } else {
                if (runner.left == null) {
                    runner.left = newNode;
                    return;
                }

                runner = runner.left;
            }
        }
    }

    public void printDepth() {
        int leafs = countLeaf(root);
        int sum = sumDepth(root, depth);
        double avgDepth = (double) sum / leafs;
        int max = maxDepth(root, depth);

        System.out.println("평균 깊이 : " + avgDepth);
        System.out.println("최대 깊이 : " + max);
    }

    private int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return depth;
        }

        int leftDepth = maxDepth(root.left, depth + 1);
        int rightDepth = maxDepth(root.right, depth + 1);

        if (leftDepth < rightDepth) {
            return rightDepth;
        } else {
            return leftDepth;
        }
    }

    private int sumDepth(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return depth;
        }

        return sumDepth(root.left, depth + 1) + sumDepth(root.right, depth + 1);
    }

    private int countLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeaf(root.left) + countLeaf(root.right);
    }

}

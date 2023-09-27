package exercise.exercise5;

public class TreeNode<T extends Comparable<T>> {
    private Node<T> root;

    public TreeNode() {
        this.root = null;
    }

    public Node<T> insertNode(T item) {
        if (this.root == null) {
            this.root = new Node<>(item);
            return root;
        }

        Node<T> runner = root;

        while (true) {
            if (item.compareTo(runner.item) <= 0) {
                if (runner.left == null) {
                    runner.left = new Node<>(item);
                    return root;
                } else {
                    runner = runner.left;
                }
            } else {
                if (runner.right == null) {
                    runner.right = new Node<>(item);
                    return root;
                } else {
                    runner = runner.right;
                }
            }
        }
    }

    public void insertRandomValueNodes(RandomValue<T> random, int n) {
        for (int i = 0; i < n; i++) {
            insertNode(random.apply());
        }
    }

    // numberOfNodes -> countNode 호출
    public int numberOfNodes() {
        return countNode(root);
    }

    private int countNode(Node<T> node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countNode(node.left) + countNode(node.right) + 1;
        }
    }

    //sumOfLeavesDepth -> leavesDepth 호출
    public int sumOfLeavesDepth() {
        return leavesDept(root, 0);
    }

    private int leavesDept(Node<T> node, int depth) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return depth;
        } else {
            return leavesDept(node.left, depth + 1) + leavesDept(node.right, depth + 1);
        }
    }

    //numberOfLeaves -> countLeaves 호출
    public int numberOfLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node<T> node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }

    public int averageOfLeavesDepth() {
        return sumOfLeavesDepth() / numberOfLeaves();
    }

    // maxDepthOfLeaves -> depthOfLeaves 호출
    public int maxDepthOfLeaves() {
        return depthOfLeaves(root, 0);
    }

    private int depthOfLeaves(Node<T> node, int depth) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return depth;
        } else {
            return Math.max(depthOfLeaves(node.left, depth + 1), depthOfLeaves(node.right, depth + 1));
        }
    }

    class Node<E extends Comparable<?>> {
        private E item;
        private Node<E> left;
        private Node<E> right;

        public Node(E item) {
            this.item = item;
            this.left = null;
            this.right = null;
        }

        public Node<E> getLeft() {
            return this.left;
        }

        public Node<E> getRight() {
            return this.right;
        }
    }

}

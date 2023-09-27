package exercise.exercise5;

public class SortTree {
    private Node root;
    private int nodeCount;

    public SortTree() {
        nodeCount = 0;
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void put(double data) {
        if (isEmpty()) {
            root = new Node(data);
            nodeCount++;
            return;
        }

        Node newNode = new Node(data);
        Node node = root;
        while (true) {
            if (data > node.getData()) { // 들어온 데이터가 높을 떄
                if (node.right == null) {
                    node.right = newNode;
                    nodeCount++;
                    return;
                }
                node = node.right;
            } else if (node.getData() > data) { // 들어온 데이터가 적을 때
                if (node.left == null) {
                    node.left = newNode;
                    nodeCount++;
                    return;
                }
                node = node.left;
            } else {
                System.out.println("이미 있는 데이터!");
                return;
            }
        }
    }

    public int countLeaf(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1; // leaf node에 도달 시 출력
        }

        
        return countLeaf(node.left) + countLeaf(node.right);
    }


    public int maxDepth(Node node, int depth) {
        if (node == null) { // null값은 0
            return 0;
        }

        if (node.left == null && node.right == null) {
            return depth; // leaf node에 도달 시 출력
        }

        depth++;
        int leftMax = maxDepth(node.left, depth);
        int rightMax = maxDepth(node.right, depth);

        if (leftMax > rightMax) {
            return leftMax;
        } else {
            return rightMax;
        }

    }

    public boolean isEmpty() {
        if (nodeCount == 0) {
            return true;
        }
        return false;
    }
}

package exercise.exercise5;

import java.util.Random;

public class Exercise5 {

    static class TreeNode {
        int item;
        TreeNode right;
        TreeNode left;

        TreeNode(int item) {
            this.item = item;
            this.left = null;
            this.right = null;
        }
    }


    private static TreeNode root;
    private static int leafCount = 0;
    private static int totalDepth = 0;
    private static int maxDepth = 0;

    private static void treeInsert(int item) {

        if (root == null) {
            root = new TreeNode(item);
        } else {
            treeInsert(root, item);
        }
    }

    private static void treeInsert(TreeNode node, int item) {
        // root > item
        if (node.item > item) {
            if (node.left == null) {
                node.left = new TreeNode(item);
            } else {
                treeInsert(node.left, item);
            }
        }

        // root < item
        else {
            if (node.right == null) {
                node.right = new TreeNode(item);
            } else {
                treeInsert(node.right, item);
            }
        }
    }

    private static void countLeafDepth(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        depth++;

        // 리프노드를 찾았을 경우 leafCount + 1
        if (node.left == null && node.right == null) {
            leafCount++;

            totalDepth += depth;
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }

        // 리프노드가 아닌 경우
        else {
            countLeafDepth(node.left, depth);
            countLeafDepth(node.right, depth);
        }

    }
    public static void main(String[] args) {

        Random random = new Random();

        // TODO: 1023개의 랜덤한 값을 노드에 추가
        for (int i = 0; i < 1023; i++) {
            treeInsert(random.nextInt(2000));
        }

        // TODO: 이진 정렬 트리에서 리프 노드의 평균 깊이와 최대 깊이를 계산
        countLeafDepth(root, 0);

        double averageDepth = ((double) totalDepth) / leafCount;

        System.out.println("리프노드의 총 개수: " + leafCount);
        System.out.println("리프노드의 평균 깊이: " + averageDepth);
        System.out.println("리프노드의 최대 깊이: " + maxDepth);
    }

}

package exercise.exercise4;

public class Exercise4 {
    static class TreeNode {
        String item;
        TreeNode left;
        TreeNode right;

        TreeNode(String item) {
            this.item = item;
            this.left = null;
            this.right = null;
        }
    }

    private static TreeNode root;

    private static TreeNode treeInsert(TreeNode root, String item) {
        item = item.toLowerCase();

        if (root == null) {
            return new TreeNode(item);
        }

        if (item.compareTo(root.item) < 0) {
            root.left = treeInsert(root.left, item);
        } else if (item.compareTo(root.item) > 0) {
            root.right = treeInsert(root.right, item);
        }

        return root;
    }

    private static void treeInsert(String item) {
        root = treeInsert(root, item);
    }


    // 중위순회(inorder)로 출력하면 순서대로 출력이 된다.
    private static void inorderPrint(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderPrint(node.left);
        System.out.println(node.item);
        inorderPrint(node.right);
    }

    public static void main(String[] args) {
        treeInsert("judy");
        treeInsert("bill");
        treeInsert("fred");
        treeInsert("mary");
        treeInsert("dave");
        treeInsert("jane");
        treeInsert("alice");
        treeInsert("joe");
        treeInsert("tom");

        System.out.println("[중위순회로 트리를 출력합니다.]");
        inorderPrint(root);
    }
}

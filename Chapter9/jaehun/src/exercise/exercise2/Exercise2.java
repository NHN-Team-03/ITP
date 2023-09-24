package Chapter9.jaehun.src.exercise.exercise2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exercise2 {
    /**
     * An object of type TreeNode represents one node in a binary tree of strings.
     */
    private static class TreeNode {
        String item; // The data in this node.
        TreeNode left; // Pointer to left subtree.
        TreeNode right; // Pointer to right subtree.

        TreeNode(String str) {
            // Constructor. Make a node containing the specified string.
            // Note that left and right pointers are initially null.
            item = str;
        }
    } // end nested class TreeNode

    private static TreeNode root; // Pointer to the root node in a binary tree.
                                  // This tree is used in this program as a
                                  // binary sort tree. When the tree is empty,
                                  // root is null (as it is initially).

    public static void main(String[] args) {
        File file = new File("Chapter9/jaehun/src/exercise/exercise2/Directory.txt");

        readFile(file);
        treeList(root);

    } // end main()

    private static void readFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            // 단어 저장용 StringBuilder
            StringBuilder sb = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                line = line.toLowerCase();
                for (char indexCharacter : line.toCharArray()) {
                    if (indexCharacter == ' ') {
                        if (!treeContains(root, sb.toString())) {
                            treeInsert(sb.toString());

                        }
                        sb.delete(0, sb.length());
                    }

                    if (Character.isLetter(indexCharacter)) {
                        sb.append(indexCharacter);
                    }
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        System.out.println("File에서 읽어온 단어의 수는 " + countNodes(root) + "개 입니다.");
    }

    /**
     * Add the item to the binary sort tree to which the global variable
     * "root" refers. (Note that root can't be passed as a parameter to
     * this routine because the value of root might change, and a change
     * in the value of a formal parameter does not change the actual parameter.)
     */
    private static void treeInsert(String newItem) {
        if (root == null) {
            // The tree is empty. Set root to point to a new node containing
            // the new item. This becomes the only node in the tree.
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner; // Runs down the tree to find a place for newItem.
        runner = root; // Start at the root.
        while (true) {
            if (newItem.compareTo(runner.item) < 0) {
                // Since the new item is less than the item in runner,
                // it belongs in the left subtree of runner. If there
                // is an open space at runner.left, add a new node there.
                // Otherwise, advance runner down one level to the left.
                if (runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return; // New item has been added to the tree.
                } else
                    runner = runner.left;
            } else {
                // Since the new item is greater than or equal to the item in
                // runner it belongs in the right subtree of runner. If there
                // is an open space at runner.right, add a new node there.
                // Otherwise, advance runner down one level to the right.
                if (runner.right == null) {
                    runner.right = new TreeNode(newItem);
                    return; // New item has been added to the tree.
                } else
                    runner = runner.right;
            }
        } // end while
    } // end treeInsert()

    /**
     * Return true if item is one of the items in the binary
     * sort tree to which root points. Return false if not.
     */
    static boolean treeContains(TreeNode root, String item) {
        if (root == null) {
            // Tree is empty, so it certainly doesn't contain item.
            return false;
        } else if (item.equals(root.item)) {
            // Yes, the item has been found in the root node.
            return true;
        } else if (item.compareTo(root.item) < 0) {
            // If the item occurs, it must be in the left subtree.
            return treeContains(root.left, item);
        } else {
            // If the item occurs, it must be in the right subtree.
            return treeContains(root.right, item);
        }
    } // end treeContains()

    /**
     * Print the items in the tree in inorder, one item to a line.
     * Since the tree is a sort tree, the output will be in increasing order.
     */
    private static void treeList(TreeNode node) {
        if (node != null) {
            treeList(node.left); // Print items in left subtree.
            System.out.println("  " + node.item); // Print item in the node.
            treeList(node.right); // Print items in the right subtree.
        }
    } // end treeList()

    /**
     * Count the nodes in the binary tree.
     * 
     * @param node A pointer to the root of the tree. A null value indicates
     *             an empty tree.
     * @return the number of nodes in the tree to which node points. For an
     *         empty tree, the value is zero.
     */
    private static int countNodes(TreeNode node) {
        if (node == null) {
            // Tree is empty, so it contains no nodes.
            return 0;
        } else {
            // Add up the root node and the nodes in its two subtrees.
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);
            return 1 + leftCount + rightCount;
        }
    } // end countNodes()

} // end class SortTreeDemo

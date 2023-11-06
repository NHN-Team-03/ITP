package exercise.exercise3;

import java.util.Stack;

public class Exercise3 {
    public static void main(String[] args) {
        ListNode root = null;
        root = initRootNode(root);
        printList(root);
        ListNode newRoot = reverList(root);
        printList(newRoot);

    }

    private static ListNode initRootNode(ListNode root) {
        root = insertNode(1, root);
        root = insertNode(2, root);
        root = insertNode(3, root);
        root = insertNode(4, root);
        root = insertNode(5, root);
        root = insertNode(6, root);
        return root;
    }

    private static ListNode reverList(ListNode root) {
        if (root == null) {
            throw new IllegalArgumentException("root가 null입니다.");
        }

        ListNode newRoot = copyList(root);
        ListNode runner = newRoot;

        Stack<ListNode> stack = new Stack<>();
        while (runner != null) {
            stack.push(runner);
            runner = runner.next;
        }
        ListNode previous = stack.pop();
        ListNode next = previous;
        newRoot = previous;
        while (!stack.empty()) {
            next = stack.pop();
            previous.next = next;
            previous = next;
        }
        next.next = null;
        return newRoot;

    }

    private static ListNode copyList(ListNode root) {
        ListNode newRoot = null;
        ListNode runner = root;
        while (runner != null) {
            newRoot = insertNode(runner.item, newRoot);
            runner = runner.next;
        }

        return newRoot;
    }

    private static ListNode insertNode(int item, ListNode root) {
        if (root == null) {
            root = new ListNode(item);
        } else {
            ListNode runner = root;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = new ListNode(item);
        }
        return root;
    }

    private static void printList(ListNode root) {
        if (root == null) {
            System.out.println("root가 null입니다.");
            return;
        }
        ListNode runner = root;
        StringBuilder builder = new StringBuilder();
        while (runner != null) {
            if (runner.next == null) {
                builder.append(runner.item);
            } else {
                builder.append(runner.item + " -> ");
            }
            runner = runner.next;
        }
        System.out.println(builder);
    }

    static class ListNode {
        int item;
        ListNode next;

        public ListNode(int item) {
            this.item = item;
            next = null;
        }
    }
}

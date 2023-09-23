package exercise.exercise3;


class ListNode {
    int item;
    ListNode next;
}

public class Exercise3 {

    private static ListNode head;

    public static void insertNode(int item) {
        ListNode newNode = new ListNode();
        newNode.item = item;
        newNode.next = head;
        head = newNode;
    }

    public static void printNode(ListNode node) {
        if (node != null) {
            System.out.print(node.item + " -> ");
            printNode(node.next);
        } else {
            System.out.println("null");
        }
    }

    public static ListNode reverse(ListNode node) {

        ListNode reversedNode = null;
        ListNode originalNode = node;

        while (originalNode != null) {
            ListNode newNode = new ListNode();
            newNode.item = originalNode.item;
            ;
            newNode.next = reversedNode;

            reversedNode = newNode;
            originalNode = originalNode.next;
        }

        return reversedNode;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            insertNode(i + 1);
        }

        System.out.println("[List Node]");
        printNode(head);

        ListNode reversedNode = reverse(head);
        System.out.println("\n[Reversed List Node]");
        printNode(reversedNode);
    }

}

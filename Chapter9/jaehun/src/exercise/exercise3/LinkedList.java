package Chapter9.jaehun.src.exercise.exercise3;

public class LinkedList {
    class ListNode {
        int item;
        ListNode next;

        ListNode(int item) {
            this.item = item;
        }
    }

    private ListNode head;

    private LinkedList reverseList;

    public ListNode getHead() {
        return head;
    };

    public void add(int item) {
        ListNode newNode = new ListNode(item);

        if (head == null) {
            head = newNode;
        } else {
            ListNode runner = head;
            while (runner != null) {
                if (runner.next == null) {
                    runner.next = newNode;
                    break;
                }

                runner = runner.next;
            }
        }
    }

    public void printList() {
        ListNode runner = head;
        if (runner == null) {
            throw new IllegalStateException("리스트에 요소가 존재하지 않습니다.");
        }
        while (runner != null) {
            System.out.print(runner.item + " ");
            runner = runner.next;
        }
        System.out.println();
    }

    public LinkedList reverse(ListNode node) {
        if(reverseList == null) {
            reverseList = new LinkedList();
        }

        if (node == null) {
            return reverseList;
        }

        reverse(node.next);
        reverseList.add(node.item);
        return reverseList;
    }
}

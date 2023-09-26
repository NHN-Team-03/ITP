package exercise.exercise4;

public class Queue {
    public static Node head = null;
    public static Node tail = null;

    private Queue() {
    }

    public static void enqueue(IntNode item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static IntNode dequeue() {
        if (head == null) {
            throw new IllegalArgumentException("Queue가 비어있는 경우 dequeue 연산을 할 수 없습니다.");
        }
        IntNode newNode = head.item;
        head = head.next;
        return newNode;
    }

    public static boolean isEmpty() {
        return head == null;
    }

    static class Node {
        IntNode item;
        Node next;

        public Node(IntNode item) {
            this.item = item;
            next = null;
        }
    }
}

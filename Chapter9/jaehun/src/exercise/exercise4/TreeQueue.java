package Chapter9.jaehun.src.exercise.exercise4;

public class TreeQueue {
    private TreeNode head;
    private TreeNode tail;

    public void enqueue(TreeNode node) {
        if(head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }

    public TreeNode dequeue() {
        if(head == null) {
            throw new IllegalStateException("큐에 요소가 존재하지 않습니다.");
        }

        TreeNode node = head;
        head = head.next;

        if(head == null) {
            tail = null;
        }

        return node;
    }

    public boolean isEmpty() {
        return (head == null);
    }
}

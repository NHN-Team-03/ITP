class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    // 리스트의 맨 끝에 새로운 노드를 추가하는 메서드
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // 리스트의 맨 앞에 새로운 노드를 추가하는 메서드
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    // 리스트에서 주어진 데이터와 일치하는 첫 번째 노드를 삭제하는 메서드
    public void delete(int data) {
        if (head == null) {
            return; // 빈 리스트인 경우 삭제할 것이 없음
        }

        if (head.data == data) {
            head = head.next; // 맨 앞 노드를 삭제
            if (head == null) {
                tail = null; // 리스트에 노드가 하나였고 삭제한 경우 tail도 null로 설정
            }
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next; // 일치하는 노드 삭제
            if (current.next == null) {
                tail = current; // 삭제한 노드가 맨 끝 노드였을 경우 tail 업데이트
            }
        }
    }

    // 리스트를 순회하며 노드의 데이터를 출력하는 메서드
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // 연결 리스트에 데이터 추가
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        // 연결 리스트 출력
        System.out.print("Linked List: ");
        linkedList.display();

        // 데이터 삭제
        linkedList.delete(20);

        // 삭제 후 연결 리스트 출력
        System.out.print("Linked List after deletion: ");
        linkedList.display();
    }
}

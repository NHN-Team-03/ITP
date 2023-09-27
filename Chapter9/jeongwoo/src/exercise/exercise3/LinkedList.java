package exercise.exercise3;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        size = 0;
        init();
    }

    private boolean isListEmpty() {
        if (size <= 0) {
            return true;
        }
        return false;
    }

    private void init() {
        // head, tail Node 생성
        head = new Node("Head");
        tail = new Node("Tail");
        head.leftNode = tail;
        head.rightNode = tail;
        tail.leftNode = head;
        tail.rightNode = head;
    }

    public void addFirstData(Node newNode) {
        head.rightNode = newNode;
        newNode.leftNode = head;

        tail.leftNode = newNode;
        newNode.rightNode = tail;
    }


    // firstadd
    public void addFirstNode(String data) {
        Node newNode = new Node(data); // 새로운 노드 생성
        if (isListEmpty()) {
            addFirstData(newNode);
        } else {
            newNode.rightNode = head.rightNode;
            head.rightNode.leftNode = newNode;
            newNode.leftNode = head;

            head.rightNode = newNode;
        }
        size++;
    }

    // lastadd
    public void addLastNode(String data) {
        Node newNode = new Node(data);
        if (isListEmpty()) {
            addFirstData(newNode);
        } else {
            newNode.leftNode = tail.leftNode;
            tail.leftNode.rightNode = newNode;
            newNode.rightNode = tail;

            tail.leftNode = newNode;
        }
        size++;
    }

    // removefirst
    public void removeFirstNode() {
        if (isListEmpty()) {
            throw new NullPointerException("없는 데이터에 접근하려고 하지 마십시오.");
        }
        Node removeNode = head.rightNode;

        head.rightNode = removeNode.rightNode;
        removeNode.rightNode.leftNode = head;

        removeNode = null;
        size--;
    }

    // removelast
    public void removeLastNode() {
        if (isListEmpty()) {
            throw new NullPointerException("없는 데이터에 접근하려고 하지 마십시오.");
        }

        Node removeNode = tail.leftNode;
        tail.leftNode = removeNode.leftNode;
        removeNode.leftNode.rightNode = tail;

        removeNode = null;
        size--;
    }


    // 오른쪽으로 순으로 출력
    public void printNode() {
        if (isListEmpty()) {
            throw new NullPointerException("아무 것도 존재하지 않습니다.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        Node newNode = head.rightNode;
        do {
            stringBuilder.append(newNode.getData() + " ");
        } while (!(newNode = newNode.rightNode).equals(tail));
        System.out.println(stringBuilder);
    }

    public void reversePrintNode() {
        if (isListEmpty()) {
            throw new NullPointerException("아무 것도 존재하지 않습니다.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        Node newNode = tail.leftNode;

        do {
            stringBuilder.append(newNode.getData() + " ");
        } while (!(newNode = newNode.leftNode).equals(head));

        System.out.println(stringBuilder);
    }
}

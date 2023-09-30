package exercise.exercise3;

public class Main {
    public static void main(String[] args) {
        LinkedListTest();
    }

    private static void LinkedListTest() {

        LinkedList linkedList = new LinkedList();

        linkedList.addLastNode("1"); // 1
        linkedList.addLastNode("2"); // 1 2
        linkedList.addLastNode("3"); // 1 2 3
        linkedList.addLastNode("4"); // 1 2 3 4
        linkedList.addLastNode("5"); // 1 2 3 4 5
        linkedList.addLastNode("6"); // 1 2 3 4 5 6
        linkedList.addLastNode("7"); // 1 2 3 4 5 6 7
        linkedList.addLastNode("8"); // 1 2 3 4 5 6 7 8
        linkedList.addFirstNode("0");// 0 1 2 3 4 5 6 7 8

        linkedList.printNode();
        linkedList.reversePrintNode();

        linkedList.removeFirstNode();   // 1 2 3 4 5 6 7 8
        linkedList.removeLastNode();    // 1 2 3 4 5 6 7
        linkedList.removeLastNode();    // 1 2 3 4 5 6
        linkedList.removeLastNode();    // 1 2 3 4 5
        linkedList.removeFirstNode();   // 2 3 4 5
        linkedList.printNode();
        linkedList.reversePrintNode();

        linkedList.removeLastNode();    // 2 3 4
        linkedList.removeLastNode();    // 2 3
        linkedList.removeLastNode();    // 2
        linkedList.removeLastNode();    // null
        //linkedList.removeLastNode();    // 없는 데이터에 접근하려고 하지 마십시오.
        //linkedList.printNode();         // 아무 것도 존재 x
    }
}

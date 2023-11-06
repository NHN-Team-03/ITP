package Chapter9.jaehun.src.exercise.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        LinkedList originalList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            originalList.add(i);
        }

        originalList.printList();

        LinkedList reverseList = originalList.reverse(originalList.getHead());

        reverseList.printList();
    }

}
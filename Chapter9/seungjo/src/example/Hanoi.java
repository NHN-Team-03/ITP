package example;

public class Hanoi {

    public static void towersOfHanoi(int disks, int from, int to, int spare) {
        if (disks == 1) {
            System.out.println("Move disk 1 from stack " + from + " to stack " + to + ".");
        } else {
            towersOfHanoi(disks - 1, from, spare, to);
            System.out.println("Move disk " + disks + " from stack " + from + " to stack " + to + ".");
            towersOfHanoi(disks - 1, spare, to, from);
        }
    }

    public static void main(String[] args) {
        int numberOfDisks = 3; // 이동할 디스크의 개수
        int sourceStack = 0;  // 디스크가 있는 출발 스택 (0, 1, 2 중 하나)
        int targetStack = 2;  // 디스크를 이동할 목표 스택 (0, 1, 2 중 하나)
        int spareStack = 1;   // 여분의 스택 (0, 1, 2 중 하나)

        System.out.println("Tower of Hanoi Solution:");
        towersOfHanoi(numberOfDisks, sourceStack, targetStack, spareStack);
    }

}

package Chapter9.jaehun.src.example;

public class TowersOfHanoi {
    public static void main(String[] args) {
        towersOfHanoi(4, 0, 1, 2);
    }

    public static void towersOfHanoi(int disk, int from, int to, int spare) {
        if(disk == 1) {
            System.out.printf("Move disk 1 from stack %d to stack %d%n", from, to);
            return;
        }

        towersOfHanoi((disk-1), from, spare, to);
        System.out.printf("Move disk %d from stack %d to stack %d\n", disk, from, to);
        towersOfHanoi((disk-1), spare, to, from);
    }
}

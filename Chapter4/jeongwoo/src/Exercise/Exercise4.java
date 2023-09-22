package exercise;

public class Exercise4 {
    public static void main(String[] args) {
        avgDiceCount();
    }

    public static void avgDiceCount() {
        StringBuilder sb = new StringBuilder();
        int dice1, dice2;
        int sum;
        int tryCount = 100000000;
        int count[] = new int[11];

        for (int i = 0; i < tryCount; i++) {
            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);

            sum = dice1 + dice2;
            count[sum - 2]++;
        }
        sb.append("주사위의 총합\t평균 굴림 횟수\n");
        sb.append("=============\t==============\n");
        for (int j = 0; j < count.length; j++) {
            sb.append("      " + (j+2) + "    \t     " + (((double) count[j] / (double) tryCount) * 100.0) + "\n");
        }
        System.out.print(sb);
    }
}

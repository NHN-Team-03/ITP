import java.util.ArrayList;
import java.util.List;

public class P6 {
    public static void main(String[] args) {
        int[] count = new int[10001];
        int maxCount = 0;
        List<Integer> maxValue = new ArrayList<Integer>();

        for (int i = 1; i < count.length; i++) {

            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    count[i + 1]++;
                }
            }

            if (maxCount < count[i + 1]) {
                maxValue.clear();
                maxCount = count[i + 1];
                maxValue.add(i);
            } else if (maxCount == count[i + 1]) {
                maxValue.add(i);
            }

        }
        maxCount += 1;
        System.out.println("1과 10000 사이의 정수 중에서,\n약수의 최 갯수는 " + maxCount + "\n이러한 약수의 갯수를 가진 숫자들은 : ");
        for (int k = 0; k < maxValue.size(); k++) {
            System.out.println("\t" + maxValue.get(k));
        }
    }
}

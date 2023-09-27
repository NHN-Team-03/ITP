public class P2 {
    public static void main(String[] args) {
        int[] count = new int[10001];
        int maxCount = 0;
        int max = 0;

        for (int i = 1; i < count.length; i++) {

            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    count[i + 1]++;
                }
            }

            if (maxCount <= count[i + 1]) {
                maxCount = count[i + 1];
                max = i;
            }

        }
        maxCount += 1;
        System.out.println("max value : " + max);
        System.out.println("max value have count : " + maxCount);
    }
}

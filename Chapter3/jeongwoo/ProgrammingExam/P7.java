public class P7 {
    public static void main(String[] args) {
        threeSameBirthday();
        allPersonKindOfBirthday();
        allPersonTrue();
    }

    private static void allPersonTrue() {
        int runCount = 0;
        boolean person[] = new boolean[365];
        int count = 0;
        int birthday;
        while (count != 365) {
            runCount++;
            birthday = (int) (Math.random() * 365);
            if (!person[birthday]) {
                person[birthday] = true;
                count++;
            }
        }
        System.out.println("실행 횟수 : " + runCount);
    }

    private static void allPersonKindOfBirthday() {
        int person[] = new int[365];
        int birthday;
        for (int i = 0; i < 365; i++) {
            birthday = (int) (Math.random() * 365);
            person[birthday]++;
        }

        int count = 0;
        for (int j = 0; j < 365; j++) {
            if (person[j] != 0) {
                // System.out.println((j+1) + "번째 생일인 사람의 수" + person[j]);
                count++;
            }
        }
        System.out.println("다양함의 정도 : " + count);
    }

    private static void threeSameBirthday() {
        int person[] = new int[365];
        int count = 0;
        int birthday = 0;
        while (true) {
            birthday = (int) (Math.random() * 365);
            person[birthday]++;
            count++;
            if (person[birthday] == 3) {
                break;
            }
        }
        System.out.println("같은 생일이 세명이 나올때 까지 뽑은 사람은 수 : " + count);
    }
}

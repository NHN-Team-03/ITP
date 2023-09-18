package Chapter4.damho.src.Exercise;

public class Exercise4 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        double sum = 0;

        for (int i = 2; i < 13; i++) {
            for (int j = 0; j < 10000; j++) {
                sum += Exercise3.diceRoll(i);
            }
            sb.append("주사위의 총합 : " + i + " 의 평균 굴림 횟수 = " +sum/10000 + "\n");
            sum = 0;
        }
        System.out.println(sb.toString());
    }
}


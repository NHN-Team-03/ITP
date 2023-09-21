package Chapter3.yongjun.src.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise7 {
    public static void main(String[] args) {
        tripleSameBirthDay();
        randomPeopleBirthDay();
        allDaysIsBirthDay();
    }

    private static void allDaysIsBirthDay() {
        int[] days = new int[365];
        // List<Integer> list = Stream.of(days).collect(Collectors.toList());

        // Arrays.asList(days);

        for (int i = 0;; i++) {
            int dayNum = (int) (Math.random() * 365);
            days[dayNum]++;
            List<Integer> list = Arrays.stream(days)
                    .boxed()
                    .collect(Collectors.toList());
            if (list.contains(0)) {
                ;
            } else {
                System.out.println("365일 모두 생일인 경우 "+ i);
                break;
            }
        }

    }

    private static void randomPeopleBirthDay() {
        int[] days = new int[365];
        int count = 0;
        for (int i = 0; i < days.length; i++) {
            int dayNum = (int) (Math.random() * 365);
            days[dayNum]++;
            if (days[dayNum] == 1) {
                count++;
            }
        }
        System.out.println("365명의 생일" + count);

    }

    private static void tripleSameBirthDay() {
        int[] days = new int[365];
        for (int i = 0;; i++) {
            int dayNum = (int) (Math.random() * 365);
            days[dayNum]++;
            if (days[dayNum] == 3) {
                System.out.println("3명의 생일이 같기 위한 인원" + i);
                break;
            }
        }
    }

}

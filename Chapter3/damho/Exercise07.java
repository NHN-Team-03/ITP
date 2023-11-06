package Chapter3.damho;

import java.util.Random;

public class Exercise07 {
    public static boolean checkBirthdayArr(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int birthday1;
        int birthday2;
        int birthday3;
        int count;

        // case 1
        count = 0;
        do {
            count++;
            birthday1 = random.nextInt(365);
            birthday2 = random.nextInt(365);
            birthday3 = random.nextInt(365);
        } while (birthday1 != birthday2 && birthday2 != birthday3);
        System.out.println("생일이 같은 세 사람을 찾으려면 무작위로 몇명을 뽑아야 하는가? " + (count * 3) + "명");

        // case 2
        count = 0;
        boolean[] birthdays = new boolean[365];
        for (int i = 0; i < birthdays.length; i++) {
            birthdays[random.nextInt(365)] = true;
        }
        for (int i = 0; i < birthdays.length; i++) {
            if (birthdays[i]) {
                count++;
            }
        }
        System.out.println("365명을 무작위로 선택한다고 가정하자. 그들은 다른 생일들을 얼마나 가질 것인가? " + count + "개");

        // case 3
        birthdays = new boolean[365];
        while (!checkBirthdayArr(birthdays)) {
            birthdays[random.nextInt(365)] = true;
            count++;
        }
        System.out.println("한 해의 365일 각각마다 생일이 있는 사람을 적어도 한 명 찾으려면 얼마나 많은 다른 사람을 확인해야 하는가? " + count + "명");
    }
}

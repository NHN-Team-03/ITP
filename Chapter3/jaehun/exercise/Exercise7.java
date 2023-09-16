package Chapter3.jaehun.exercise;

public class Exercise7 {
    public static void main(String[] args) {
        int[] days;
        boolean[] dayCheck;
        boolean booleanCheck;
        int randomNumber;
        int count;

        count = 0;
        days = new int[365];
        while (true) {
            randomNumber = (int) (Math.random() * 365);
            count++;

            days[randomNumber]++;

            if (days[randomNumber] == 3) {
                break;
            }
        }

        System.out.println(count);

        count = 0;
        dayCheck = new boolean[365];
        for (int i = 0; i < 365; i++) {
            int random = (int) (Math.random() * 365);

            if (dayCheck[random] == false) {
                dayCheck[random] = true;
                count++;
            }
        }

        System.out.println(count);

        count = 0;
        dayCheck = new boolean[365];
        while (true) {
            booleanCheck = true;
            int random = (int) (Math.random() * 365);

            if (dayCheck[random] == false) {
                dayCheck[random] = true;
            }
            count++;

            for(int i = 0; i < 365; i++) {
                if(dayCheck[i] == false) {
                    booleanCheck = false;
                }
            }

            if(booleanCheck) {
                break;
            }
        }

        System.out.println(count);
    }
}

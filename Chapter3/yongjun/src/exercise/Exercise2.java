package Chapter3.yongjun.src.exercise;

public class Exercise2 {
    public static void main(String[] args) {
        int maxcount = 0;
        int maxnum = 0;
        for (int i = 1; i <= 10000; i++) {
            int count = 1;
            for (int j = 1; j <= i/2; j++) {
                if(i%j == 0){
                    count++;
                }
            }
            if(count > maxcount){
                maxcount = count;
                maxnum = i;
            }
        }
        System.out.println(maxnum + " " + maxcount);
        
    }
}

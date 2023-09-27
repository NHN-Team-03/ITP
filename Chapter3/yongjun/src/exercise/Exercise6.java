package Chapter3.yongjun.src.exercise;

import java.util.ArrayList;
import java.util.List;

public class Exercise6 {
    public static void main(String[] args) {
        int maxcount = 0;
        int maxnum = 0;
        List<Integer> list = new ArrayList<>();

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
                list.clear();
                list.add(maxnum);
            }
            else if ( count == maxcount){
                list.add(i);

            }
        }
        System.out.println(list + " " + maxcount);
        
    }
    
}

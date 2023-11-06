package exercise;

import java.util.ArrayList;

public class Exercise1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = createArrayList(15, 100);

        for(int value : list) {
            System.out.println(value);
        }
        
    }

    public static ArrayList<Integer> createArrayList(int size, int maxValue) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            list.add((int)(Math.random() * maxValue) + 1);
        }
        return list;
    }
}

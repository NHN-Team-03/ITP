package exercise.exercise3;

public class exercise3 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>(17);
        hm.put(1, 1);
        hm.put(2, 2);
        hm.put(3, 3);
        hm.put(4, 4);
        hm.put(5, 5);
        hm.put(6, 6);
        hm.put(7, 7);
        hm.put(8, 8);
        hm.put(9, 9);
        hm.put(17, 17);
        hm.put(34, 34);
        hm.put(51, 51);
        hm.put(68, 68);
        hm.printHashMap();

        System.out.println(hm.containsKey(9));
        System.out.println(hm.remove(34));
        System.out.println(hm.remove(51));
        hm.printHashMap();
        System.out.println(hm.size());

    }
}

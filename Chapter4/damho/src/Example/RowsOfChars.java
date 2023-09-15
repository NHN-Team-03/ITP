package Chapter4.damho.src.Example;

public class RowsOfChars {
    private static void printValuesInList(int[] list) {
        System.out.print("[");
        for (int i = 0; i < list.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(list[i]);
        }
        System.out.println("]");
    }

    private static void printRow(char ch, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    private static void printRowsFromString(String str) {
        for (int i = 0; i < str.length(); i++) {
            printRow(str.charAt(i), 25);
        }
    }

    public static void main(String[] args) {
        printRowsFromString("Hello, world!");
        printValuesInList(new int[] { 1, 2, 3, 4, 5, 6 });
    }
}

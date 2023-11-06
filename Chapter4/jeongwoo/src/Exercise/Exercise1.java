package exercise;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        printCapitalized(str);
        s.close();
    }

    private static void printCapitalized(String str){
        StringBuilder sb = new StringBuilder();
        String words[] = str.split(" ");

        for(String word : words){
            sb.append(Character.toUpperCase(word.charAt(0)));
            for(int i = 1;i<word.length();i++){
                sb.append(word.charAt(i));
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }
}

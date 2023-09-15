package Exercise;

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
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);

            if(Character.isLetter(ch)){
                ch = Character.toUpperCase(ch);
                sb.append(ch);
                continue;
            }

            sb.append(ch);
        }

        System.out.println(sb);
    }
}

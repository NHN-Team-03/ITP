import java.io.*;
import java.util.*;

public class Quiz6 {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter your first name and last name, separated by a space.: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] names = br.readLine().split(" ");
        char[][] nameChr = {names[0].toCharArray(), names[1].toCharArray()};

        StringBuilder sb = new StringBuilder();
        sb.append("Your first name is ")
                .append(names[0])
                .append(", which has ")
                .append(nameChr[0].length)
                .append(" characters")
                .append("\nYour last name is ")
                .append(names[1])
                .append(", which has ")
                .append(nameChr[1].length)
                .append(" characters")
                .append("\nYour initials are ")
                .append(String.valueOf(nameChr[0][0]))
                .append(String.valueOf(nameChr[1][0]));

        System.out.println(sb);
    }
}
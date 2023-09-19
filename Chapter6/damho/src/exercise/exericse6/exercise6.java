package exercise.exericse6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class exercise6 {
    public static void addStringToList(String inputString, List<String> list) {
        String[] strArr = inputString.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i].toLowerCase();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (Character.isAlphabetic(ch) || ch == '\'') {
                    builder.append(ch);
                }
            }
            list.add(builder.toString());
            builder.setLength(0);
        }
    }

    public static void sortStringList(List<String> list) {
        Collections.sort(list);
    }

    public static void printList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File("Chapter6/damho/src/exercise/exericse6/test.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        addStringToList(reader.readLine(), list);
        sortStringList(list);
        printList(list);
    }
}

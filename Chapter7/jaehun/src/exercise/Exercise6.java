package exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise6 {
    public static void main(String[] args) throws IOException {
        File file = new File("Chapter7/jaehun/src/exercise/Directory.txt");

        ArrayList<String> list = readFile(file);

        sort(list);

        for (String word : list) {
            System.out.println(word);
        }
    }

    private static void sort(ArrayList<String> list) {
        Collections.sort(list);
    }

    private static ArrayList<String> readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.toLowerCase();
            String[] words = line.split(" ");

            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                sb.delete(0, sb.length());
                for (int i = 0; i < word.length(); i++) {
                    if (Character.isLetter(word.charAt(i))) {
                        sb.append(word.charAt(i));
                    }
                }

                addWord(list, sb.toString());
            }
        }

        br.close();
        return list;
    }

    private static void addWord(ArrayList<String> list, String string) {
        if (list.indexOf(string) == -1) {
            list.add(string);
        }
    }
}

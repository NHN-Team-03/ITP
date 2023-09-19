package exercise.exercise6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise6 {

    public static void main(String[] args) {

        File file = new File("seungjo/src/exercise/exercise6/dictionary.txt");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            List<String> list = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                if (list.indexOf(line) == -1) {
                    list.add(line);
                }
            }

            Collections.sort(list);
            for (String word : list) {
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

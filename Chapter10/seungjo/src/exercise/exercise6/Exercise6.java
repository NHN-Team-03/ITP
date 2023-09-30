package exercise.exercise6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise6 {

    public static void main(String[] args) {

        Map<String, Integer> index;

        String path = "./Chapter10/seungjo/src/exercise/exercise6/book.txt";
        File file = new File(path);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            index = new TreeMap<>();
            String line;
            while ((line = br.readLine()) != null) {
                insertIndex(index, line);
            }

            printIndex(index);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void insertIndex(Map<String, Integer> index, String line) {

        // TODO: line을 읽어온 다음 띄어쓰기를 기준으로 자른다.
        StringTokenizer st = new StringTokenizer(line, " ");

        while (st.hasMoreTokens()) {

            // TODO: 각 토큰에 존재하는 특수문자 제거 및 소문자로 변경
            String word = st.nextToken();
            word = removeSpecial(word);


            // TODO: 만약 그 토큰이 3글자 이상이면 index.put()

            if (word.length() >= 3 && !(word.equals("the"))) {
                index.put(word, index.getOrDefault(word, 1) + 1);
            }
            // TODO: 그렇지 않다면 버리기
        }
    }

    public static void printIndex(Map<String, Integer> index) {
        for (Map.Entry<String, Integer> entry : index.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static String removeSpecial(String word) {
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        word = word.replaceAll(match, "");
        word = word.toLowerCase();
        return word;
    }
}

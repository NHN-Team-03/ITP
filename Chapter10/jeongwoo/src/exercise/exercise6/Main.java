package exercise.exercise6;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    private static class WordData {
        private String word;
        int count;

        private WordData(String name) {
            word = name;
            count = 1;
        }

        public String getWord() {
            return word;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return this.getWord() + " (" + this.getCount() + ")";
        }
    }

    private static TreeMap<String, WordData> words;

    public static void main(String[] args) {
        FileReader fileReader;
        words = new TreeMap<>();
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;
        try {
            fileReader = new FileReader("Ch10/src/exercise/exercise6/book.txt");
            bufferedReader = new BufferedReader(fileReader);

            String line;
            String word;
            while ((line = bufferedReader.readLine()) != null) {
                stringTokenizer = new StringTokenizer(line);

                while (stringTokenizer.hasMoreTokens()) {
                    word = readWord(stringTokenizer.nextToken());
                    if (word == null) {
                        continue;
                    }

                    addData(word);

                }
            }

        } catch (FileNotFoundException exception) {
            System.out.println("파일이 없어욧!");
            System.exit(0);
        } catch (IOException exception) {
            System.out.println("라인이 없어욧!");
        }

        printWords();
    }

    private static void addData(String word){
        if(words.get(word) != null){
            words.get(word).setCount(words.get(word).getCount() + 1);
            return;
        }

        words.put(word,new WordData(word));
    }

    private static String readWord(String word) {
        char ch;
        word = word.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if(('a' <= ch && ch <= 'z')){
                stringBuilder.append(ch);
            }
        }

        if(stringBuilder.isEmpty() || stringBuilder.length() <= 3){
            return null;
        }

        return stringBuilder.toString();
    }

    private static void printWords(){
        if(words.isEmpty()){
            System.out.println("빈 공간입니다.!");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("알파벳 순으로 정렬\n\n");
        for(WordData word : words.values()){
            stringBuilder.append(word+ "\n");
        }

        stringBuilder.append("\n개수 순으로 정렬\n\n");
        List<WordData> wordList = new ArrayList<>(words.values());
        wordList.sort(new Comparator<WordData>() {
            @Override
            public int compare(WordData o1, WordData o2) {
                return o1.getCount() - o2.getCount();
            }
        });

        for (WordData word : wordList){
            stringBuilder.append(word+ "\n");
        }

        System.out.println(stringBuilder);


    }
}

package exercise.exercise6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Read {
    private Map<String, Set<Integer>> wordMap;
    private int count;

    public Read(String path) {
        wordMap = new TreeMap<>();

        readFile(path);
    }

    private void readFile(String path) {
       try {
           BufferedReader br = new BufferedReader(new FileReader(path));

           String line;
           
           while((line = br.readLine()) != null) {
               count++;
               line = line.toLowerCase();
               
               readLine(line);
           }
       } catch(IOException e) {
           e.printStackTrace();
       }
    }

    private void readLine(String line) {
        StringBuilder sb = new StringBuilder();
        for(char ch : line.toCharArray()) {
            if(ch == ' ') {
                addWord(sb.toString());
                sb.delete(0, sb.length());
            } else {
                if(Character.isLetter(ch)) {
                sb.append(ch);
            }
            }
            
        }
    }

    private void addWord(String word) {
        if(word.equals("the") || word.length() < 3) {
            return;
        }
        if(wordMap.get(word) == null) {
            TreeSet<Integer> set = new TreeSet<>();

            set.add(count);
            wordMap.put(word, set);
        } else {
            wordMap.get(word).add(count);
        }


    }

    public void printWord() {
        for (Map.Entry<String, Set<Integer>> entry : wordMap.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for(int index : entry.getValue()) {
                System.out.print(index + " ");
            }
            System.out.println();
        }
    }
}

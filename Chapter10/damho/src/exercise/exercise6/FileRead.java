package exercise.exercise6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class FileRead {
    private TreeMap<String, TreeSet<Integer>> wordsCount;
    private BufferedReader reader;
    private int currentLineNum = 0;

    public FileRead(File file) throws FileNotFoundException {
        this.wordsCount = new TreeMap<>();
        try {
            this.reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException fileNotFoundException) {
            throw new FileNotFoundException("파일을 찾을 수 없습니다.");
        }
    }

    public void readFile() {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                currentLineNum++;
                makeData(line);
            }
        } catch (IOException exception) {
            System.out.println("IOException error");
        }
    }

    public void makeData(String inputString) {
        StringTokenizer token = new StringTokenizer(inputString, " ");
        StringBuilder builder = new StringBuilder();
        char ch;
        while (token.hasMoreTokens()) {
            String target = token.nextToken();
            for (int i = 0; i < target.length(); i++) {
                ch = target.charAt(i);
                if (!Character.isAlphabetic(ch)) {
                    continue;
                }
                builder.append(ch);
            }
            if (builder.length() != 0) {
                putData(builder.toString());
            }
            builder.setLength(0);
        }
    }

    public void putData(String inputString) {
        if (wordsCount.containsKey(inputString)) {
            wordsCount.get(inputString).add(currentLineNum);
        } else {
            TreeSet<Integer> treeSet = new TreeSet<>();
            treeSet.add(currentLineNum);
            wordsCount.put(inputString, treeSet);
        }
    }

    public void printData() {
        for (Entry<String, TreeSet<Integer>> entry : wordsCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

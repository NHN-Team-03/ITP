import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Quiz7 {
    public static void main(String[] args) throws IOException {
        String path = "/Users/mate/IdeaProjects/ITP/Chapter2/TA/quiz/testdata.txt";

        //BufferedReader
        BufferedReader br = new BufferedReader(new FileReader(path));
        //FileReader
        FileReader fr = new FileReader(path);
        //Scanner
        Scanner sc = new Scanner(new File(path));
        //Files *Non-Blocking Input/Output
        List<String> fs = Files.readAllLines(Paths.get(path));

        String name = br.readLine();
        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        int last = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append("Name: ")
                .append(name)
                .append(", Aver Score: ")
                .append((first + second + last) / 3);

        System.out.println(sb);
    }
}
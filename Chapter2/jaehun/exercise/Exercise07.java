package Chapter2.jaehun.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Chapter2/jaehun/exercise/testdata.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String name;
        int score1, score2, score3;
        double avg;

        try {
            name = br.readLine();
            score1 = Integer.parseInt(br.readLine());
            score2 = Integer.parseInt(br.readLine());
            score3 = Integer.parseInt(br.readLine());

            avg = (score1 + score2 + score3) / 3;
            System.out.println(name + " average score is " + avg);

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

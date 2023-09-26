package Chapter2.damho;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exam2_7 {
    public static void main(String[] args) throws IOException {
        File file;
        BufferedReader br = null;
        String inputString;
        String name;
        int firstTestScore;
        int secondTestScore;
        int thirdTestScore;
        double average;
        try {
            file = new File("Chapter2/damho/testdata.txt");
            br = new BufferedReader(new FileReader(file));
            while (true) {
                inputString = br.readLine();
                if (inputString == null) {
                    break;
                }
                name = inputString;

                inputString = br.readLine();
                if (inputString == null) {
                    break;
                }
                firstTestScore = Integer.parseInt(inputString.trim());

                inputString = br.readLine();
                if (inputString == null) {
                    break;
                }
                secondTestScore = Integer.parseInt(inputString.trim());

                inputString = br.readLine();
                if (inputString == null) {
                    break;
                }
                thirdTestScore = Integer.parseInt(inputString.trim());

                average = (double) (firstTestScore + secondTestScore + thirdTestScore) / 3;
                System.out.println(name + "'s average of score = " + average);
            }
            br.close();
        } finally {
            br.close();
        }

    }
}

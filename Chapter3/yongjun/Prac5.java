package Chapter3.yongjun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Prac5 {
    public static void main(String[] args) throws IOException {
        String filepath = "/Users/jun/Desktop/ITP/Chapter3/yongjun/sales.dat";
        BufferedReader bufferedReader;

        try {
            FileReader fileReader = new FileReader(new File(filepath));
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
        double total = 0;
        int city = 0;
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            try {
                String[] strings = str.split(":");
                total += Double.valueOf(strings[1]);
            } catch (NumberFormatException e) {
                 city++;
            }
        }
        System.out.println(total);
        System.out.println(city);

    }
}

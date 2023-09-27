package Chapter3.jaehun.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise5 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Chapter3/jaehun/exercise/sales.dat");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line; // 파일에서 한줄 읽어올 variable
        int colonIndex; // :의 index를 찾기 위한 variable
        double value; // 한 도시의 매출 값
        double result; // 총 매출
        int count; // 매출을 알 수 없는 도시의 수를 체크하기 위한 variable

        result = 0;
        count = 0;
        try {
            while ((line = br.readLine()) != null) {
                colonIndex = line.indexOf(":");

                line = line.substring(colonIndex + 1).trim();

                try {
                    value = Double.valueOf(line);
                    result += value;
                } catch (NumberFormatException exception) {
                    count++;
                }
            }

            br.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        System.out.println("총 매출 : " + result);
        System.out.println("데이터가 없는 도시의 수 : " + count);
    }
}

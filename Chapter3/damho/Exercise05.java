package Chapter3.damho;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exercise05 {
    public static void main(String[] args) throws IOException {
        File file = new File("Chapter3/damho/sales.dat");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ;
        String inputString;
        double sum;
        int nunmberOfData;
        int numberOfNoData;

        sum = 0;
        nunmberOfData = 0;
        numberOfNoData = 0;
        
        while ((inputString = br.readLine()) != null) {
            try {
                sum += Double.valueOf(inputString.substring(inputString.indexOf(":") + 1));
                nunmberOfData++;
            } catch (NumberFormatException e) {
                numberOfNoData++;
            }
        }
        System.out.println("평균 매출 : " + sum/nunmberOfData + " 데이터가 없는 경우 : " + numberOfNoData);
        br.close();
    }
}

package Chapter11.jaehun.src.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseFileWithScanner {
    public static void main(String[] args) {
        Scanner data;
        PrintWriter result;

        ArrayList<Double> number;

        number = new ArrayList<>();

        try {
            data = new Scanner(new File("Chapter11/jaehun/example/data.dat"));
        } catch(FileNotFoundException e) {
            System.out.println("data.dat 파일을 찾을 수 없습니다.");
            return;
        }

        try {
            result = new PrintWriter("Chapter11/jaehun/example/result.dat");
        } catch (FileNotFoundException e) {
            System.out.println("result.dat 파일을 열 수 없습니다.");
            System.out.println("오류 : " + e);
            data.close();
            return;
        }

        while(data.hasNextDouble()) {
            double inputNumber = data.nextDouble();
            number.add(inputNumber);
        }

        for(int i = number.size() - 1 ; i >= 0; i--) {
            result.println(number.get(i));
        }

        System.out.println("완료");

        data.close();
        result.close();
    }

}
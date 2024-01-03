package exercise.exercise6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise6 {
    public static File makeFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("파일 경로 입력 : ");
        String fileName = scanner.nextLine();
        return new File(fileName);
    }

    public static void main(String[] args) {
        File file = makeFile();
        FileRead fileRead;
        try {
            fileRead = new FileRead(file);
        } catch (FileNotFoundException exception) {
            exception.getMessage();
            return;
        }

        fileRead.readFile();
        fileRead.printData();
    }
}
// 파일 경로 :
// Chapter10/damho/src/exercise/exercise6/exercise6.txt
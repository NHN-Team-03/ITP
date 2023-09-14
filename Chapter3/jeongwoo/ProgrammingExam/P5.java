import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P5 {
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new FileReader("./Ch3/ProgrammingExam/sales.dat"));
            String str;
            while ((str = reader.readLine()) != null) {
                String[] s = str.split(":");
                System.out.print(s[0] + " : ");
                try {
                    System.out.println(Double.parseDouble(s[1]));
                } catch (NumberFormatException e) {
                    System.out.println("형 변환 예외 Error");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일 열기 에러");
        } catch (IOException e) {
            System.out.println("IOException 발생");
        }

    }
}

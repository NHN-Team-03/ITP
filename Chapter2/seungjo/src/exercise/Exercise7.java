package exercise;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Exercise7 {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        
        File file = new File("./Chapter2/seungjo/src/quiz/testdata.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br  =new BufferedReader(fr);
        
            String name = br.readLine();
            double avg = 0;
            for (int i = 0; i < 3; i++) {
                avg += Integer.parseInt(br.readLine());
            }

            System.out.println("Your name is " + name);
            System.out.println("Average: " + avg / 3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    

    }

}

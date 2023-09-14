package Chapter2.YongJun;

import java.io.*;

public class prac7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        try {
            FileReader file = new FileReader(new File("./Chapter2/YongJun/testdata.txt"));
            br = new BufferedReader(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String name = br.readLine();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        System.out.println(name + " " + (a+b+c)/3);

    }
}

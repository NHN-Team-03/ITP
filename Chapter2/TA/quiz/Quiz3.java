import java.io.*;

public class Quiz3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println("What's your name?");

        String name = br.readLine();
        sb.append("Hello, ")
                .append(name)
                .append(", nice to meet you!");

        System.out.println(sb);
    }
}
import java.io.*;

public class Quiz5 {
    public static void main(String[] args) throws IOException {
        System.out.println("Eggs: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int eggs = Integer.parseInt(br.readLine());
        int gross, dozen;

        gross = eggs/144;
        eggs %= 144;
        dozen = eggs/12;
        eggs %= 12;

        boolean isGrossOrDozen = false;
        StringBuilder sb = new StringBuilder();
        sb.append("Your number of eggs is ");
        if(gross > 0) {
            sb.append(gross).append(" gross, ");
            isGrossOrDozen = true;
        }
        if(dozen > 0) {
            sb.append(dozen).append(" dozen, ");
            isGrossOrDozen = true;
        }
        if(isGrossOrDozen) {
            sb.append("and ");
        }
        sb.append(eggs);

        System.out.println(sb);
    }
}
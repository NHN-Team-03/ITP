import java.io.*;

public class Quiz4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int quater = 0, dime = 0, nickel = 0, penny = 0;

        System.out.println("Quater: ");
        quater = Integer.parseInt(br.readLine());
        System.out.println("Dime: ");
        dime = Integer.parseInt(br.readLine());
        System.out.println("Nickel: ");
        nickel = Integer.parseInt(br.readLine());
        System.out.println("penny: ");
        penny = Integer.parseInt(br.readLine());

        float dollar = (quater * 25 + dime * 10 + nickel * 5 + penny) / 100f;

        System.out.printf("%.2f", dollar);
    }
}
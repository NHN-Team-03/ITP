package exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) {
        File file = new File("./exercise/sales.dat");
        int notSales = 0;
        double total = 0;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String input = "";

            while ((input = br.readLine()) != null) {
                
                try {
                    String[] str = input.split(": ");
                    double sale = Double.parseDouble(str[1]);
                    total += sale;

                } catch (NumberFormatException e) {
                    notSales++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("total sales: " + total);
        System.out.println("not sales city: " + notSales);
    }
}

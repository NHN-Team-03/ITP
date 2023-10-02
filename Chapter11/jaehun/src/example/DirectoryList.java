package Chapter11.jaehun.src.example;

import java.io.File;
import java.util.Scanner;

public class DirectoryList {
    public static void main(String[] args) {
        String directoryName;
        File directory;
        String[] files;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a directory name : ");
        directoryName = scanner.nextLine();

        directory = new File(directoryName);

        if(directory.isDirectory() == false) {
            if(directory.exists() == false) {
                System.out.println("There is no such Directory!");
            } else {
                System.out.println("That file is not directory");
            }
        } else {
            files = directory.list();
            System.out.println("Files in directory \"" + directory + "\" :");
            for(String file : files) {
                System.out.println(file);
            }
        }
    }    
}
